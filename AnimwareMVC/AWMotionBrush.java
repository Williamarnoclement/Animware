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

public class AWMotionBrush extends AWPaint implements MouseMotionListener {

	private int oldX, oldY;
	@Override
	public void mouseDragged(MouseEvent e) {
        // coord x,y when drag mouse
        currentX = e.getX() - getDragX();
        currentY = e.getY() - getDragY();
 
        
          // draw line if g2 context not null
		  if (g2 != null) {
		  if (SwingUtilities.isLeftMouseButton(e)){
          g2.drawLine(oldX, oldY, currentX, currentY);
		  System.out.println(currentX);
		  System.out.println(currentY);

		  }
		  System.out.println("left click");
          // refresh draw area to repaint
          repaint();
          // store current coords x,y as olds x,y
          oldX = currentX;
          oldY = currentY;
		  }

      }
	  
	  @Override
	  public void mouseMoved(MouseEvent e) {}  

}
 
