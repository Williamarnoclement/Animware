import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
 
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JComponent;

//JAVA.IO

import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

//Pour le tracer (stroke)
import java.awt.Stroke;
import java.awt.BasicStroke;
 
/**
*
* @author William-Arno CLEMENT
* WWW.ANIMWARE.COM
*/
public class AWPaint extends JComponent {
 
  // Image in which we're going to draw
  public Image image;
  public BufferedImage img = new BufferedImage(960, 540, BufferedImage.TYPE_INT_ARGB);
  // Graphics2D object ==> used to draw on
  public Graphics2D g2;

  public float zoom = 1f;
  	
	//draggable system... oui je parle anglais !

	public int currentX, currentY, oldX, oldY;

	public int drag_x = getDragX();
	public int drag_y = getDragY();
 
  public AWPaint() {



    //implementation du movingworkspace !
    AWMovingWorkspace wac_workspace = new AWMovingWorkspace(this);
    addMouseMotionListener(wac_workspace);

  }
  @Override
  protected void paintComponent(Graphics g) {
    if (image == null) {
      // image to draw null ==> we create
      image = createImage(960, 540);
	  image.getScaledInstance(960/2, 540/2, Image.SCALE_DEFAULT);
      g2 = (Graphics2D) image.getGraphics();
      // enable antialiasing
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      // clear draw area
	  clear();
	  //addMouseListener(new AWBrush(getDragX(), getDragY()));
	  addMouseMotionListener(new AWMotionBrush(g2, getDragX(), getDragY(), this));
    }
	
    g.drawImage(image,getDragX(),getDragY(), null);
	  img = (BufferedImage) image;

  }
 
  // now we create exposed methods
  public void clear() {
    g2.setPaint(Color.white);
    // draw white on entire draw area to clear
    g2.fillRect(0, 0, 960, 540);
    g2.setPaint(Color.black);
    repaint();
  }
 
  public void red() {
    // apply red color on g2 context
    g2.setPaint(Color.red);
  }
 
  public void black() {
    g2.setPaint(Color.black);

    Stroke stroke = new BasicStroke(10.0f);

    g2.setStroke(stroke);
  }
 
  public void magenta() {
    g2.setPaint(Color.magenta);
  }
 
  public void green() {
    g2.setPaint(Color.green);
  }
 
  public void blue() {
    g2.setPaint(Color.blue);
  }


  
    public int getDragX() { 
    return drag_x; 
    } 
    public int getDragY() { 
    return drag_y; 
    } 
    public void setDragX(int drag_x){
    this.drag_x = drag_x;
    }
    public void setDragY(int drag_y){
    this.drag_y = drag_y;
    } 

}
 