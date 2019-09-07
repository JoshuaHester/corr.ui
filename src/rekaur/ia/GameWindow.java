package rekaur.ia;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
    private String backgroundFilepath = "rekaur/ia/Art/krlogo.png";
    private String iconFilepath = "rekaur/ia/Art/kricon.png";
    private JLabel background;
    private GraphicsDevice graphicsHandler;

    public GameWindow(String windowName, int width, int height) {
        setDirectory();
        setDefaultDimensions(width, height);
        baseWindow = new JFrame(windowName);
        baseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseWindow.setResizable(false);
        graphicsHandler = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        setGameIcon(iconFilepath);
        setBackgroundImage(backgroundFilepath);

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
        int widthRatio = width / defaultWidth;
        int heightRatio = height / defaultHeight;
        if(graphicsHandler.isDisplayChangeSupported()){
            graphicsHandler.setDisplayMode(new DisplayMode(width, height, bitdepth, refreshRate));
        }
        //rescales the individual components
        for(int i = 0; i<baseWindow.getComponentCount();i++){
            baseWindow.getComponent(i).setSize(
                    widthRatio * baseWindow.getComponent(i).getWidth(),
                    heightRatio * baseWindow.getComponent(i).getHeight()
            );

        }

    }

    public void setFullScreen(){
        graphicsHandler.setFullScreenWindow(baseWindow);

        baseWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void addScreen(Component component, int index){
        baseWindow.add(component);
        baseWindow.getLayeredPane().setLayer(component,index);
        baseWindow.setVisible(true);
    }

    public void setGameIcon(String iconFilepath){
        Image image = convertPathToImage(iconFilepath);
        baseWindow.setIconImage(image);
    }

    public void setBackgroundImage(String backgroundFilepath){
        Image image = convertPathToImage(backgroundFilepath);
        background = new ImageLabel(new ImageIcon(image));
        addScreen(background,-30000);
    }

    public void setDirectory(){
        URL location = getClass().getProtectionDomain().getCodeSource().getLocation();
        directoryFilepath = location.getPath();
    }

    public void setDefaultDimensions(int width, int height){
        defaultWidth = width;
        defaultHeight = height;
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
