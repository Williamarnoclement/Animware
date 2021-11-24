import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;



public class AWMovingWorkspace implements MouseListener, MouseMotionListener {

  private AWPaint current_painter;

  private int oldMouseX, oldMouseY;

  public AWMovingWorkspace(AWPaint awpainter) {

    current_painter = awpainter;

    this.current_painter.setOldAWP(this.current_painter.getAWP()[0], this.current_painter.getAWP()[1]);

    this.oldMouseX = this.current_painter.getAWP()[0];
    this.oldMouseY = this.current_painter.getAWP()[1];

  }

  /**
  * Si la souris est préssée.
  * @param e l'évenement de type MouseEvent
  */
  public void mousePressed(MouseEvent e) {
    if (SwingUtilities.isMiddleMouseButton(e)){
      this.oldMouseX = e.getX();
      this.oldMouseY = e.getY();
    }

  }
  /**
  * Inutile
  * @param e l'évenement de type MouseEvent
  */
  public void mouseReleased(MouseEvent e) {
    System.out.println("yo");
    if (SwingUtilities.isMiddleMouseButton(e)){
      this.current_painter.setAWP(this.current_painter.getoldAWP()[0] + e.getX()- this.oldMouseX ,this.current_painter.getoldAWP()[1]  +  e.getY()- this.oldMouseY);
      this.current_painter.repaint();
    }
  }
  /**
  * Inutile
  * @param e l'évenement de type MouseEvent
  */
  public void mouseEntered(MouseEvent e) {}
  /**
  * Inutile
  * @param e l'évenement de type MouseEvent
  */
  public void mouseExited(MouseEvent e) {}
  /**
  * Inutile
  * @param e l'évenement de type MouseEvent
  */
  public void mouseClicked(MouseEvent e) {}
  /**
  * Si la souris est déplacée.
  * @param e l'évenement de type MouseEvent
  */
  public void mouseDragged(MouseEvent e){
    if (SwingUtilities.isMiddleMouseButton(e)){
      this.current_painter.setAWP(this.current_painter.getoldAWP()[0] + e.getX() - this.oldMouseX,this.current_painter.getoldAWP()[1] + e.getY() - this.oldMouseY);
      this.current_painter.setOldAWP(this.current_painter.getAWP()[0], this.current_painter.getAWP()[1]);
      this.oldMouseX = e.getX();
      this.oldMouseY = e.getY();
      this.current_painter.repaint();
    }
  }
  /**
  * Inutile
  * @param e l'évenement de type MouseEvent
  */
  public void mouseMoved(MouseEvent e){}

}
