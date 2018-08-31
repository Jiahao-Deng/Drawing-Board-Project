package MouseListener;
import java.awt.event.*;

import model.command.DrawCommand;
import model.command.SelectCommand;
import model.command.*;
import model.interfaces.*;
import shape.interfaces.*;
import view.gui.*;
import java.awt.*;
import model.*;
import model.shape.*;
import model.shape.Point;
public class MouseHandler extends MouseAdapter {
	
	private IApplicationState appstate;
	private int[] start;
	private int[] end;
	private PaintCanvas canvas;
	private ShapeList shapelist;
	
	public MouseHandler(IApplicationState appstate,PaintCanvas canvas,ShapeList shapelist) {
		this.appstate=appstate;
		this.canvas=canvas;
		this.shapelist=shapelist;
	}
	public void mousePressed(MouseEvent e) {
		this.start = new int[2];
		this.end = new int[2];
		this.start[0]=e.getX();
		this.start[1]=e.getY();
	}
	public void mouseReleased(MouseEvent e) {
		this.end[0]=e.getX();
		this.end[1]=e.getY();
		Point point = new Point(start,end);
		
		if(this.appstate.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.DRAW)) {
		ICommand drawcommand = new DrawCommand(shapelist,point, appstate,canvas);
		this.shapelist.addedcommands.push(drawcommand);
		drawcommand.run();}
		
		else if(this.appstate.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.SELECT)) {
			ICommand selectcommand = new SelectCommand(point,this.shapelist);
			selectcommand.run();}
		else if(this.appstate.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.MOVE)) {
			ICommand movecommand = new MoveCommand(this.shapelist,point,this.canvas);
			movecommand.run();
			
		}
	}
	
	
}
