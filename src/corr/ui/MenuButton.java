package corr.ui;

public class MenuButton extends GameButton {
    public MenuButton(String name, GameFunction function){
        createButton();
        setFunction(function);
        setName(name);
    }
}
