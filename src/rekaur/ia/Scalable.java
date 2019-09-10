package rekaur.ia;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Scalable {
    private static int defaultWidth;
    private static int defaultHeight;
    private static List scalableItems = new LinkedList();

    protected Scalable(int width, int height){
        defaultWidth = width;
        defaultHeight = height;
    }

    public static void scaleComponents(int newWidth,int newHeight){
        for( int i = 0; i < scalableItems.size(); i++){
            try {
                ScalableImageLabel comp = (ScalableImageLabel) scalableItems.get(i);
                comp.scale(newWidth, newHeight);
            }catch(Exception e){};
            try{
                JLayeredPane comp = (JLayeredPane) scalableItems.get(i);
                comp.setSize(new Dimension(newWidth, newHeight));
            }catch(Exception e){};

        }
    }

    protected static int getNewWidthOfComponent(int newWindowWidth, int oldComponentWidth){
        double widthRatio = (double)newWindowWidth / (double)defaultWidth;
        return (int)Math.round(widthRatio * oldComponentWidth);
    }

    protected static int getNewHeightOfComponent(int newWindowHeight, int oldComponentHeight){
        double heightRatio = (double)newWindowHeight / (double)defaultHeight;
        return (int)Math.round(heightRatio * oldComponentHeight);
    }

    protected static void addComponent(Component component){
        scalableItems.add(component);
    }




}
