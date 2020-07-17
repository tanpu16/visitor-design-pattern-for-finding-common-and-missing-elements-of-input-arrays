package arrayvisitors.adt;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList implements MyArrayListI{

	private List<MyArrayI> arrayList = new ArrayList<MyArrayI>();

	public List<MyArrayI> getArrayList() {
		return arrayList;
	}

	public void setArrayList(List<MyArrayI> arrayListIn) {
			arrayList = arrayListIn;
	}

	public void printList(){
		System.out.println("in MyArrayList "+arrayList);
	}	
}
