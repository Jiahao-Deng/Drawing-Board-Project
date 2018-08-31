package model.command;

import model.interfaces.ICommand;
import model.shape.Point;
import model.interfaces.IApplicationState;
import model.shape.ShapeList;
import shape.interfaces.IShape;
import model.shape.ColorAdapter;
import model.ShapeType;
import model.ShapeShadingType;
import model.ShapeColor;
import view.gui.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Factory.ShapeFactory;

public class DrawCommand implements ICommand {
	private String name="draw";
	private Point current;
	private ShapeList shapelist;
	private ColorAdapter primarycolor;
	private ColorAdapter secondarycolor;
	private ShapeType shapetype;
	private ShapeShadingType shadetype;
	private Graphics2D graphics;
	private IShape new_shape;
	private PaintCanvas canvas;
	public DrawCommand(ShapeList shapelist,Point point,IApplicationState appstate,PaintCanvas canvas) {
		this.shapelist=shapelist;
		this.current=point;
		this.primarycolor=new ColorAdapter(appstate.getActivePrimaryColor());
		this.secondarycolor=new ColorAdapter(appstate.getActiveSecondaryColor());
		this.shapetype=appstate.getActiveShapeType();
		this.shadetype=appstate.getActiveShapeShadingType();
		this.graphics=canvas.getGraphics2D();
		this.canvas=canvas;
		
		
	}

	@Override
	public void run() {
		ShapeFactory factory = new ShapeFactory();
		
		this.new_shape = ShapeFactory.createShape(shadetype, shapetype, primarycolor, secondarycolor, this.current);
		this.shapelist.addshape(new_shape);
		new_shape.show(graphics);
		
		
	}

	@Override
	public void undo() {
		ArrayList<IShape> list = this.shapelist.addedshapes;
		for(IShape shape:list) {
			if(shape.equals(this.new_shape)) {
				list.remove(shape);
				break;
			}
		}
		this.graphics.setColor(Color.WHITE);
		this.graphics.fillRect(canvas.getX(), canvas.getY(), canvas.getWidth(), canvas.getHeight());
		
		for(IShape shape: list) {
			System.out.println(shape.getpoint().getstart()[0]);
			shape.show(this.graphics);
		}
		
		
		
		
		
	}

	@Override
	public void redo() {
		this.shapelist.addshape(this.new_shape);
		this.new_shape.show(this.graphics);
		
		
	}

	@Override
	public String getname() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
