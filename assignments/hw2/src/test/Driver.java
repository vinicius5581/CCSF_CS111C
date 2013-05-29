package test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Driver 
{
	public static void main(String[] args)
	{
	   String a = "AAAA1";
	   System.out.println(a.replaceAll("\\A-z", ""));
	   int[] d = { 1 , 2 };
	   int[] z = d;
	   d = null;

	   for(int i = 0; i < z.length; i++)
	   {
	      System.out.println(" z= "+ z[i]);
	   }
	   
	   Integer[] aa = { 2, 3, 13, 12, 11 };
	   System.out.println(isRepetitive("hel lo,hello"));
	   System.out.println(22%1);
	   System.out.println(4%1);
	   System.out.println("hel, lo1".replaceAll("\\W", ""));
	   for(int i =0; i < 4; ++i)
	      System.out.println(i);
	   int i = 1;
	   System.out.println(i++);
	   System.out.println(++i);
	   
	   if(false)
	      System.out.println("true"); System.out.println("shoot");
	      
	      System.out.println(1+1+"1");
	      System.out.println("3"+3+3);
	}
	
	public static boolean isRepetitive(String strg)
   {
      String newstrg = "";
      DequeInterface<String> s1 = new LinkedDeque<String>();
      DequeInterface<String> s2 = new LinkedDeque<String>();
      Stack<Character> s0 = new Stack<Character>();
      // Extract the letters form the string
      char[] ar = strg.toCharArray();
      int len = ar.length;
      
      for (int i = 0; i < len; i++)
      {
         // pick only the letter and make a new sting all upper case
         if (Character.isLetter(ar[i]))
            newstrg = newstrg + (Character.toUpperCase(ar[i]));
      }
      //if odd length returns false
      if (newstrg.length()%2!=0){
         return false;
      }
      // read string from both end and put them respectively in their stack
      // 1st letter in s1 add to front, last letter in s2 add toback, and so on.
      while (newstrg.length() >=2)
      {
         s1.addToFront(newstrg.substring(0, 1));
         s2.addToBack(newstrg.substring(newstrg.length() - 1));
         newstrg = newstrg.substring(1, newstrg.length() - 1);
      }
      // compare s1 s2
      while (!s1.isEmpty())
      {
         if (!s1.removeFront().equalsIgnoreCase(s2.removeFront()))
            return false;
      }
      return true;
   }
	
	public static Comparable<?> get()
	{
      return null;
	   
	}

}