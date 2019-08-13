 import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.*;
import java.awt.Component;

/**
* Component for drawing !
*
* @author William-Arno CLEMENT
* WWW.ANIMWARE.COM
*/


public class AnimWare {
 
 
	int nombreImages =  100 ;
	
	
	
	
	DrawArea drawArea[] = new DrawArea[100];
	
	
	
	
	JMenuBar menuBar = new JMenuBar();
    JMenu menu_1 = new JMenu("Fichier");
    JMenu menu_2 = new JMenu("Couleurs");
    JMenu menu_3 = new JMenu("Aide");
  
   JMenuItem Item_1_1 = new JMenuItem("Nouveau");
   JMenuItem Item_1_2 = new JMenuItem("Reinitialiser");
   JMenuItem Item_1_3 = new JMenuItem("Sauvegarder");
   JMenuItem Item_1_4 = new JMenuItem("Exporter");
   
   
   ButtonGroup couleurs = new ButtonGroup();
   
   JRadioButton couleur_1 = new JRadioButton("Noir");
   JRadioButton couleur_2 = new JRadioButton("Bleu");
   JRadioButton couleur_3 = new JRadioButton("Vert");
   
    JSlider timeline = new JSlider();

	
	int currentFrame = 0;
	int newFrame;
	int i = 0;
   
 
  ActionListener actionListener = new ActionListener() {

  public void actionPerformed(ActionEvent e) {
      if (e.getSource() == couleur_1) {
        drawArea[currentFrame].black();
      } else if (e.getSource() == couleur_2) {
        drawArea[currentFrame].blue();
      } else if (e.getSource() == couleur_3) {
        drawArea[currentFrame].green();
      }
	  else if (e.getSource() == Item_1_1) {
        System.out.println("Nouveau fichier");
      }
	  else if (e.getSource() == Item_1_2) {
        System.out.println("Reinitialisation");
		drawArea[currentFrame].clear();
      }	
	  else if (e.getSource() == Item_1_3) {
        System.out.println("Sauvegarde");
      }	  
	  else if (e.getSource() == Item_1_4) {
        System.out.println("Exportation");
		int j;
		for( j = 0; j <  100; j++){
			drawArea[j].saver(j);
			System.out.println("j = " + j);
			
		}
      }	 
    }
  };
  
  
  
  
  public static void main(String[] args) {
    new AnimWare().show();
  }
 
  public void show() {
    // creation de la fenetre 
    JFrame frame = new JFrame("Animation Software");
    Container content = frame.getContentPane();
    // on insere le container "content" dans le jFrame
    content.setLayout(new BorderLayout());
    
	// creation de l'environnement de dessin
	
	for (int i =  0 ; i < 100 ; i++) {  
    drawArea[i] = new DrawArea();
	}
    
	//boll[0] = new ResultList();
	
	// initialitation de drawarea
	
    content.add(drawArea[currentFrame], BorderLayout.CENTER);
	
   //gestion des couleurs
	
   couleurs.add(couleur_1);
   couleur_1.addActionListener(actionListener);
   couleurs.add(couleur_2);
   couleur_2.addActionListener(actionListener);
   couleurs.add(couleur_3);
   couleur_3.addActionListener(actionListener);
   
   
   // ajout des couleurs au menu_2 
   
   menu_2.add(couleur_1);
   menu_2.add(couleur_2);
   menu_2.add(couleur_3);
   
   //timeline creation
    timeline.setMaximum(100 - 1);
    timeline.setMinimum(0);
    timeline.setValue(0);
    timeline.setPaintTicks(true);
    timeline.setPaintLabels(true);
    timeline.setMinorTickSpacing(10);
    timeline.setMajorTickSpacing(20);
	
	//ajout d'un listener a la timeline
	timeline.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent ce) {	
			content.remove(drawArea[currentFrame]);		
			newFrame = ((JSlider) ce.getSource()).getValue();
            System.out.println("Frame actuelle : " + newFrame);
			content.add(drawArea[newFrame]);
			currentFrame = newFrame;
			content.revalidate();
			content.repaint();
        }
    });

  //ajout des menus au menubar
  
  menuBar.add(menu_1);
  menuBar.add(menu_2);
  menuBar.add(menu_3);
  
  menu_1.add(Item_1_1);
  Item_1_1.addActionListener(actionListener);
  menu_1.add(Item_1_2);
  Item_1_2.addActionListener(actionListener);
  menu_1.add(Item_1_3);
  Item_1_3.addActionListener(actionListener);
  menu_1.add(Item_1_4);
  Item_1_4.addActionListener(actionListener);
  
  frame.setJMenuBar(menuBar);
  
  frame.add(timeline, BorderLayout.SOUTH);
  

    frame.setSize(960, 540 + 50);
    // fermeture de la JFrame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // rendre le tout visible 
    frame.setVisible(true);
 
  }
 
}