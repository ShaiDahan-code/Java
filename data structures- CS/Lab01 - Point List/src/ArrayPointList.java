import java.awt.Point;

public class ArrayPointList implements PointList {
	private Point[] points;
	private int size;
	private int cursor;
	
	public ArrayPointList() {
		this(MAX_SIZE);

	}

	public ArrayPointList(int maxSize) {
		points = new Point[maxSize];
		size = 0;
		cursor = 0;
	}
	
	@Override
	public void append(Point newPoint) {
        if(isFull()){
			System.out.print("Error, the list is full!");
			return;
		}
		points[size] = newPoint;
		size += 1;
		cursor = size;
	}

	@Override
	public void clear() {
        size = 0;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0){
			return true;
		}
		return false;
		
	}

	@Override
	public boolean isFull() {
		if(size == points.length-1){
			return true;
		}
		return false;
		
	}

	@Override
	public boolean goToBeginning() {
		if(isEmpty())
			return false;
		cursor = 0;
		return true;
	}

	@Override
	public boolean goToEnd() {
		if(isEmpty())
			return false;
		cursor = size;
		return true;
	}

	@Override
	public boolean goToNext() {
		if(points[cursor+1] == null || isFull()){
			return false;
		}
		cursor += 1;
		return true;
	}

	@Override
	public boolean goToPrior() {
		if(cursor ==0)
			return false;
		cursor -= 1;
		return true;
	}

	@Override
	public Point getCursor() {
		if(isEmpty())
			return null;
		return points[cursor];
	}

	@Override
	public String toString() {
		int i=0;
		String ss = new String();
		for(i=0; i < points.length; i++){
			ss += "Point number " + cursor + " :" + points[i] + '\n';
		}
		return ss;
	}

}
