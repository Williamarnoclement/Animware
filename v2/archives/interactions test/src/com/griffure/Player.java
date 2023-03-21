import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.common.nio.Buffers;
import java.nio.FloatBuffer;


public class Player {
private static final float _90=(float)Math.toRadians(90);
private static final float _maxPitch=(float)Math.toRadians(60);
private float heading=0.0f;
private float pitch=0.0f;

private float cosa, cosb, cosz, sina, sinb, sinz;
private float cosc=1.0f;
private float sinc=0.0f;
private float x, y, z;//player position

private float[] mat={ 1,0,0,0,
0,1,0,0,
0,0,1,0,
0,0,0,1};
private FloatBuffer matrix;
public Player(){
matrix=Buffers.newDirectFloatBuffer(mat.length);
matrix.put(mat);
x=z=0.0f;
//there is no floor collider so we set a static y value
y=-2.2f;
}

public void setHeading(float amount){
heading-=amount;
cosb=(float)Math.toRadians(Math.cos(heading));
sinb=(float)Math.toRadians(Math.sin(heading));
cosz=(float)Math.toRadians(Math.cos(heading+_90));
sinz=(float)Math.toRadians(Math.sin(heading+_90));
}

public void setPitch(float amount){
pitch-=amount;
if(pitch>_maxPitch)pitch=_maxPitch;
if(pitch<-_maxPitch)pitch=-_maxPitch;
cosa=(float)Math.cos(pitch);
sina=(float)Math.sin(pitch);
}

public void setFord(float amount){
x+=cosz*amount;
z+=sinz*amount;
}
public void setBack(float amount){
x-=cosz*amount;
z-=sinz*amount;
}
public void setStrafel(float amount){
x+=cosb*amount;
z+=sinb*amount;
}
public void setStrafer(float amount){
x-=cosb*amount;
z-=sinb*amount;
}

public void set(){
matrix.put(0, cosc*cosb-sinc*sina*sinb);
matrix.put(1, sinc*cosb+cosc*sina*sinb);
matrix.put(2, -cosa*sinb);
matrix.put(4, -sinc*cosa);
matrix.put(5, cosc*cosa);
matrix.put(6, sina);
matrix.put(8, cosc*sinb+sinc*sina*cosb);
matrix.put(9, sinc*sinb-cosc*sina*cosb);
matrix.put(10, cosa*cosb);
matrix.put(12, matrix.get(0)*x+matrix.get(4)*y+matrix.get(8)*z);
matrix.put(13, matrix.get(1)*x+matrix.get(5)*y+matrix.get(9)*z);
matrix.put(14, matrix.get(2)*x+matrix.get(6)*y+matrix.get(10)*z);
}
public void draw(com.jogamp.opengl.GL2 gl){
gl.glLoadIdentity();
gl.glBegin(gl.GL_QUADS);
gl.glColor3f(7.0f, 5.0f, 3.0f);
gl.glVertex3f(1.0f, 1.0f, 0.0f);
gl.glVertex3f(2.0f, 1.0f, 0.0f);
gl.glVertex3f(2.0f, 1.0f, -5.0f);
gl.glVertex3f(1.0f, 1.0f, -5.0f);
gl.glEnd();
matrix.rewind();
gl.glLoadMatrixf(matrix);
}
}