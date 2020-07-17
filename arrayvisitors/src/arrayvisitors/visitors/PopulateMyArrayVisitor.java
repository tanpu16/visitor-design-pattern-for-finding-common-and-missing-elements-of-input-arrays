package arrayvisitors.visitors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.FileProcessor;

public class PopulateMyArrayVisitor {
	
	boolean invalidInput,isEmptyFile,isEmptyLine;
	
	MyArrayI arrayObj;
	
	public PopulateMyArrayVisitor(MyArrayI myArrayIn)
	{
		arrayObj = myArrayIn;
	}
	
	public void inputParser(FileProcessor fp,MyArrayListI arrayListObj) throws IOException, NumberFormatException
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
			
			arrayObj.setArray(array);
			
			arrayListObj.getArrayList().add(arrayObj);
			
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
