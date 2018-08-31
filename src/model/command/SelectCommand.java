package model.command;

import model.interfaces.ICommand;
import model.shape.*;
public class SelectCommand implements ICommand {
	private Point point;
	private ShapeList shapelist;
	
	public SelectCommand(Point point,ShapeList shapelist) {
		this.point=point;
		this.shapelist=shapelist;
	}

	@Override
	public void run() {
		this.shapelist.selectshape(point);
		
	}
	
	@Override
	public void undo() {
		
		
	}

	@Override
	public void redo() {
		
		
	}

	@Override
	public String getname() {
		// TODO Auto-generated method stub
		return null;
	}

}
