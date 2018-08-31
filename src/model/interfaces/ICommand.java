package model.interfaces;

public interface ICommand {
	

	
		public void run();
		public void undo();
		public void redo();
		public String getname();
	

}
