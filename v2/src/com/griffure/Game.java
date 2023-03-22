import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;

import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
    
    private Gameplay gameplay;
    
    private Action upAction;
	private Action downAction;
	private Action leftAction;
	private Action rightAction;

	public Game() {
		// Window settings
        this.gameframe = new JFrame("Backrun Engine");
        this.gameframe.setFocusable(true);
        this.gameframe.requestFocus();

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
        
        //Instantiate gameplay and  interactions
        gameplay = new Gameplay();
        
        upAction = new UpAction(this.gameplay);
		downAction = new DownAction(this.gameplay);
		leftAction = new LeftAction(this.gameplay);
		rightAction = new RightAction(this.gameplay);
        
        JRootPane rootPane = this.gameframe.getRootPane();
        
        rootPane.getInputMap(rootPane.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('z'), "upAction");
		rootPane.getActionMap().put("upAction", upAction);
		rootPane.getInputMap(rootPane.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('s'), "downAction");
		rootPane.getActionMap().put("downAction", downAction);
		rootPane.getInputMap(rootPane.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('q'), "leftAction");
		rootPane.getActionMap().put("leftAction", leftAction);
		rootPane.getInputMap(rootPane.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('d'), "rightAction");
		rootPane.getActionMap().put("rightAction", rightAction);

		/** End of file, display windows and enable close*/
        // rendre le tout visible
		this.gameframe.setVisible(true);
        this.gameframe.toFront();
        this.gameframe.requestFocus();
		this.gameframe.setSize(960, 540 + 50);
		// fermeture de la JFrame
		this.gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    
    public class UpAction extends AbstractAction{
        private Gameplay gameplay;
        
        UpAction(Gameplay gp){
            this.gameplay = gp;
        }

		@Override
		public void actionPerformed(ActionEvent e) {
            this.gameplay.set_f(true);
		}		
	}
    
	public class DownAction extends AbstractAction{
        private Gameplay gameplay;
        
        DownAction(Gameplay gp){
            this.gameplay = gp;
        }

		@Override
		public void actionPerformed(ActionEvent e) {
            this.gameplay.set_b(true);
		}		
	}
    
	public class LeftAction extends AbstractAction{
        private Gameplay gameplay;
        
        LeftAction(Gameplay gp){
            this.gameplay = gp;
        }

		@Override
		public void actionPerformed(ActionEvent e) {
            this.gameplay.set_l(true);
		}		
	}
    
	public class RightAction extends AbstractAction{
        private Gameplay gameplay;
        
        RightAction(Gameplay gp){
            this.gameplay = gp;
        }

		@Override
		public void actionPerformed(ActionEvent e) {
            this.gameplay.set_r(true);
		}		
	}

}