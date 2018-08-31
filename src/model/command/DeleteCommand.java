package model.command;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Stack;

import Factory.ShapeFactory;
import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.ICommand;
import view.gui.PaintCanvas;
import view.interfaces.IEventCallback;
import model.shape.*;
import shape.interfaces.*;

public class DeleteCommand implements ICommand, IEventCallback {
	private int position;
	private String name = "delete";
	private Graphics2D graphics;
	private ShapeList shapelist;
	private PaintCanvas canvas;
	public DeleteCommand(PaintCanvas canvas,ShapeList shapelist) {
		this.graphics=canvas.getGraphics2D();
		this.shapelist=shapelist;
		this.canvas=canvas;
		
		
	}

	@Override
	public void run() {
		if(this.shapelist.allowed>0) {
		ShapeComposite comp= this.shapelist.selectedshapes.pop();
		this.shapelist.deletedshapes.push(comp);
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
			shape.show(this.graphics);}
		}
		
		this.shapelist.addedcommands.push(this);
		this.shapelist.allowed=0;}}
		
		
		
		
		

	@Override
	public void undo() {
		ShapeComposite comp = this.shapelist.deletedshapes.pop();
		this.shapelist.selectedshapes.push(comp);
		for(IShape shape:comp.flat()) {
			shape.show(graphics);
		}
		
		
	}

	@Override
	public void redo() {
		
		ShapeComposite comp= this.shapelist.selectedshapes.pop();
		this.shapelist.deletedshapes.push(comp);
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
			shape.show(this.graphics);}
		}
		}
	@Override
	public String getname() {
		// TODO Auto-generated method stub
		return this.name;
	}}
