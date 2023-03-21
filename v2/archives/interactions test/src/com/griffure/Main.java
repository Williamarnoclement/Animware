import com.jogamp.opengl.util.Animator;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

import com.jogamp.opengl.GLEventListener;

public class Main implements GLEventListener{
    private Game game;
    private static boolean fullscreen=false;
    private int w=1024;
    private int h=768;
    private static Point center;
    private Point mousePos;
    private int forward=KeyEvent.VK_W;
    private int backward=KeyEvent.VK_S;
    private int strafel=KeyEvent.VK_A;
    private int strafer=KeyEvent.VK_D;
    private int shoot=MouseEvent.BUTTON1;
    private int use=MouseEvent.BUTTON3;
    
    private MouseSys mouse_sys;
    
    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame("JOGL Events");
        Toolkit t=Toolkit.getDefaultToolkit();
        Image img=new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Cursor pointer=t.createCustomCursor(img, new Point(0,0), "none");
        GLCanvas canvas = new GLCanvas();
        //canvas.addGLEventListener(mouse_sys);
        canvas.setFocusable(true);
        canvas.requestFocus();
        frame.add(canvas);
        frame.setUndecorated(true);
        frame.setSize(1024, 768);
        frame.setLocationRelativeTo(null);
        frame.setCursor(pointer);
        frame.setVisible(true);
        
        
        frame.setSize(960, 540 + 50);
		// fermeture de la JFrame
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        
        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        if(fullscreen){
            ge.getDefaultScreenDevice().setFullScreenWindow(frame);
        }

        final Animator animator = new Animator(canvas);
        animator.setRunAsFastAsPossible(true);
        animator.start();
        Rectangle r=frame.getBounds();
        center=new Point(r.x+r.width/2, r.y+r.height/2);
    }
    
    public void init(GLAutoDrawable _drawable) {
        com.jogamp.opengl.GL2 gl = _drawable.getGL().getGL2();
        game=new Game(gl);
        game.setMouseCenter(center);
        mousePos=center;
        GLU glu=new GLU();
        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(gl.GL_PROJECTION);
        glu.gluPerspective(45.0f, ((float)w/(float)h), 0.1f, 100.0f);
        gl.glMatrixMode(gl.GL_MODELVIEW);
        gl.glShadeModel(gl.GL_SMOOTH);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(gl.GL_DEPTH_TEST);
        gl.glDepthFunc(gl.GL_LEQUAL);
        gl.glHint(gl.GL_PERSPECTIVE_CORRECTION_HINT, gl.GL_NICEST);
        
        //mouse_sys = new MouseSys(game, use, shoot);

        //_drawable.addMouseListener(mouse_sys);
        //canvas.addMouseListener(mouse_sys);
        
        
        
        _drawable.addKeyListener(new KeyAdapter(){
        @Override
        public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
        new Thread(new Runnable(){
        public void run(){
        System.exit(0);
        }
        }).start();
        }
        if(e.getKeyCode()==forward)game.setFord(true);
        if(e.getKeyCode()==backward)game.setback(true);
        if(e.getKeyCode()==strafel)game.setstrafel(true);
        if(e.getKeyCode()==strafer)game.setstrafer(true);
        }
        @Override
        public void keyReleased(KeyEvent e){
        if(e.getKeyCode()==forward)game.setFord(false);
        if(e.getKeyCode()==backward)game.setback(false);
        if(e.getKeyCode()==strafel)game.setstrafel(false);
        if(e.getKeyCode()==strafer)game.setstrafer(false);
        }
        });
        _drawable.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
        if(e.getButton()==shoot)
        game.setShoot();
        if(e.getButton()==use)
        game.setUse();
        }
        });
        
    }
    
    public void display(GLAutoDrawable _drawable) {
        com.jogamp.opengl.GL2 gl = _drawable.getGL().getGL2();
        gl.glClear(com.jogamp.opengl.GL2.GL_COLOR_BUFFER_BIT | com.jogamp.opengl.GL2.GL_DEPTH_BUFFER_BIT);

        gl.glLoadIdentity();
        game.tick();
        gl.glFlush();
    }
    
    //@Override
    public void dispose(GLAutoDrawable drawable) {
      //method body
    }
    
    public void reshape(GLAutoDrawable _drawable, int x, int y, int width, int height) {
        com.jogamp.opengl.GL2 gl = _drawable.getGL().getGL2();
        GLU glu = new GLU();
        if (height <= 0) { height = 1; }
        final float h=(float)width/(float)height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(com.jogamp.opengl.GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(com.jogamp.opengl.GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        center=new Point(x+width/2, y+height/2);
        game.setMouseCenter(center);
    }
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean
    deviceChanged) {}
}