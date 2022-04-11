import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.event.*;

import javax.swing.JSlider;


public class AWTimeline implements ChangeListener {


	private AWModel current_model;

	public AWTimeline(AWModel awmodel)
	{
		current_model = awmodel;
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
			int wac_timeline_value = ((JSlider) ce.getSource()).getValue();
			//System.out.println(wac_timeline_value);
			current_model.AWSwitchFrame(wac_timeline_value);
    }
}
