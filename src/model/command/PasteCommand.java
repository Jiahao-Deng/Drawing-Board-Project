package model.command;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;



import Factory.ShapeFactory;
import model.interfaces.ICommand;
import model.shape.Point;
import model.shape.ShapeComposite;
import model.shape.ShapeList;
import shape.interfaces.IShape;
import view.gui.PaintCanvas;
import view.interfaces.IEventCallback;

public class PasteCommand implements ICommand, IEventCallback {
	private String name ="paste";
	private int index;
	private ShapeList shapelist;
	private PaintCanvas canvas;
	
	
	public PasteCommand(ShapeList shapelist,PaintCanvas canvas) {
		this.index=0;
		this.shapelist=shapelist;
		this.canvas=canvas;
		
		
	}

	@Override
	public void run() {
		int limit =0;
		for(ICommand command:this.shapelist.addedcommands) {
			if(command.getname().equals("paste")){
				limit++;
			}
		}
		if(limit < this.shapelist.copyshapes.size()) {
		this.index=this.shapelist.copyshapes.size()-1;
		ShapeComposite copyshape=this.shapelist.copyshapes.get(this.index);
		ArrayList<IShape> shapes= new ArrayList<>();
		for(IShape shape: copyshape.flat()) {
			Point old_point = shape.getpoint();
			int x1=old_point.getstart()[0];
			int y1=old_point.getstart()[1];
			int x2=old_point.getend()[0];
			int y2=old_point.getend()[1];
			int[] new_start=new int[] {x1+15,y1+15};
			int[] new_end=new int[] {x2+15,y2+15};
			Point new_point = new Point(new_start,new_end);
			IShape new_shape=ShapeFactory.createShape(shape.getshade(), shape.getshape(), shape.getprimaraycolor(), shape.getsecondarycolor(), new_point);
			shapes.add(new_shape);
			this.shapelist.addedshapes.add(new_shape);
			new_shape.show(this.canvas.getGraphics2D());
		}
		this.shapelist.addedcommands.add(this);}
		
		
	}

	@Override
	public void undo() {
		Graphics2D graphics=this.canvas.getGraphics2D();
		ShapeComposite copy=this.shapelist.copyshapes.get(this.index);
		int size=copy.flat().size();
		ArrayList<IShape> list =this.shapelist.addedshapes;
		for(int i=0;i<size;i++) {
			list.remove(list.size()-1);
		}
		graphics.setColor(Color.WHITE);
		graphics.fillRect(canvas.getX(), canvas.getY(), canvas.getWidth(), canvas.getHeight());
		ArrayList<IShape> delete = new ArrayList<>();
		for(ShapeComposite composite:this.shapelist.deletedshapes) {
			for(IShape temp:composite.flat()) {
				delete.add(temp);
			}
		}
		for(IShape shape: list) {
			if(delete.contains(shape)) {
				continue;
			}
		else {
			shape.show(this.canvas.getGraphics2D());}
		}
		this.index--;
		
		
		
		
	}

	@Override
	public void redo() {
		System.out.println();
		System.out.println(this.index);
		this.index++;
		ShapeComposite copyshape=this.shapelist.copyshapes.get(this.index);
		ArrayList<IShape> shapes= new ArrayList<>();
		for(IShape shape: copyshape.flat()) {
			Point old_point = shape.getpoint();
			int x1=old_point.getstart()[0];
			int y1=old_point.getstart()[1];
			int x2=old_point.getend()[0];
			int y2=old_point.getend()[1];
			int[] new_start=new int[] {x1+15,y1+15};
			int[] new_end=new int[] {x2+15,y2+15};
			Point new_point = new Point(new_start,new_end);
			IShape new_shape=ShapeFactory.createShape(shape.getshade(), shape.getshape(), shape.getprimaraycolor(), shape.getsecondarycolor(), new_point);
			shapes.add(new_shape);
			this.shapelist.addedshapes.add(new_shape);
			new_shape.show(this.canvas.getGraphics2D());
		}
		
	}

	@Override
	public String getname() {
		
		return this.name;
	}

}
