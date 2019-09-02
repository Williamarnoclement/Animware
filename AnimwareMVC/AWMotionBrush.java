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

public class AWMotionBrush implements MouseMotionListener {

	public int oldX, oldY, currentX, currentY;
	private Graphics2D theg2;
	private int theX, theY;
	private AWPaint theawpaint;
	

	public AWMotionBrush(Graphics2D aspire_g2, int myX, int myY, AWPaint awpaint){
		theg2 = aspire_g2;
		theX = myX;
		theY = myY;
		theawpaint = awpaint;
		
		//new AWBrush(myX, myY);
	}
	
	public void mouseDragged(MouseEvent e) {
        // coord x,y when drag mouse
        currentX = e.getX() - theX;
        currentY = e.getY() - theY;		
        
          // draw line if g2 context not null
		  if (theg2 != null) {
		  if (SwingUtilities.isLeftMouseButton(e)){
          theg2.drawLine(oldX, oldY, currentX, currentY);
		  System.out.println(currentX);
		  System.out.println(currentY);
		  new AWBrush(theX, theY);
		  }

		  System.out.println("left click");
          // refresh draw area to repaint
          theawpaint.repaint();
          // store current coords x,y as olds x,y
          oldX = currentX;
          oldY = currentY;
		  }

      }
	  
	  @Override
	  public void mouseMoved(MouseEvent e) {
		  
		oldX = e.getX();
		oldY = e.getY();
		  
	  }  
	  


}
 
