package shapestrategy;



import shape.interfaces.IStrategy;
import shape.interfaces.IShape;
import java.awt.*;
import java.awt.geom.Ellipse2D;

import model.ShapeShadingType;
import model.ShapeType;
import model.shape.ColorAdapter;
import model.shape.Point;
public class TriangleStrategy implements IStrategy {
	private Point point;
	private ShapeShadingType shadetype;
	private ColorAdapter primarycolor;
	private ColorAdapter secondarycolor;
	public TriangleStrategy(ShapeShadingType shadetype,ColorAdapter primarycolor,ColorAdapter secondarycolor,Point point) {
		this.shadetype=shadetype;
		this.primarycolor=primarycolor;
		this.secondarycolor=secondarycolor;
		this.point=point;
	}
	public void drawshape(Graphics2D g) {
		int[] start=this.point.getstart();
		int[] end=this.point.getend();
		int[] x = new int[3];
		int[] y = new int[3];
		x[0]=start[0];
		x[1]=start[0];
		x[2]=end[0];
		y[0]=start[1];
		y[1]=end[1];
		y[2]=end[1];
		
		
		if(this.shadetype.equals(ShapeShadingType.OUTLINE)) {
			g.setColor(this.primarycolor.getColor());
            g.drawPolygon(x, y, 3);
            
		}
		else if(this.shadetype.equals(ShapeShadingType.FILLED_IN)) {
			g.setColor(secondarycolor.getColor());
            g.fillPolygon(x,y,3);
		}
		else if(this.shadetype.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
			g.setColor(this.primarycolor.getColor());
            g.drawPolygon(x, y, 3);
            g.setColor(secondarycolor.getColor());
            g.fillPolygon(x,y,3);
		}
		
	}

}
