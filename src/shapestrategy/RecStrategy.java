package shapestrategy;

import shape.interfaces.IStrategy;
import shape.interfaces.IShape;
import java.awt.*;
import java.awt.geom.Ellipse2D;

import model.ShapeShadingType;
import model.ShapeType;
import model.shape.ColorAdapter;
import model.shape.Point;
public class RecStrategy implements IStrategy {
	private Point point;
	private ShapeShadingType shadetype;
	private ColorAdapter primarycolor;
	private ColorAdapter secondarycolor;
	public RecStrategy(ShapeShadingType shadetype,ColorAdapter primarycolor,ColorAdapter secondarycolor,Point point) {
		this.shadetype=shadetype;
		this.primarycolor=primarycolor;
		this.secondarycolor=secondarycolor;
		this.point=point;
	}
	public void drawshape(Graphics2D g) {
		int[] x=this.point.getstart();
		int[] y=this.point.getend();
		int width = Math.abs(x[0]-y[0]);
		int height = Math.abs(x[1]-y[1]);
		if(this.shadetype.equals(ShapeShadingType.OUTLINE)) {
			g.setColor(this.primarycolor.getColor());
            g.drawRect(x[0], x[1], width, height);
		}
		else if(this.shadetype.equals(ShapeShadingType.FILLED_IN)) {
			g.setColor(secondarycolor.getColor());
            g.fillRect(x[0], x[1], width, height);
		}
		else if(this.shadetype.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
			g.setColor(primarycolor.getColor());
            g.drawRect(x[0], x[1], width, height);
            g.setColor(secondarycolor.getColor());
            g.fillRect(x[0], x[1], width, height);
		}
		
	}

}
