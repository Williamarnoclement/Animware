
public class Floor {
public void draw(com.jogamp.opengl.GL2 gl){
gl.glBegin(gl.GL_QUADS);
gl.glColor3f(0.9f, 0.2f, 0.1f);
gl.glVertex3f(-100.0f, 1.0f, 100.0f);
gl.glColor3f(0.4f, 0.8f, 0.4f);
gl.glVertex3f(-100.0f, 1.0f, -100.0f);
gl.glColor3f(0.2f, 0.9f, 0.1f);
gl.glVertex3f(100.0f, 1.0f, -100.0f);
gl.glColor3f(0.5f, 0.2f, 0.9f);
gl.glVertex3f(100.0f, 1.0f, 100.0f);
gl.glEnd();
}
}