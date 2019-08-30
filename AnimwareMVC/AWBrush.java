import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.System.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
 
import javax.swing.SwingUtilities;
import javax.imageio.ImageIO;

public class AWBrush extends AWPaint implements MouseListener {

	private int oldX, oldY;


	@Override
    public void mousePressed(MouseEvent e) {
		System.out.println("clicked");
        // save coord x,y when mouse is pressed
        oldX = e.getX() - getDragX();
        oldY = e.getY() - getDragY();

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
    public void mouseClicked(MouseEvent e){
		
	}

}
 
