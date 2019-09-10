package rekaur.ia;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {
    private CardLayout layout = new CardLayout();


    public CardPanel(){
        super();
        Dimension test = new Dimension(200,480);

        setLayout(layout);
        setMinimumSize(test);
        setSize(test);
        setVisible(true);
    }

    public void addScreen(Component component){
        add(component,component.getName());
        layout.addLayoutComponent(component,component.getName());

    }

    public void show(String componentName){
        layout.show(this,componentName);
    }
}
