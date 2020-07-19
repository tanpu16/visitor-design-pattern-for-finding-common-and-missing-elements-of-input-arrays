package arrayvisitors.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.FileDisplayInterface;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.Results;
import arrayvisitors.util.SingletonMyLogger;
import arrayvisitors.visitors.CommonIntsVisitor;
import arrayvisitors.visitors.MissingIntsVisitor;
import arrayvisitors.visitors.PopulateMyArrayVisitor;
import arrayvisitors.visitors.Visitor;

/**
 * @author John Doe
 *
 */
public class Driver {
	private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 6;

	public static void main(String[] args) throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if (args.length != 6) {
			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_CMDLINE_ARGS);
			System.exit(0);
		}
		System.out.println("Hello World! Lets get started with the assignment");
		
		FileProcessor fp = null;
		MyArrayListI list = new MyArrayList();
		MyArrayI array1 = new MyArray();
		MyArrayI array2 = new MyArray();
		PopulateMyArrayVisitor pv = new PopulateMyArrayVisitor();
		FileDisplayInterface outputRes1 = new Results(args[2]);
		FileDisplayInterface outputRes2 = new Results(args[3]);
		FileDisplayInterface outputRes3 = new Results(args[4]);
		
		
		SingletonMyLogger.setDebugValue(Integer.parseInt(args[5]));
		try 
		{
			fp = new FileProcessor(args[0]);
			pv.setInputFile(fp);
			array1.accept(pv,(Results)outputRes1);
			fp = new FileProcessor(args[1]);
			pv.setInputFile(fp);
			array2.accept(pv,(Results)outputRes2);
			
			list.getArrayList().add(array1);
			list.getArrayList().add(array2);
			
			Visitor commonVisitor = new CommonIntsVisitor();
			list.accept(commonVisitor,(Results)outputRes1);
			outputRes1.writeToFile();
			((Results)outputRes1).writeToStdout();
			
			Visitor missingVisitor = new MissingIntsVisitor();
			
			array1.accept(missingVisitor, (Results)outputRes2);
			outputRes2.writeToFile();
			((Results)outputRes2).writeToStdout();
			
			array2.accept(missingVisitor, (Results)outputRes3);
			outputRes3.writeToFile();
			((Results)outputRes3).writeToStdout();
			
		} 
		catch (InvalidPathException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		} 

	}
}
  