package model.command;

import model.interfaces.ICommand;
import view.interfaces.IEventCallback;
import model.shape.*;
import model.interfaces.*;
import shape.interfaces.*;
public class UndoCommand implements ICommand, IEventCallback {
	private ShapeList shapelist;
	public UndoCommand(ShapeList shapelist) {
		this.shapelist=shapelist;
	}

	@Override
	public void run() {
		if(this.shapelist.addedcommands.size()>0) {
			ICommand command = this.shapelist.addedcommands.pop();
			command.undo();
			this.shapelist.deletedcommands.push(command);}
		
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
		return null;
	}

}
