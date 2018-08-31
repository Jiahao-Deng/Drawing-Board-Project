package model.command;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import model.interfaces.ICommand;
import model.shape.*;
import shape.interfaces.*;
import view.gui.PaintCanvas;
public class MoveCommand implements ICommand {
	private String name = "move";
	private Point point;
	private ShapeList shapelist;
	private PaintCanvas canvas;
	private Graphics2D graphics;
	private int delta1;
	private int delta2;
	
	public MoveCommand(ShapeList shapelist,Point point,PaintCanvas canvas) {
		this.shapelist=shapelist;
		this.point=point;
		this.canvas=canvas;
		this.graphics=canvas.getGraphics2D();
	}

	@Override
	public void run() {
		if(this.shapelist.allowed >0) {
		ShapeComposite move= this.shapelist.selectedshapes.pop();
		this.shapelist.movedshapes.push(move);
		Point first=move.flat().get(0).getpoint();
		int[] start = first.getstart();
		
		int[] new_end=this.point.getend();
		this.delta1=new_end[0]-start[0];
		this.delta2=new_end[1]-start[1];
		
		this.graphics.setColor(Color.WHITE);
		this.graphics.fillRect(canvas.getX(), canvas.getY(), canvas.getWidth(), canvas.getHeight());
		ArrayList<IShape> list=this.shapelist.addedshapes;
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
			if(move.flat().contains(shape)) {
				shape.changepoint(this.delta1,this.delta2);
				
			}
			shape.show(this.graphics);}
			
		}
		this.shapelist.allowed=0;
		this.shapelist.addedcommands.push(this);
	}}

	@Override
	public void undo() {
		ShapeComposite move= this.shapelist.movedshapes.pop();
		this.shapelist.selectedshapes.push(move);
		this.graphics.setColor(Color.WHITE);
		this.graphics.fillRect(canvas.getX(), canvas.getY(), canvas.getWidth(), canvas.getHeight());
		ArrayList<IShape> list=this.shapelist.addedshapes;
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
			if(move.flat().contains(shape)) {
				shape.changepoint(0-this.delta1,0-this.delta2);
				
			}
			shape.show(this.graphics);}
			
		}
		
	}

	@Override
	public void redo() {
		ShapeComposite move= this.shapelist.selectedshapes.pop();
		this.shapelist.movedshapes.push(move);
		this.graphics.setColor(Color.WHITE);
		this.graphics.fillRect(canvas.getX(), canvas.getY(), canvas.getWidth(), canvas.getHeight());
		ArrayList<IShape> list=this.shapelist.addedshapes;
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
			if(move.flat().contains(shape)) {
				shape.changepoint(this.delta1,this.delta2);
				
			}
			shape.show(this.graphics);}
			
		}
		
	}

	@Override
	public String getname() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
