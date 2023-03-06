/**import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
**/
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.JFrame;

public class Main implements GLEventListener {

   @Override
   public void display( GLAutoDrawable drawable ) {
      final GL2 gl = drawable.getGL().getGL2();
   
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
	
   public static void main( String[] args ) {
   
      //getting the capabilities object of GL2 profile
      final GLProfile profile = GLProfile.get( GLProfile.GL2 );
      GLCapabilities capabilities = new GLCapabilities(profile);
   
      // The canvas
      final GLCanvas glcanvas = new GLCanvas( capabilities );
      Main house = new Main();
      glcanvas.addGLEventListener( house );
      glcanvas.setSize(400, 400);
   
      //creating frame
      final JFrame frame = new JFrame( "Main" );
      
      //stop program on close
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //adding canvas to frame
      frame.getContentPane().add( glcanvas );
      frame.setSize(frame.getContentPane().getPreferredSize() );
      frame.setVisible( true );
      
   }//end of main
	
}//end of class