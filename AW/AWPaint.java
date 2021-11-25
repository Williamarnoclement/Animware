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

  private int paintID;

  public static int WIDTH = 960;
  public  static int HEIGHT = 540;

	//draggable system... oui je parle anglais !

	public int currentX, currentY, oldX, oldY;

  private int position_x, position_y;
  private int old_position_x, old_position_y;

  /**Polygone**/
  ThreeDPolygon[] square = new ThreeDPolygon[6];

  /*Creation du polygone*/
  ThreeDPoint[] _left = new ThreeDPoint[4];
  ThreeDPoint[] _right = new ThreeDPoint[4];
  ThreeDPoint[] _top = new ThreeDPoint[4];
  ThreeDPoint[] _bottom = new ThreeDPoint[4];
  ThreeDPoint[] _front = new ThreeDPoint[4];
  ThreeDPoint[] _back = new ThreeDPoint[4];

  public AWPaint(int id) {
    this.paintID = id;
    this.position_x = 10;
    this.position_y = 10;

    //implementation du movingworkspace !
    AWMovingWorkspace wac_workspace = new AWMovingWorkspace(this);
    addMouseMotionListener(wac_workspace);
    addMouseListener(wac_workspace);


    /**Polygone**/

    _left[0] = new ThreeDPoint(0, 0, 0);
    _left[1] = new ThreeDPoint(100, 0, 0);
    _left[2] = new ThreeDPoint(100, 100, 0);
    _left[3] = new ThreeDPoint(0, 100, 0);

    _right[0] = new ThreeDPoint(0, 0, 100);
    _right[1] = new ThreeDPoint(100, 0, 100);
    _right[2] = new ThreeDPoint(100, 100, 100);
    _right[3] = new ThreeDPoint(0, 100, 100);

    _top[0] = new ThreeDPoint(100,  0, 0);
    _top[1] = new ThreeDPoint(100, 100, 0);
    _top[2] = new ThreeDPoint(100, 100, 100);
    _top[3] = new ThreeDPoint(100, 0, 100);

    _bottom[0] = new ThreeDPoint(0, 0, 0);
    _bottom[1] = new ThreeDPoint(0, 100, 0);
    _bottom[2] = new ThreeDPoint(0, 100, 100);
    _bottom[3] = new ThreeDPoint(0, 0, 100);

    _front[0] = new ThreeDPoint(0, 100, 100);
    _front[1] = new ThreeDPoint(100, 100, 100);
    _front[2] = new ThreeDPoint(100, 100, 0);
    _front[3] = new ThreeDPoint(0, 100, 0);

    _back[0] = new ThreeDPoint(0, 100, 100);
    _back[1] = new ThreeDPoint(100, 100, 100);
    _back[2] = new ThreeDPoint(100, 100, 0);
    _back[3] = new ThreeDPoint(0, 100, 0);

    this.square[0] = new ThreeDPolygon(_top);
    this.square[1]  = new ThreeDPolygon(_left);
    this.square[2]  = new ThreeDPolygon(_right);
    this.square[3]  = new ThreeDPolygon(_bottom);
    this.square[4]  = new ThreeDPolygon(_back);
    this.square[5]  = new ThreeDPolygon(_front);
  }

  public ThreeDPolygon Rotate_polygon(ThreeDPolygon poly, double timeline){
    PointConverter converter = new PointConverter();
    ThreeDPoint[] new_points = new ThreeDPoint[poly.get3Dpoints().length];
    for (int i = 0; i < poly.get3Dpoints().length ; i++) {
        poly.print2DPolygon();
        new_points[i] = converter.rotateAxisX(poly.get3Dpoints()[i], true, (double) timeline);
        poly.set3DPolygon(new_points);
        new_points[i] = converter.rotateAxisY(poly.get3Dpoints()[i], true, (double) timeline);
        poly.set3DPolygon(new_points);
    }
    return poly;
  }

  public ThreeDPolygon GetClosest_polygon(ThreeDPolygon un, ThreeDPolygon deux){
    double somme_x = 0;
    for (int i = 0; i < un.get3Dpoints().length ; i++) {
      somme_x = somme_x + un.get3Dpoints()[i].x;
    }
    double moyenne_x_un = somme_x / un.get3Dpoints().length;

    somme_x = 0;
    for (int i = 0; i < deux.get3Dpoints().length ; i++) {
      somme_x = somme_x + deux.get3Dpoints()[i].x;
    }
    double moyenne_x_deux = somme_x / deux.get3Dpoints().length;

    if (moyenne_x_un > moyenne_x_deux) {
      return deux;
    }
    return un;
  }

  public ThreeDPolygon[] permutate_in_array(ThreeDPolygon[] l, int a, int b){
    ThreeDPolygon tmp = l[a];
    l[a] = l[b];
    l[b] = tmp;
    return l;
  }

  public ThreeDPolygon[] Get3DPolygonLayers(ThreeDPolygon[] layer_list){
    for (int i = 0; i < layer_list.length; i++) {
        for (int j = i+1; j < layer_list.length; j++) {
          ThreeDPolygon current;
          current = GetClosest_polygon(layer_list[i], layer_list[j]);
          if (current == layer_list[i]) {
            layer_list = permutate_in_array(layer_list, i,j);
          }
        }
    }
    return layer_list;
  }


  @Override
  protected void paintComponent(Graphics g) {
    /*rotation 3D points*/
    for (int i = 0; i < square.length; i++) {
      this.Rotate_polygon(square[i], paintID);
    }

    /*Affichage*/
    /*Reset display*/
    g.setColor(Color.WHITE);
    //g.fillRect(0,0,this.WIDTH, this.HEIGHT);

    square = Get3DPolygonLayers(square);

    if (image == null) {
      // image to draw null ==> we create
      image = createImage(960, 540);
  	  image.getScaledInstance(960/2, 540/2, Image.SCALE_DEFAULT);
      g2 = (Graphics2D) image.getGraphics();
        // enable antialiasing
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      // clear draw area
  	  //addMouseListener(new AWBrush(getDragX(), getDragY()));
  	  addMouseMotionListener(new AWMotionBrush(g2, getDragX(), getDragY(), this));
      for (int i = 0; i < square.length; i++) {
        if (i == 0) g2.setColor(Color.RED);
        if (i == 1) g2.setColor(Color.BLUE);
        if (i == 2) g2.setColor(Color.PINK);
        if (i == 3) g2.setColor(Color.YELLOW);
        if (i == 4) g2.setColor(Color.CYAN);
        if (i == 5) g2.setColor(Color.GREEN);
        g2.fillPolygon(this.square[i].get2DPolygon(this.position_x, this.old_position_y));
      }
    }

    g.setColor(Color.RED);
    g.drawImage(image,this.position_x, this.position_y,null);


    img = (BufferedImage) image;

  }

  // now we create exposed methods
  public void clear() {
    g2.setPaint(Color.white);
    // draw white on entire draw area to clear
    g2.fillRect(0, 0, this.WIDTH, this.HEIGHT);
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
