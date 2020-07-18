package arrayvisitors.adt;

import java.util.List;

import arrayvisitors.util.Results;
import arrayvisitors.visitors.Element;
import arrayvisitors.visitors.Visitor;

public interface MyArrayListI extends Element{

	public List<MyArrayI> getArrayList();
	public void setArrayList(List<MyArrayI> arrayListIn);
	public void printList();

}
