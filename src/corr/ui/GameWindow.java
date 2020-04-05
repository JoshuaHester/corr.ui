package corr.ui;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.net.URL;

public class GameWindow{
    private static final int width = 800;
    private static final int height = 600;

    private JFrame baseWindow;
    private int defaultWidth;
    private int defaultHeight;
    private int bitdepth = 32;
    private int refreshRate = 60;
    private String directoryFilepath;
    private String backgroundFilepath = "corr/ui/Art/krlogo.png";
    private String iconFilepath = "corr/ui/Art/kricon.png";
    private JLabel background;
    private GraphicsDevice graphicsHandler;
    private JLayeredPane layeredPane;

    public GameWindow(String windowName, int width, int height) {

        setDirectory();
        setDefaultDimensions(width, height);
        new Scalable(width,height);
        baseWindow = new JFrame(windowName);

        baseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseWindow.setResizable(false);
        setGameIcon(iconFilepath);

        baseWindow.setLayout(new BorderLayout());
        graphicsHandler = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        //background
        setBackgroundImage();
        //layeredPane
        layeredPane = new JLayeredPane();
        layeredPane.setMinimumSize(new Dimension(640,480));
        Scalable.addComponent(layeredPane);
        baseWindow.add(layeredPane, BorderLayout.CENTER);
        //menu layer



        setFullScreen();
        changeWindowSize(defaultWidth,defaultHeight);
    }

    public GameWindow() {
        this("game");
    }

    public GameWindow(String windowName){
        this(windowName,width,height);
    }

    public void changeWindowSize(int width, int height){
        if(graphicsHandler.isDisplayChangeSupported()){
            graphicsHandler.setDisplayMode(new DisplayMode(width, height, bitdepth, refreshRate));
        }
        Scalable.scaleComponents(width,height);
    }

    public void setFullScreen(){
        graphicsHandler.setFullScreenWindow(baseWindow);
    }
    public void addScreen(Component component, int index){
        layeredPane.setLayer(component,index);
        layeredPane.add(component);
    }

    public void addMenuPanel(CardPanel panel){
        addScreen(panel,300);
    }

    public void setGameIcon(String iconFilepath){
        Image image = convertPathToImage(iconFilepath);
        baseWindow.setIconImage(image);
    }

    /**
     * Sets the background image using the provided filepath.
     * The image will automatically resize to fit the screen.
     * @param backgroundFilepath filepath of the image to be used
     */
    public void setBackgroundImage(String backgroundFilepath){
        Image image = convertPathToImage(backgroundFilepath);
        background = new ScalableImageLabel(new ImageIcon(image));
        baseWindow.getLayeredPane().setLayer(background,-3000);
        baseWindow.add(background,BorderLayout.CENTER);
    }

    /**
     * Sets the background using the default file.
     * @see GameWindow setBackgroundImage(String backgroundFilepath)
     */
    public void setBackgroundImage(){
        setBackgroundImage(backgroundFilepath);
    }

    public void setDirectory(){
        URL location = getClass().getProtectionDomain().getCodeSource().getLocation();
        directoryFilepath = location.getPath();
    }

    /**
     * Sets the starting dimensions of the window.
     * This is primarily used for scaling components during resize.
     * @param width the starting width.
     * @param height the starting height
     */
    public void setDefaultDimensions(int width, int height){
        defaultWidth = width;
        defaultHeight = height;
    }

    public JFrame getFrame(){
        return baseWindow;
    }

    Image convertPathToImage(String filepath){
        Image image;
        try{
            image = ImageIO.read(new File(getFullPath(filepath)));
            return image;
        }catch(Exception e){
            /* TODO: add an error popup if file is not found */
            System.out.println("error");
        }
        return null;
    }

    String getFullPath(String filepath){
        String path = directoryFilepath + "/" + filepath;
        return path;
    }


}
