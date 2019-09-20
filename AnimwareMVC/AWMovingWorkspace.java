import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

 

public class AWMovingWorkspace extends MouseMotionAdapter {

	private AWPaint current_painter;

	public AWMovingWorkspace(AWPaint awpainter) {

		current_painter = awpainter;
		mouseDragged();

	}	

	public void mouseDragged(MouseEvent e) {
		
		if (SwingUtilities.isMiddleMouseButton(e)){
		  /**System.out.println("X = " + getDragX() + " Y = "  + getDragY());
	      setDragX(e.getX());
	      setDragY(e.getY());
	      **/
	      System.out.println("Test");
	      
	      repaint();
		}
    }

}
 