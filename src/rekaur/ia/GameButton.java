package rekaur.ia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
A generic button type.

All other buttons i this package inherit this base type
*/

public class GameButton extends JButton implements ActionListener {
    private GameFunction function;
    private String name;
    public GameButton(){
        createButton();
        setFunction(function);

    }

    public void createButton(){
        addActionListener(this);
    }

    public void setFunction(GameFunction function){
        this.function=function;
    }

    public void setName(String buttonName){
        name = buttonName;
       setText(name);
       setVerticalTextPosition(AbstractButton.CENTER);
       setHorizontalTextPosition(AbstractButton.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        function.execute();
    }
}
