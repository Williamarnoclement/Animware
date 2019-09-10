import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.event.*;

import javax.swing.JSlider;
 

public class AWTimeline implements ChangeListener {



	public AWTimeline() 
	{

	}	

	

    public void stateChanged(ChangeEvent ce) 
    {	
    	System.out.println("Timeline fonctionnelle" + ((JSlider) ce.getSource()).getValue());

    		//my_content.remove(awpaint);		
			//newFrame = ((JSlider) ce.getSource()).getValue();
            //System.out.println("Frame actuelle : " + ((JSlider) ce.getSource()).getValue());
						
			/**my_content.add(awpaint[newFrame]);
			currentFrame = newFrame;
			my_content.revalidate();
			my_content.repaint();

			**/
			AWSwitchFrame(((JSlider) ce.getSource()).getValue());
    }
}
 
