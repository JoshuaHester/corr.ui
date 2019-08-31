package rekaur.ia;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;

public class GameWindow extends javax.swing.JFrame {

    private JFrame baseWindow;
    private int width = 800;
    private int height = 600;
    private String directoryFilepath = "C:/Dev/Projects/production/rekaur.ia/rekaur/ia";
    private String backgroundFilepath ="Art/krlogo.png";
    private JLabel background;

    public GameWindow(String windowName) {
        baseWindow = new JFrame(windowName);
        baseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        baseWindow.setSize(width,height);
        baseWindow.setVisible(true);
        setGameIcon("Art/kricon.png");
        setBackgroundImage(backgroundFilepath);
    }

    public GameWindow() {
        new GameWindow("Game");
    }

    public void changeWindowSize(int width, int height){
        baseWindow.setSize(width, height);
        this.width = width;
        this.height = height;
    }

    public void setFullScreen(){
        baseWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void setGameIcon(String iconFilepath){
        Image image = convertPathToImage(iconFilepath);
        baseWindow.setIconImage(image);
    }

    public void setBackgroundImage(String backgroundFilepath){
        Image image = convertPathToImage(backgroundFilepath);
        background = new JLabel(new ImageIcon(image));
        baseWindow.getContentPane().add(background);
        baseWindow.setVisible(true);
    }

    public void setDirectory(String filepath){
        directoryFilepath = filepath;
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

    public static void main(String args[]) {
        GameWindow gui = new GameWindow("test");
        //gui.setFullScreen();
    }
}
