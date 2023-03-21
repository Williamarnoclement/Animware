import java.awt.AWTException;
import java.awt.MouseInfo;
import com.jogamp.opengl.GL;
import java.awt.Point;
import java.awt.Robot;

public class Game {
private Player player;
private Floor floor;
private com.jogamp.opengl.GL2 gl;
private final float headSens=0.02f;
private final float pitchSens=0.01f;
private Point mouseCenter;
private Robot robot;
private float dx, dy;
private long lastTime;
private boolean ford=false;
private boolean back=false;
private boolean strafel=false;
private boolean strafer=false;
private int shoot=0;
private int use=0;
public Game(com.jogamp.opengl.GL2 gl){
this.gl=gl;
floor=new Floor();

player=new Player();
Robot r=null;
try{
r=new Robot();
}catch(final AWTException e){System.out.println("Trouble stating ");}
this.robot=r;
if(robot==null)System.out.println("Error ");
}

private void pollEvents(){

long now=System.nanoTime();
float period=(float)((now-lastTime)*0.000005);
lastTime=now;
dx=MouseInfo.getPointerInfo().getLocation().x;
dy=MouseInfo.getPointerInfo().getLocation().y;
float head=mouseCenter.x-dx;
float pit=mouseCenter.y-dy;

if(head!=0) player.setHeading(head*headSens);
if(pit!=0) player.setPitch(pit*pitchSens);
if(ford) player.setFord((float)period);
if(back) player.setBack((float)period);
if(strafel) player.setStrafel((float)period);
if(strafer) player.setStrafer((float)period);
if(shoot>0){System.out.println("");}
if(use>0){System.out.println("Using an item");}
//Once in place this method builds the matrix
player.set();
}
public void tick(){
pollEvents();
if(robot!=null)
robot.mouseMove(mouseCenter.x, mouseCenter.y);
shoot=0;
use=0;

player.draw(gl);
floor.draw(gl);
}
public void setMouseCenter(Point center){
this.mouseCenter=center;
}
public void setFord(boolean flag){
ford=flag;
}
public void setback(boolean flag){
back=flag;
}
public void setstrafel(boolean flag){
strafel=flag;
}
public void setstrafer(boolean flag){
strafer=flag;
}
public void setShoot(){
shoot++;
}
public void setUse(){
use++;
}
}