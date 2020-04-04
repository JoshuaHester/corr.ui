package corr.ui;

import javax.swing.*;
import java.awt.*;

public class ImageLabel extends JLabel {
    private Image image;
    private int xCoord = 0;
    private int yCoord = 0;
    private int width = 50;
    private int height = 50;
    private int originalWidth;
    private int originalHeight;

    public ImageLabel(ImageIcon icon){
        super(icon);
        this.setSize(icon.getIconWidth(),icon.getIconHeight());
        setXCoord(this.getHorizontalAlignment());
        setYCoord(this.getVerticalAlignment());
        setLabelHeight(this.getHeight());
        setLabelWidth(this.getWidth());
    }

    public ImageLabel(){
        this(null);
    }

    public void setIcon(Icon icon){
        super.setIcon(icon);
        image =((ImageIcon)icon).getImage();

    }

    public int getOriginalWidth(){
        return originalWidth;
    }

    public int getOriginalHeight(){
        return originalHeight;
    }

    protected void setLabelWidth(int width){
        originalWidth = width;
        this.width = width;
    }

    protected void setLabelHeight(int height){
        originalHeight = height;
        this.height = height;
    }

    public void setXCoord(int x){
        xCoord = x;
    }

    public void setYCoord(int y){
        yCoord = y;
    }

    public int getXCoord(){
        return xCoord;
    }

    public int getYCoord(){
        return yCoord;
    }

    public Image getImage() {
        return image;
    }
}
