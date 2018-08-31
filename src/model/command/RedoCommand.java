package model.command;

import model.interfaces.ICommand;
import view.interfaces.IEventCallback;
import model.interfaces.ICommand;
import view.interfaces.IEventCallback;
import model.shape.*;
import model.interfaces.*;
import shape.interfaces.*;
public class RedoCommand implements ICommand, IEventCallback {
	private ShapeList shapelist;
	private String name="redo";
	public RedoCommand(ShapeList shapelist) {
		// TODO Auto-generated constructor stub
		this.shapelist=shapelist;
	}

	@Override
	public void run() {
		if(this.shapelist.deletedcommands.size()>0) {
		ICommand command = this.shapelist.deletedcommands.pop();
		command.redo();
		this.shapelist.addedcommands.push(command);}
		
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
