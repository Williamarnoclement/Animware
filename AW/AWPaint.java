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

  private int position_x, position_y;
  private int old_position_x, old_position_y;

  public AWPaint() {

    this.position_x = 10;
    this.position_y = 10;

    //implementation du movingworkspace !
    AWMovingWorkspace wac_workspace = new AWMovingWorkspace(this);
    addMouseMotionListener(wac_workspace);
    addMouseListener(wac_workspace);
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

    g.drawImage(image,this.position_x, this.position_y,null);
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

  public int[] getoldAWP(){
    int[] xy = new int[2];
    xy[0] = this.old_position_x;
    xy[1] = this.old_position_y;
    return xy;
  }

  public void setOldAWP(int x, int y){
    this.old_position_x = x;
    this.old_position_y = y;
  }

  public void setAWP(int x, int y){
    this.position_x = x;
    this.position_y = y;
  }

  public int[] getAWP(){
    int[] xy = new int[2];
    xy[0] = this.position_x;
    xy[1] = this.position_y;
    return xy;
  }

    public int getDragX() {
      return position_x;
    }
    public int getDragY() {
      return position_y;
    }
    public void setDragX(int drag_x){
      this.position_x = drag_x;
    }
    public void setDragY(int drag_y){
      this.position_y = drag_y;
    }

}
