package rekaur.ia;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.net.URL;

public class GameWindow{

    private JFrame baseWindow;
    private int width = 800;
    private int height = 600;
    private String directoryFilepath;
    private String backgroundFilepath = "rekaur/ia/Art/krlogo.png";
    private String iconFilepath = "rekaur/ia/Art/kricon.png";
    private JLabel background;

    public GameWindow(String windowName) {
        setDirectory();
        baseWindow = new JFrame(windowName);
        baseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseWindow.setSize(width,height);
        baseWindow.setResizable(false);
        setGameIcon(iconFilepath);
        setBackgroundImage(backgroundFilepath);
    }

    public GameWindow() {
        new GameWindow("Game");
    }

    public void changeWindowSize(int width, int height){
        baseWindow.setSize(width, height);
        this.width = width;
        this.height = height;
        /* TODO add resolution scaling */
    }

    public void setFullScreen(){
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
        background = new JLabel(new ImageIcon(image));
        addScreen(background,-30000);
    }

    public void setDirectory(){
        URL location = getClass().getProtectionDomain().getCodeSource().getLocation();
        directoryFilepath = location.getPath();
        System.out.println(directoryFilepath);
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
