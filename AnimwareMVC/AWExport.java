import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.io.File;
import java.io.IOException;

import java.awt.Image;
import java.awt.image.BufferedImage;
 

public class AWExport implements ActionListener {
	
	
    public BufferedImage img = new BufferedImage(960, 540, BufferedImage.TYPE_INT_ARGB);
	
	public AWExport() {

	
	}	
	
	public void actionPerformed(ActionEvent e) {
        saver(1);
    }

	
  public void saver(int wac) {
	
	
    File file = new File("rendered/" + wac + ".png");
    
	
		try {		
		  
		  ImageIO.write(img, "png", file);
		  System.out.println(wac);
		  
		}
		catch(IOException e) {
		  System.out.println("nope");
		}
		catch(NullPointerException  npe){
		  	System.out.println("npe");
		}

	return;
  }
}
 
