package model.shape;
import java.util.ArrayList;
import shape.interfaces.*;
public class ShapeComposite {
	private ArrayList<IShape> shapes;
	public ShapeComposite() {
		this.shapes=new ArrayList<>();
		
	}
	public void addshape(IShape shape) {
		this.shapes.add(shape);
		
	}
	public void delteshape(IShape shape) {
		this.shapes.remove(shape);
	}
	public ArrayList<IShape> flat() {
		return this.shapes;
}}
