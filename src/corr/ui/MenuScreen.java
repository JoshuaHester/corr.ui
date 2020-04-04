package corr.ui;
import javax.swing.*;
import java.awt.*;

public class MenuScreen extends JPanel{
    private final static int defaultWidth = 300;
    private final static int defaultHeight = 500;
    private String name = "menu";

    public MenuScreen(int width,int height, String name){
        super();
        this.name = name;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setSize(width,height);
        setOpaque(true);
        JLabel label = new JLabel(name);
        label.setAlignmentX(CENTER_ALIGNMENT);
        add(label);
        setBackground(Color.orange);
    }

    public MenuScreen(){
        this(defaultWidth,defaultHeight);
    }

    public MenuScreen(int width,int height){
        this(width,height,"menu");
    }

    public void addButton(String name, GameFunction function){
        MenuButton button = new MenuButton(name,function);
        button.setAlignmentX(CENTER_ALIGNMENT);
        add(button);
    }

    public String getName(){
        return name;
    }
}
