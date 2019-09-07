package rekaur.ia;

import javax.swing.*;
import java.awt.*;

public class ImageLabel extends JLabel {
    private Image image;
    private int xCoord = 0;
    private int yCoord = 0;

    public ImageLabel(ImageIcon icon){
        super(icon);
        xCoord = this.getHorizontalAlignment();
        yCoord = this.getVerticalAlignment();
    }

    public void setIcon(Icon icon){
        super.setIcon(icon);
        image =((ImageIcon)icon).getImage();
    }

    public void scale(){

    }

    @Override
    public void paint(Graphics g){
        scale();
        g.drawImage(image, xCoord, yCoord, this.getWidth(), this.getHeight(), null);
    }
}
