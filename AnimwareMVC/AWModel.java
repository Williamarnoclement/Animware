import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;

import java.awt.Container;
import java.awt.BorderLayout;

public class AWModel  {
	
	JMenuBar menuBar = new JMenuBar();
    JMenu menu_1 = new JMenu("Fichier");
    JMenu menu_2 = new JMenu("Couleurs");
    JMenu menu_3 = new JMenu("Aide");
  
	JMenuItem Item_1_1 = new JMenuItem("Nouveau");
	JMenuItem Item_1_2 = new JMenuItem("Reinitialiser");
	JMenuItem Item_1_3 = new JMenuItem("Sauvegarder");
	JMenuItem Item_1_4 = new JMenuItem("Exporter");
   
   
    ButtonGroup couleurs = new ButtonGroup();
	
	AWListener awlistener = new AWListener() ;
   
    JRadioButton couleur_1 = new JRadioButton("Noir");
    JRadioButton couleur_2 = new JRadioButton("Bleu");
    JRadioButton couleur_3 = new JRadioButton("Vert");
	
	//timeline
	JSlider timeline = new JSlider();
	
	public AWModel() {
	 
		// creation de la fenetre 
		JFrame frame = new JFrame("Animation Software");
		Container content = frame.getContentPane();
		
		// on insere le container "content" dans le jFrame
		content.setLayout(new BorderLayout());
		
		menu_1.add(Item_1_1);
		//Item_1_1.addActionListener(actionListener);
		menu_1.add(Item_1_2);
		//Item_1_2.addActionListener(actionListener);
		menu_1.add(Item_1_3);
		Item_1_3.addActionListener(awlistener);
		menu_1.add(Item_1_4);
		//Item_1_4.addActionListener(actionListener);
		
		menuBar.add(menu_1);
		menuBar.add(menu_2);
		menuBar.add(menu_3);
		
		AWPaint painter = new AWPaint();
		
		content.add(painter, BorderLayout.CENTER);
		
		
		//timeline creation
		timeline.setMaximum(100 - 1);
		timeline.setMinimum(0);
		timeline.setValue(0);
		timeline.setPaintTicks(true);
		timeline.setPaintLabels(true);
		timeline.setMinorTickSpacing(10);
		timeline.setMajorTickSpacing(20);
		
		
	
		frame.setJMenuBar(menuBar);
		frame.add(timeline, BorderLayout.SOUTH);
		
		
		/** FIN DE MODELE LANCEMENT DE LA FENETRE*/
		
		frame.setSize(960, 540 + 50);
		// fermeture de la JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// rendre le tout visible 
		frame.setVisible(true);
 
 
	 
	}
 }