import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.jogamp.opengl.GLEventListener;


public class MouseSys implements MouseListener {

    private Game game;
    private int use;
    private int shoot;
    
    @Override
    public void mousePressed(MouseEvent e) {
    }
    
    @Override
	public void mouseEntered(MouseEvent e){
	}
    @Override
    public void mouseExited(MouseEvent e){
	}
    @Override
	public void mouseReleased(MouseEvent e){
	}
	@Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()==shoot)
        game.setShoot();
        if(e.getButton()==use)
        game.setUse();
    }
    
    public MouseSys(Game _game, int _use, int _shoot){
        this.game = _game;
        this.shoot = _shoot;
        this.use = _use;
    }
}