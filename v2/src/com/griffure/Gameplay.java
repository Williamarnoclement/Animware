import javax.swing.JFrame;

/**
 * This class is dedicated to interactions values and variables
 * @author William-Arno CLEMENT
 */

public class Gameplay {
    
    private BrRender render;
    private JFrame frame;
    
    private boolean is_r;//right
    private boolean is_l;//left
    private boolean is_f;//forward
    private boolean is_b;//backward

    public Gameplay() {}
    
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
    }
}