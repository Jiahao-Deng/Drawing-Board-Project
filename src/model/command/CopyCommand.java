package model.command;

import model.interfaces.ICommand;
import model.shape.ShapeComposite;
import model.shape.ShapeList;
import view.interfaces.IEventCallback;

public class CopyCommand implements ICommand, IEventCallback {
	private String name="copy";
	private ShapeList shapelist;
	
	
	public CopyCommand(ShapeList shapelist) {
		this.shapelist=shapelist;
		
		
		
		
	}
	
	@Override
	public void run() {
		if(this.shapelist.allowed>0) {
			ShapeComposite c=this.shapelist.selectedshapes.pop();
			this.shapelist.copyshapes.add(c);
			this.shapelist.allowed=0;
			
			System.out.println(true);
		}
		
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getname() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
