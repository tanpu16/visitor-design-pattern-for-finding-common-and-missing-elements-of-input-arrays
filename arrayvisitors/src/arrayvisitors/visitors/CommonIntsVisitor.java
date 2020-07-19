package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.Results;


public class CommonIntsVisitor implements Visitor{

	@Override
	public void visit(MyArrayListI myArrayListObj,Results res) {

			MyArrayI myArray1 = myArrayListObj.getArrayList().get(0);
			MyArrayI myArray2 = myArrayListObj.getArrayList().get(1);
			
			for(int i=0;i < myArray1.getCapacity();i++)
			{
				for(int j=0;j< myArray2.getCapacity();j++)
				{
					if(myArray1.getArray()[i] == myArray2.getArray()[j])
					{
						res.store(myArray1.getArray()[i]);
					}
				}
			}
	}


	@Override
	public void visit(MyArrayI myArrayObj,Results res) throws NoSuchMethodError
	{
		// TODO Auto-generated method stub
		
	}

	
		
	


	
}
