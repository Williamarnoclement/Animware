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
 
/**
*
* @author William-Arno CLEMENT
* WWW.ANIMWARE.COM
*/
public class DrawArea extends JComponent {
 
  // Image in which we're going to draw
  private Image image;
  public BufferedImage img = new BufferedImage(960, 540, BufferedImage.TYPE_INT_ARGB);
  // Graphics2D object ==> used to draw on
  private Graphics2D g2;
  // Mouse coordinates
  private int currentX, currentY, oldX, oldY;
  public float zoom = 1f;
  	
	//draggable system... oui je parle anglais !
	private int drag_x = getDragX();
	private int drag_y = getDragX();	

 
  public DrawArea() {

    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {

        // save coord x,y when mouse is pressed
        oldX = e.getX() - getDragX();
        oldY = e.getY() - getDragY();

      }
    });
	addMouseMotionListener(new MouseMotionHandler());
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        // coord x,y when drag mouse
        currentX = e.getX() - getDragX();
        currentY = e.getY() - getDragY();
 
        if (g2 != null) {
          // draw line if g2 context not null
		  if (SwingUtilities.isLeftMouseButton(e)){
          g2.drawLine(oldX, oldY, currentX, currentY);
		  }
          // refresh draw area to repaint
          repaint();
          // store current coords x,y as olds x,y
          oldX = currentX;
          oldY = currentY;
        }

      }
    });
	
	
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
    }
 
    g.drawImage(image, getDragX(), getDragY(), null);
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

  public void saver(int wac) {
	
	
    File file = new File("rendered/" + wac + ".png");
    
	
		try {
		  ImageIO.write(img, "png", file);
		  System.out.println(wac);
		  
		}
		catch(IOException e) {
		  System.out.println("nope");
		}
		catch(NullPointerException  npe){
		  	System.out.println("npe");
		}

	return;
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
  

  class MouseMotionHandler extends MouseMotionAdapter {
    public void mouseDragged(MouseEvent e) {
		
	if (SwingUtilities.isMiddleMouseButton(e)){
	  System.out.println("X = " + getDragX() + " Y = "  + getDragY());
      setDragX(e.getX());
      setDragY(e.getY());
      repaint();
	}
    }
  }
}
 