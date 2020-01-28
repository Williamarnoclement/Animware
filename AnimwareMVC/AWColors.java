import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JSlider;


public class AWColors implements ActionListener {

	public AWColors() {

	}	

	public void fenetre_rgb(){

		JFrame fenetre = new JFrame();
		fenetre.setSize(300, 250);
		fenetre.setLocation(100, 100);

		//etiquette.setHorizontalAlignment(JLabel.CENTER);
		JSlider slide_R = new JSlider();
		JSlider slide_G = new JSlider();
		JSlider slide_B = new JSlider();

		slide_R.setMaximum(255);
		slide_R.setMinimum(0);
		slide_R.setValue(255);
		fenetre.add(slide_R, BorderLayout.CENTER);

		fenetre.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Ouverture de du Choix de couleurs");
		fenetre_rgb();
	}
}

