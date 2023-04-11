import javax.swing.JFrame;

/**
 * This class is dedicated to interactions values and variables
 * @author William-Arno CLEMENT
 */

public class Gameplay {
    
    private BrRender render;
    private JFrame frame;
    
    private Player player;
    
    private boolean is_r;//right
    private boolean is_l;//left
    private boolean is_f;//forward
    private boolean is_b;//backward
    
    private boolean is_right_dash;//right dash
    private boolean is_left_dash;//left dash

    public Gameplay(Player p) {
        this.player = p;
    }
    
    boolean get_r(){
        return this.is_r;
    }
    
    boolean get_f(){
        return this.is_f;
    }
    
    boolean get_b(){
        return this.is_b;
    }
    
    boolean get_l(){
        return this.is_l;
    }
    
    boolean get_right_dash(){
        return this.is_right_dash;
    }
    
    boolean get_left_dash(){
        return this.is_left_dash;
    }
    
    void set_r(boolean state){
        this.is_r = state;
    }
    
    void set_l(boolean state){
        this.is_l = state;
    }
    
    void set_b(boolean state){
        this.is_b = state;
    }
    
    void set_f(boolean state){
        this.is_f = state;
        System.out.println("f");
    }
    
    void set_right_dash(boolean state){
        this.is_right_dash = state;
        this.player.eye_rot_x = this.player.eye_rot_x + 10f;
        System.out.println("Eye Rot X: " + this.player.eye_rot_x);
    }
    
    void set_left_dash(boolean state){
        this.is_left_dash = state;
        this.player.eye_rot_x = this.player.eye_rot_x - 10f;
        System.out.println("Eye Rot X: " + this.player.eye_rot_x);
    }
}