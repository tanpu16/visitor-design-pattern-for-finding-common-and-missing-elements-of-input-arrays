package arrayvisitors.adt;

import java.io.IOException;

import arrayvisitors.util.Results;
import arrayvisitors.visitors.Element;
import arrayvisitors.visitors.Visitor;

public interface MyArrayI extends Element{

	public int[] getArray();
	public void setArray(int[] array);
	public int getCapacity();
	public void setCapacity(int capacity);
	public void displayArray();
	
	
}
