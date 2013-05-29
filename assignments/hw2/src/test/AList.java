package test;

import java.lang.reflect.Array;

public class AList<T>
{
  private T[] list; // array of list entries
  private int length; // current number of entries in list
  private static final int MAX_SIZE = 50; // max length of list not used if AList
                                          // constructor takes in an array
	  
  public AList(T[] array)
  {
	assert array.length <= MAX_SIZE;
	
	length = array.length;
	list = (T[]) new Object[MAX_SIZE];
  
    for(int i = 0; i < list.length; i++)
    {
        list[i] = array[i];
    }
  }

  public void s(T array[])
  {}
  
  public int getLength()
  { return length; }

}
