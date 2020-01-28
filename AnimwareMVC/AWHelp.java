import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class AWHelp implements ActionListener {

	public AWHelp() {

	}	

	
	public void actionPerformed(ActionEvent e) {
		System.out.println("A propos");
		fenetre_about();
	}

	public void fenetre_about(){

		JFrame fenetre = new JFrame();
		fenetre.setSize(300, 250);
		fenetre.setLocation(100, 100);

		JLabel etiquette = new JLabel("<html><body>A propos de<br> <h1>Animware</h1><br> Initialement cree par<br>William-Arno Clement<br>Sous le regard de<br>Luc Hernandez<br>au sein de l'IUT Informatique de Fontainebleau</body></html>");


		etiquette.setHorizontalAlignment(JLabel.CENTER);

		fenetre.add(etiquette, BorderLayout.CENTER);

		fenetre.setVisible(true);
	}
}