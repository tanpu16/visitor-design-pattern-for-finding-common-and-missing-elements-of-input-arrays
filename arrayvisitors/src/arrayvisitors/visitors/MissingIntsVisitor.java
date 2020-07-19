package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.Results;

public class MissingIntsVisitor implements Visitor {

	@Override
	public void visit(MyArrayListI myArrayListObj,Results res) throws NoSuchMethodError{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(MyArrayI myArrayObj,Results res) {
		// TODO Auto-generated method stub
		
		
		int range = 100;
		
		int present[] = new int[range];
		
		for(int i=00; i<range; i++)
		{
			present[i] = 0;
		}

		for(int i=0; i<myArrayObj.getArray().length;i++)
		{
			present[myArrayObj.getArray()[i]] = 1;
		}
		
		for(int j=0; j<present.length;j++)
		{
			if(present[j] == 0)
			{
				res.store(j);
			}
		}
		
		
		
	}


}
