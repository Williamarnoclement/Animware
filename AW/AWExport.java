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
	
	
    
    private AWPaint[] thepainter;

	public AWExport(AWPaint[] my_painter) {
		thepainter = my_painter;
	}	
	
	public void actionPerformed(ActionEvent e) {
        

        	saver();

    }

	
  public void saver() {
	
	
    
    for (int increment = 0; increment < 100 ;increment++ ) {
    	
    	File file = new File("rendered/" + increment + ".png");
	
		try {		
		  
		  ImageIO.write(thepainter[increment].img, "png", file);
		  System.out.println(increment);
		  
		}
		catch(IOException e) {
		  System.out.println("nope");
		}
		catch(NullPointerException  npe){
		  	System.out.println("npe");
		}

	}
  }
}
 
