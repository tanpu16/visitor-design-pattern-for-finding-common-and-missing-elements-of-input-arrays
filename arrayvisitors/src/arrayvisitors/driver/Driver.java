package arrayvisitors.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import arrayvisitors.util.FileProcessor;

/**
 * @author John Doe
 *
 */
public class Driver {
	private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 7;

	public static void main(String[] args) throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if (args.length != 7) {
			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_CMDLINE_ARGS);
			System.exit(0);
		}
		System.out.println("Hello World! Lets get started with the assignment");
		
		
		FileProcessor fp = null;
		try 
		{
		
		} 
		catch (InvalidPathException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		} 
		finally
		{
			fp.close();
		}
	}
}
