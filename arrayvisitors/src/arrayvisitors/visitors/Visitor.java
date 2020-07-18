package arrayvisitors.visitors;

import java.io.IOException;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.Results;

public interface Visitor {

	public void visit(MyArrayListI myArrayListObj,Results res);
	public void visit(MyArrayI myArrayObj,Results res);
	
	
}
