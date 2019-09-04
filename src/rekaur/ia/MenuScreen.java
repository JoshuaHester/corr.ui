package rekaur.ia;
import javax.swing.*;
import javax.imageio.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.awt.event.MouseListener;
import java.io.*;

public class MenuScreen extends JPanel{
    private int width = 400;
    private int height = 500;

    public MenuScreen(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setSize(width,height);
        setVisible(true);
    }

    public void addButton(String name, GameFunction function){
        add(new MenuButton(name,function));
        setVisible(true);
    }


}
