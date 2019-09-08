package rekaur.ia;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ScalableImageLabel extends ImageLabel {

    public ScalableImageLabel(){
        this(null);
    }

    public ScalableImageLabel(ImageIcon icon){
        super(icon);
        Scalable.addComponent(this);
    }


    public void scale(int width,int height){
        int oldWidth = getOriginalWidth();
        int oldHeight = getOriginalHeight();
        setSize(Scalable.getNewWidthOfComponent(width,oldWidth),Scalable.getNewHeightOfComponent(height,oldHeight));
        System.out.println(getWidth()+"x"+getHeight());
        setVisible(true);
    }


}
