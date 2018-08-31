package model.shape;
import shape.interfaces.*;
import model.command.CopyCommand;
import model.interfaces.*;
import java.util.*;
import model.shape.*;
public class ShapeList {
	public ArrayList<IShape> addedshapes;
	public Stack<ShapeComposite> selectedshapes;
	public Stack<ShapeComposite> deletedshapes;
	public Stack<ICommand> addedcommands;
	public Stack<ICommand> deletedcommands;
	public Stack<ShapeComposite> movedshapes;
	public ArrayList<ShapeComposite> copyshapes;
	
	public int allowed;
	public ShapeList() {
		this.addedshapes= new ArrayList<IShape>();
		this.selectedshapes= new Stack<>();
		this.deletedshapes = new Stack();
		this.addedcommands=new Stack<>();
		this.deletedcommands= new Stack<>();
		this.movedshapes=new Stack<>();
		this.copyshapes= new ArrayList<>();
		
		this.allowed=0;
		
		
	}
	public void addshape(IShape shape) {
		this.addedshapes.add(shape);
		
	}
	public void selectshape(Point point) {
			int limit =0;
			for(ICommand command:this.addedcommands) {
				if(command.getname().equals("draw")) {
					continue;
				}
				else {
					limit++;
				}}
			for(ICommand temp:this.deletedcommands) {
					if(temp.getname().equals("draw")) {
						continue;
					}
					else {
						limit++;
					}
			}
			System.out.println(limit);
			
			ShapeComposite comp= new ShapeComposite();
			int counter=0;
			for(IShape shape:this.addedshapes) {
				if(shape.contains(point)) {
					comp.addshape(shape);
					counter++;
				}
			}
			System.out.println(this.deletedshapes.size()+this.selectedshapes.size()+this.movedshapes.size()+this.copyshapes.size());
			if(counter >0) {
			if(this.deletedshapes.size()+this.selectedshapes.size()+this.movedshapes.size()+this.copyshapes.size()<=limit) {
				
				this.selectedshapes.push(comp);
				this.allowed=1;
				
			}
			else {
				this.selectedshapes.pop();
				this.selectedshapes.push(comp);
			}
		
		
		}
	
	}
	

}
