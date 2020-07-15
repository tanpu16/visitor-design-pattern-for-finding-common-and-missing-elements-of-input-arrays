package arrayvisitors.adt;
import java.io.IOException;


import arrayvisitors.util.FileProcessor;


public class HelperClass {
	
	boolean invalidInput,isEmptyFile,isEmptyLine;
	
	//default TreeHelper constructor
	public HelperClass()
	{
		invalidInput = false;
		isEmptyFile = false;
		isEmptyLine = false;
	
		//MyLogger.writeMessage("TreeHelper constructor called", DebugLevel.CONSTRUCTOR);
	}
	
	
	@Override
	public String toString()
	{
		return "TreeHelper [invalidInput : "+invalidInput+" isEmptyFile : "+isEmptyFile+" isEmptyLine : "+isEmptyLine+"]"; 	
	}
	
	/*this is a helper method which takes instances of 2 classes used to perform operations on input file.
	operations like fetching line by using poll() method of FileProcessor class, error message in
	store method of Result class.
	@param fp an instance of FileProcessor.java class from util package
	@param errorRes an instance of Results.java class from util package
	@return void
	@see just an helper function for performing different operations on input.txt file like parse the input
	store error message, create clone of nodes and recursively call insert for creating BST and insertUpdate function
	to make any required changes
	*/
	public void inputParser(FileProcessor fp) throws IOException, NumberFormatException
	{
		
		try
		{
			String line = fp.poll();
			
			if(null == line)
			{
				isEmptyFile = true;
			}
			
			while(null != line)
			{
				if(line.contains(" "))
				{
					invalidInput = true;
				}
				 
				 line = fp.poll();
			}

			 
		}
		catch(IOException | NumberFormatException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
		finally
		{
			fp.close();
		}
		try
		{
			if(invalidInput)
			{
				throw new IOException("Invalid Input! Exiting!!!");
			}
			else if(isEmptyFile)
			{
				throw new IOException("File is Empty! Exiting!!!");
			}
			else if(isEmptyLine)
			{
				throw new IOException("empty line in input file! Exiting!!!");
			}
			
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
			System.exit(0);
		}
		finally
		{
			fp.close();
		}
	}

}