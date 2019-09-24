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

public class AWMotionBrush implements MouseMotionListener, MouseListener{

	public int oldX, oldY, currentX, currentY;
	private Graphics2D theg2;
	private int theX, theY;
	private AWPaint theawpaint;
	

	public AWMotionBrush(Graphics2D aspire_g2, int myX, int myY, AWPaint awpaint){
		theg2 = aspire_g2;

		theawpaint = awpaint;

		
	}
	
	public void mouseDragged(MouseEvent e) {
        // coord x,y when drag mouse
        currentX = e.getX();
        currentY = e.getY();	


		theX = theawpaint.getDragX();
		theY = theawpaint.getDragY();
        
          // draw line if g2 context not null
		  if (theg2 != null) {
		  if (SwingUtilities.isLeftMouseButton(e)){
		  	if ((currentX > theX) && (currentX < (960 + theX)) && (currentY > theY) && (currentY < (540 + theY))){

		  	    //dans l'image
		  	    System.out.println("Dedans ! (x="+currentX+" y="+currentY+" tx="+theX+" ty="+theY);

	            theg2.drawLine(oldX, oldY, currentX - theX , currentY - theY );


			    //new AWBrush(currentX -theX, currentY - theY);
			    oldX = currentX - theX;
          		oldY = currentY - theY;
          // refresh draw area to repaint
          theawpaint.repaint();

			}else{
				//hors de l'image
				System.out.println("Dehors ! (x="+currentX+" y="+currentY+" tx="+theX+" ty="+theY);

			}
		  }

		  //System.out.println("left click");

		  }

      }
	  
	@Override
	public void mouseMoved(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)){
		  
			oldX = e.getX();
			oldY = e.getY();
	    }
		  
	}  

	@Override
    public void mousePressed(MouseEvent e) {

    	if (SwingUtilities.isLeftMouseButton(e)){
			System.out.println("clicked");
	        // save coord x,y when mouse is pressed
	        oldX = e.getX();
	        oldY = e.getY();
    	}

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
 
