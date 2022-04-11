import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class AWPolyImporter implements ActionListener {
  private AWModel current_model;
	public AWPolyImporter(AWModel awmodel){
		//Ceci l'importeur
    current_model = awmodel;

	}
  public void actionPerformed(ActionEvent e) {
        /**Polygone**/
        ThreeDPolygon[] square = new ThreeDPolygon[6];

        /*Creation du polygone*/
        ThreeDPoint[] _left = new ThreeDPoint[4];
        ThreeDPoint[] _right = new ThreeDPoint[4];
        ThreeDPoint[] _top = new ThreeDPoint[4];
        ThreeDPoint[] _bottom = new ThreeDPoint[4];
        ThreeDPoint[] _front = new ThreeDPoint[4];
        ThreeDPoint[] _back = new ThreeDPoint[4];

        /**Polygone**/
        int s = 100;

        _left[0] = new ThreeDPoint(-s/2, -s/2, -s/2);
        _left[1] = new ThreeDPoint(s/2,-s/2,-s/2);
        _left[2] = new ThreeDPoint(s/2, s/2, -s/2);
        _left[3] = new ThreeDPoint(-s/2, s/2, -s/2);

        _right[0] = new ThreeDPoint(-s/2,-s/2, s/2);
        _right[1] = new ThreeDPoint(s/2,-s/2, s/2);
        _right[2] = new ThreeDPoint(s/2, s/2, s/2);
        _right[3] = new ThreeDPoint(-s/2, s/2, s/2);

        _top[0] = new ThreeDPoint(s/2, -s/2,-s/2);
        _top[1] = new ThreeDPoint(s/2, s/2,-s/2);
        _top[2] = new ThreeDPoint(s/2, s/2, s/2);
        _top[3] = new ThreeDPoint(s/2,-s/2, s/2);

        _bottom[0] = new ThreeDPoint(-s/2,-s/2,-s/2);
        _bottom[1] = new ThreeDPoint(-s/2, s/2,-s/2);
        _bottom[2] = new ThreeDPoint(-s/2, s/2, s/2);
        _bottom[3] = new ThreeDPoint(-s/2,-s/2, s/2);

        _front[0] = new ThreeDPoint(-s/2, s/2, s/2);
        _front[1] = new ThreeDPoint(s/2, s/2, s/2);
        _front[2] = new ThreeDPoint(s/2, s/2,-s/2);
        _front[3] = new ThreeDPoint(-s/2, s/2,-s/2);

        _back[0] = new ThreeDPoint(-s/2, s/2, s/2);
        _back[1] = new ThreeDPoint(s/2, s/2, s/2);
        _back[2] = new ThreeDPoint(s/2, s/2,-s/2);
        _back[3] = new ThreeDPoint(-s/2, s/2,-s/2);

        square[0]  = new ThreeDPolygon(_top);
        square[1]  = new ThreeDPolygon(_left);
        square[2]  = new ThreeDPolygon(_right);
        square[3]  = new ThreeDPolygon(_bottom);
        square[4]  = new ThreeDPolygon(_back);
        square[5]  = new ThreeDPolygon(_front);

        this.current_model.reImport(square);

        System.out.println("Import en Cours !");
  }
}
