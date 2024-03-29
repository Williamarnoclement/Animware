

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
import javax.swing.event.*;

public class AWModel  {

	JMenuBar menuBar = new JMenuBar();
    JMenu menu_1 = new JMenu("Fichier");
    JMenu menu_2 = new JMenu("Pinceau");
    JMenu menu_3 = new JMenu("Aide");

	JMenuItem Item_1_1 = new JMenuItem("Nouveau");
	JMenuItem Item_1_2 = new JMenuItem("Reinitialiser");
	JMenuItem Item_1_3 = new JMenuItem("Sauvegarder");
	JMenuItem Item_1_4 = new JMenuItem("Exporter");
	JMenuItem Item_1_5 = new JMenuItem("Importer");

	JMenuItem Item_2_1 = new JMenuItem("Couleur");

	JMenuItem Item_3_1 = new JMenuItem("A propos");

    ButtonGroup couleurs = new ButtonGroup();


	AWPaint painter[] = new AWPaint[100];
	public Container content;


    // JRadioButton couleur_1 = new JRadioButton("Noir");
    // JRadioButton couleur_2 = new JRadioButton("Bleu");
    // JRadioButton couleur_3 = new JRadioButton("Vert");

	//timeline
	JSlider timeline = new JSlider();

	int currentFrame = 0;
	int newFrame;
	int i = 0;

	public AWModel() {

		// creation de la fenetre
		JFrame frame = new JFrame("Animation Software");
		content = frame.getContentPane();

		// on insere le container "content" dans le jFrame
		content.setLayout(new BorderLayout());

		menu_1.add(Item_1_1);
		//Item_1_1.addActionListener(actionListener);
		menu_1.add(Item_1_2);
		//Item_1_2.addActionListener(actionListener);
		menu_1.add(Item_1_3);
		AWSaver awsaver = new AWSaver();
		Item_1_3.addActionListener(awsaver);
		AWExport awexport = new AWExport(painter);
		menu_1.add(Item_1_4);
		Item_1_4.addActionListener(awexport);

		//Enable Polygon Importer
		AWPolyImporter awpolyimporter = new AWPolyImporter(this);
		menu_1.add(Item_1_5);
		Item_1_5.addActionListener(awpolyimporter);

		menu_2.add(Item_2_1);
		AWColors awcolors = new AWColors();
		Item_2_1.addActionListener(awcolors);

		menu_3.add(Item_3_1);
		AWHelp awhelp = new AWHelp();
		Item_3_1.addActionListener(awhelp);

		menuBar.add(menu_1);
		menuBar.add(menu_2);
		menuBar.add(menu_3);

		//AWPaint painter = new AWPaint();
		for (int i =  0 ; i < 100 ; i++) {
    		painter[i] = new AWPaint(i, this);
		}

		//Implementation de la timeline !!
		AWTimeline wac_timeline = new AWTimeline(this);

		timeline.addChangeListener(wac_timeline);

		content.add(painter[currentFrame], BorderLayout.CENTER);

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
		rethink();
	}

	public void AWSwitchFrame(int mynewframe){
			content.remove(painter[currentFrame]);
			newFrame = mynewframe;
            System.out.println("Frame actuelle : " + newFrame);
			// painter[newFrame].setDragX(painter[currentFrame].getDragX());
			// painter[newFrame].setDragY(painter[currentFrame].getDragY());
			content.add(painter[newFrame]);
			currentFrame = newFrame;
			content.revalidate();
			content.repaint();
	}

	public void reImport(ThreeDPolygon[] p){
		for (int i = 0; i< 100 ; i++) {
			painter[i].import3DPolygon(p);
			AWSwitchFrame(i);
		}
		rethink();
	}

	public void rethink(){
		int x = painter[currentFrame].getDragX();
		int y = painter[currentFrame].getDragY();
		for (int i = 0; i< 100 ; i++) {
			painter[i].setAWP(x,y);
			painter[i].setOldAWP(x,y);
		}
	}
 }
