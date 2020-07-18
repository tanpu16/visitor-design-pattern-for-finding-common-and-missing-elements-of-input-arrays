package arrayvisitors.visitors;

import arrayvisitors.util.Results;

public interface Element {
	
	public void accept(Visitor visitor,Results resIn);

}
