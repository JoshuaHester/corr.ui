package rekaur.ia;
public class Demo {

    public static void main(String args[]) {
        GameWindow gui = new GameWindow("test");
        MenuScreen mainMenu = new MenuScreen();
        mainMenu.addButton("640x480", () -> gui.changeWindowSize(640,480));
        mainMenu.addButton("close",()-> System.exit(0));
        gui.addScreen(mainMenu,300);

    }

}
