package arrayvisitors.adt;

import arrayvisitors.visitors.Element;


public interface MyArrayI extends Element{

	public int[] getArray();
	public void setArray(int[] array);
	public int getCapacity();
	public void setCapacity(int capacity);
	public void displayArray();
	
	
}
