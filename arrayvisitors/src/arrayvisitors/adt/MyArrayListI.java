package arrayvisitors.adt;

import java.util.List;
import arrayvisitors.visitors.Element;


public interface MyArrayListI extends Element{

	public List<MyArrayI> getArrayList();
	public void setArrayList(List<MyArrayI> arrayListIn);
	public void printList();

}
