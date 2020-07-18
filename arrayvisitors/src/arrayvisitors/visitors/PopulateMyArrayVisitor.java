package arrayvisitors.visitors;

import java.io.IOException;
import java.util.Arrays;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.Results;

public class PopulateMyArrayVisitor implements Visitor{
	
	boolean invalidInput,isEmptyFile,isEmptyLine;

	
	FileProcessor fp = null;
	
	public PopulateMyArrayVisitor()
	{
		invalidInput = false; 
		isEmptyFile = false;
		isEmptyLine = false;
	}
	
	public void setInputFile(FileProcessor fpIn)
	{
		fp = fpIn;
	}
	
	@Override
	public void visit(MyArrayI myArrayIn,Results res) 
	{
		try
		{
			String line = fp.poll();
			int i=0,capacity = 10;
			int array[] = new int[capacity];
			
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
				
				if(i >= capacity)
				{
					capacity = capacity + (capacity/2);
					int temp[] = Arrays.copyOf(array, capacity);
					array = temp;
				}
				
				array[i] = Integer.parseInt(line);
				i++;
				line = fp.poll();
			}
			
			myArrayIn.setArray(array);
			
			//arrayListObj.getArrayList().add(myArrayIn);
			
		}
		catch(IOException  e)
		{
			System.err.println("input/output Exception ocuured! Exiting!");
			e.printStackTrace();
			System.exit(0);
		}
		catch(NumberFormatException ne)
		{
			System.err.println("String from the file cannot be converted into int! Exception! Exiting!");
			ne.printStackTrace();
			System.exit(0);
		}
		finally
		{
			try {
				fp.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			try {
				fp.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void visit(MyArrayListI myArrayListObj,Results res) throws NoSuchMethodError{
		// TODO Auto-generated method stub
		
	}




}
