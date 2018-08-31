package model.shape;
import java.awt.Color;
import java.awt.Color.*;
import model.*;
import java.io.Serializable;

public class ColorAdapter {
		
private ShapeColor colorEnum;
private java.awt.Color color;
		
public ColorAdapter(ShapeColor colorEnum){
			
			this.colorEnum = colorEnum;
			switch (colorEnum) {
            case BLUE:
                this.color = Color.blue;
                break;
            case BLACK:
                this.color = Color.black;
                break;
            case CYAN:
                this.color = Color.CYAN;
                break;
            case DARK_GRAY:
                this.color = Color.DARK_GRAY;
                break;
            case GRAY:
                this.color = Color.GRAY;
                break;
            case GREEN:
                this.color = Color.GREEN;
                break;
            case LIGHT_GRAY:
                this.color = Color.LIGHT_GRAY;
                break;
            case MAGENTA:
                this.color = Color.MAGENTA;
                break;
            case ORANGE:
                this.color = Color.ORANGE;
                break;
            case RED:
                this.color = Color.RED;
                break;
            case PINK:
                this.color = Color.PINK;
                break;
            case WHITE:
                this.color = Color.WHITE;
                break;
            case YELLOW:
                this.color = Color.YELLOW;
                break;}
			
			
			
		}
		

		
public Color getColor(){
	return this.color;
	}
	}


