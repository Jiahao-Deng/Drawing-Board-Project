package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.dialogs.DialogProvider;
import model.interfaces.IDialogProvider;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;
import model.interfaces.*;
import java.awt.*;
import model.shape.*;
import MouseListener.MouseHandler;
public class Main {
    public static void main(String[] args){
    	PaintCanvas canvas = new PaintCanvas();
    	ShapeList shapelist = new ShapeList();
        IGuiWindow guiWindow = new GuiWindow(canvas);
        IUiModule uiModule = new Gui(guiWindow);
        IApplicationState appState = new ApplicationState(uiModule);
        MouseHandler handler = new MouseHandler(appState,canvas, shapelist);
        canvas.addMouseListener(handler);
        IJPaintController controller = new JPaintController(uiModule, appState,canvas,shapelist);
        controller.setup();
        
        
        
       
    }
}
