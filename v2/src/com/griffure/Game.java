import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;

import javax.swing.event.*;

/**
 * This class is instantiating the client
 * @author William-Arno CLEMENT
 */

public class Game  {

	JMenuBar menuBar = new JMenuBar();
    JMenu menu_1 = new JMenu("Backrun");
    JMenu menu_2 = new JMenu("Options");
    JMenu menu_3 = new JMenu("Aide");

	JMenuItem Item_1_1 = new JMenuItem("Nouveau");
	JMenuItem Item_1_2 = new JMenuItem("Reinitialiser");
	JMenuItem Item_1_3 = new JMenuItem("Sauvegarder");
	JMenuItem Item_1_4 = new JMenuItem("Exporter");
	JMenuItem Item_1_5 = new JMenuItem("Importer");

	JMenuItem Item_2_1 = new JMenuItem("Couleur");

	JMenuItem Item_3_1 = new JMenuItem("A propos");
    
    private JFrame gameframe;

	public Game() {

		// Window settings
        this.gameframe = new JFrame("Backrun Engine");

		menu_1.add(Item_1_1);
		//Item_1_1.addActionListener(actionListener);
		menu_1.add(Item_1_2);
		menu_1.add(Item_1_3);
		menu_1.add(Item_1_4);

		menu_1.add(Item_1_5);

		menu_2.add(Item_2_1);

		menu_3.add(Item_3_1);

		menuBar.add(menu_1);
		menuBar.add(menu_2);
		menuBar.add(menu_3);

        // put menu on the top of the window
		this.gameframe.setJMenuBar(menuBar);
        
        //Instantiate and display the 3D part of the game
        BrRender render = new BrRender(this.gameframe); 


		/** End of file, display windows and enable close*/

		this.gameframe.setSize(960, 540 + 50);
		// fermeture de la JFrame
		this.gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// rendre le tout visible
		this.gameframe.setVisible(true);
	}
}