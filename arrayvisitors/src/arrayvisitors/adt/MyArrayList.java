package arrayvisitors.adt;

import java.util.ArrayList;
import java.util.List;

import arrayvisitors.util.Results;
import arrayvisitors.visitors.Visitor;

public class MyArrayList implements MyArrayListI{

	private List<MyArrayI> arrayList = new ArrayList<MyArrayI>();

	public List<MyArrayI> getArrayList() {
		return arrayList;
	}

	public void setArrayList(List<MyArrayI> arrayListIn) {
			arrayList = arrayListIn;
	}

	public void accept(Visitor visitor,Results resIn)
	{
		visitor.visit(this,resIn);
		
	}
	
	public void printList(){
		System.out.println("in MyArrayList "+arrayList);
	}

	
}
