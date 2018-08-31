package model.shape;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics2D;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import shapestrategy.*;
import java.awt.Color;
import shape.interfaces.*;
import java.util.concurrent.TimeUnit;
public class Rectangle implements IShape {
	
	public Point point;
	private ShapeShadingType shadetype;
	private ColorAdapter primarycolor;
	private ColorAdapter secondarycolor;
	public Rectangle(ShapeShadingType shadetype,ColorAdapter primarycolor,ColorAdapter secondarycolor,Point point) {
		this.shadetype=shadetype;
		this.primarycolor=primarycolor;
		this.secondarycolor=secondarycolor;
		this.point=point;
		
		
	}
	@Override
	public void show(Graphics2D graphics) {
		IStrategy s=new RecStrategy(this.shadetype,this.primarycolor,this.secondarycolor,this.point);
		s.drawshape(graphics);
		
}
 	public boolean contains(Point point) {
 		int[] start=point.getstart();
 		int[] end=point.getend();
 		int[] O_start=this.point.getstart();
 		int[] O_end=this.point.getend();
 		int distance = Math.abs(start[0]-end[0]) + Math.abs(start[1]-end[1]);
 		int midx=(O_start[0]+O_end[0])/2;
 		int midy=(O_start[1]+O_end[1])/2;
 		
 		
 		boolean result=false;
 		if(distance<=2) {
 			if((start[0]-O_start[0])*(start[0]-O_end[0])<0) {
 				if((start[1]-O_start[1])*(start[1]-O_end[1])<0) {
 					result = true;
 				}
 			}
 		}
 		else if((midx-start[0])*(midx-end[0]) <0) {
 			if((midy-start[1])*(midy-end[1])<0) {
 				result=true;
 			}
 		}
 		return result;
 		
 		}
	@Override
	public Point getpoint() {
		// TODO Auto-generated method stub
		return this.point;
	}
	@Override
	public ShapeType getshape() {
		// TODO Auto-generated method stub
		return ShapeType.RECTANGLE;
	}
	@Override
	public void changepoint(int a, int b) {
		
		int a1=this.point.getstart()[0];
		int b1=this.point.getstart()[1];
		int c1= this.point.getend()[0];
		int d1=this.point.getend()[1];
		int[] new_x= new int[]{a1+a,b1+b};
		int[] new_y= new int[] {c1+a,d1+b};
		Point p = new Point(new_x,new_y);
		this.point=p;
		
		
		
	}
	@Override
	public ShapeShadingType getshade() {
		// TODO Auto-generated method stub
		return this.shadetype;
	}
	@Override
	public ColorAdapter getprimaraycolor() {
		// TODO Auto-generated method stub
		return this.primarycolor;
	}
	@Override
	public ColorAdapter getsecondarycolor() {
		// TODO Auto-generated method stub
		return this.secondarycolor;
	}
	
	
 	}

