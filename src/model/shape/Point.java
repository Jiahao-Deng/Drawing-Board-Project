package model.shape;

public class Point {
	private int[] start;
	private int[] end;
	public Point(int[] start, int[] end) {
		this.start=start;
		this.end=end;
	}
	public int[] getstart() {
		return this.start;
	}
	public int[] getend() {
		return this.end;
	}

}
