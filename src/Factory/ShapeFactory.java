package Factory;
import shape.interfaces.*;
import model.*;
import model.shape.*;
public class ShapeFactory {
	

	public static IShape createShape(ShapeShadingType shadetype,ShapeType shapetype,ColorAdapter primarycolor,ColorAdapter secondarycolor,Point point) {
	        
			IShape a = null;
	        if(shapetype.equals(ShapeType.RECTANGLE)) {
	        a = new Rectangle(shadetype,primarycolor, secondarycolor,point);
	        
	        }
	        else if (shapetype.equals(ShapeType.ELLIPSE)) {
	         a = new Ellipse(shadetype,primarycolor, secondarycolor,point);
	        
	        }
	        else if(shapetype.equals(ShapeType.TRIANGLE)) {
	        a = new Triangle(shadetype,primarycolor, secondarycolor,point);
	        
	        }
	        return a;
	        
	    }

}
