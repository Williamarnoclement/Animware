import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 

public class AWListener extends AWModel implements ActionListener {
	
	
	private int oldX, oldY;
	
	
	public AWListener() {
		
		
	
	}	

	
	public void actionPerformed(ActionEvent e) {
	  if (e.getSource() == Item_1_3) {
        System.out.println("Sauvegarde");
		System.out.println("Enorme !!!");
      }	 
    }
}
 
