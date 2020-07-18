package arrayvisitors.adt;

import java.io.IOException;

import arrayvisitors.util.Results;
import arrayvisitors.visitors.Visitor;

public class MyArray implements MyArrayI{

	private int[] array = new int[10];
	private int capacity = array.length;

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] arrayIn) {
			array = arrayIn;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacityIn) {
			capacity = capacityIn;
	}
	
	
	public void accept(Visitor visitor,Results resIn)
	{
		visitor.visit(this,resIn);
		
	}
	
	
	public void displayArray()
	{
		for(int i=0;i<array.length;i++)
		{
			if(array[i] > 0)
			{
				System.out.println("Element : "+array[i]);
			}
		}
	}
	
	
}
