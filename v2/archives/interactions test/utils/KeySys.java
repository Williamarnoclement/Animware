import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;


public class KeySys implements ActionListener {
    
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                new Thread(new Runnable(){
                public void run(){
                System.exit(0);
            }
            }).start();
            }
            if(e.getKeyCode()==forward)game.setFord(true);
            if(e.getKeyCode()==backward)game.setback(true);
            if(e.getKeyCode()==strafel)game.setstrafel(true);
            if(e.getKeyCode()==strafer)game.setstrafer(true);
        }
        @Override
        public void keyReleased(KeyEvent e){
        if(e.getKeyCode()==forward)game.setFord(false);
        if(e.getKeyCode()==backward)game.setback(false);
        if(e.getKeyCode()==strafel)game.setstrafel(false);
        if(e.getKeyCode()==strafer)game.setstrafer(false);
        }
}