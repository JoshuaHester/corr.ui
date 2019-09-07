package rekaur.ia;
public class Demo {

    public static int[] getStandardResolutions(int i){
        int width = 0;
        int height = 0;
        switch(i){
            case 0:
                width = 640;
                height = 480;
                break;
            case 1:
                width = 800;
                height = 600;
                break;
            case 2:
                width = 1024;
                height = 768;
                break;
            case 3:
                width = 1280;
                height = 960;
                break;
            case 4:
                width = 1400;
                height = 1050;
                break;
            case 5:
                width = 1680;
                height = 1050;
                break;
            case 6:
                width = 1920;
                height = 1080;
                break;
            default:
                break;

        }
        int[] a = {width,height};
        return a;
    }

    public static void main(String args[]) {
        GameWindow gui = new GameWindow();
        MenuScreen mainMenu = new MenuScreen();
        //add resolution buttons
        int w;
        int h;
        for(int i=0;i<7;i++){
            w = getStandardResolutions(i)[0];
            h = getStandardResolutions(i)[1];
            int width=w;
            int height=h;
            String name = width+"x"+height;
            mainMenu.addButton(name, () -> gui.changeWindowSize(width,height));
        }


        mainMenu.addButton("Fullscreen", () -> gui.setFullScreen());
        mainMenu.addButton("close",()-> System.exit(0));


        gui.addScreen(mainMenu,300);

    }

}
