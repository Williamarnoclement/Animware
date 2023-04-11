import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import java.awt.Container;
import javax.swing.JFrame;
import com.jogamp.opengl.util.Animator;

/**
 * This file is running the 3D renderer with OpenGL API
 * @author William-Arno CLEMENT
 */

public class BrRender implements GLEventListener {
    
   private Gameplay gameplay;  
   private Player player;
   private static Animator animator;
   private float rotateT = 0.0f;

   @Override
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
       
       GLU glu=new GLU();

       //glu.gluPerspective(60.0, 4.0/3.0, 1.0, 100.0);

       
       gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
       gl.glClear(GL2.GL_DEPTH_BUFFER_BIT);
       gl.glLoadIdentity();
       gl.glTranslatef(0.0f, 0.0f, 0.0f);
       gl.glRotatef( this.player.eye_rot_x, 0, 1, 0 );
 
       gl.glBegin(GL2.GL_POLYGON);

       gl.glVertex3f(0f,0.5f,0f);
       gl.glVertex3f(-0.5f,0.2f,0f);
       gl.glVertex3f(-0.5f,-0.2f,0f);
       gl.glVertex3f(0f,-0.5f,0f);
       gl.glVertex3f(0f,0.5f,0f);
       gl.glVertex3f(0.5f,0.2f,0f);
       gl.glVertex3f(0.5f,-0.2f,0f);
       gl.glVertex3f(0f,-0.5f,0f);
       
       

       gl.glEnd();

       rotateT += 0.2f;
   }
      
   @Override
   public void dispose( GLAutoDrawable arg0 ) {
      //method body
   }
   
   @Override
   public void init( GLAutoDrawable arg0 ) {
      // method body
   }       
   
   @Override
   public void reshape( GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4 ) {
      // method body
   }
	
   public BrRender(javax.swing.JFrame frame, Gameplay gp, Player p){
      this.gameplay = gp;
      this.player = p;
      //getting the capabilities object of GL2 profile
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
   
      // The canvas
      final GLCanvas glcanvas = new GLCanvas(capabilities);
       
      animator = new Animator(glcanvas);
      animator.start();
       
      glcanvas.addGLEventListener(this);
      glcanvas.setSize(400, 400);

      //adding canvas to frame
      frame.getContentPane().add(glcanvas);
      frame.setSize(frame.getContentPane().getPreferredSize());
   }
}