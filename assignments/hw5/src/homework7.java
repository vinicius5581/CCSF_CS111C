import java.util.ArrayList;


public class homework7 {
   
   public static void main(String[] args) {
      
   System.out.println(50%7);
   System.out.println(1400%7);
   System.out.println(750%7);
   System.out.println(800%7);
       
   int[] a = { 1, 1, 3, 4, 6 } ;
   Integer[] z = { 7, 7, 1, 8, 4, 6, 3, 8, 7, 7, 7, 7 } ;
   /*
   System.out.println("wtf");
   if(search(a, 0, 2))
      System.out.println("yes");
   
   if(search(a, 0, 5))
      System.out.println("yes");
   else
      System.out.println("no");
    
   int b= binarySearch(a, 0, a.length-1, 5);
   System.out.println(b);
   int c= binarySearch(a, 0, a.length-1, 2);
   System.out.println(c);
   
   if (binarySearchNew(a, 2) )
      System.out.println("2 in");
   else
      System.out.println("2 out");
   
   
   if (binarySearchNew(a, 1) )
      System.out.println("1 in");
   else
      System.out.println("1 out");
   
   if (binarySearchNew(a, 6) )
      System.out.println("6 in");
   else
      System.out.println("6 out");
   */
   //Integer f = largest(z, 0, z.length-1);
   //System.out.println(f);
  // ArrayList<Integer> k = new ArrayList<Integer>();
   //k = duplicates(a, 1);
   //for(Integer i : k)
    //  System.out.println(i);
   
   }
   
   public static boolean contains(int[] array, int anEntry)
   {
      for(int i = 0; i < array.length; i++)
      {
         if(array[i] == anEntry)
            return true;
         else if(array[i] > anEntry)
            return false;
      }
      return false;
   }
   
   private static boolean search(int[] array, int position, int entry)
   {
      boolean found = false;
      
      if(position == array.length)
         found = false;
      else if(array[position] > entry)
         found = false;
      else if(array[position] == entry)
         found = true;
      else
         found = search(array, position+1, entry);
      
      return found;
   }

   public static int binarySearch(int[] array, int first, int last, int desired) {
          
      
      if(first > last)
      {
        // System.out.println(last);
         return -(first+1);
      }
      
      int mid = (first + last)/2;
      
      if(array[mid] == desired)
         return mid;
      else if(array[mid] > desired)
         return binarySearch(array, first, mid-1, desired);
      else
         return binarySearch(array, mid+1, last, desired);
      
   }
   
   public static boolean binarySearchNew(int[] a, int desired) {
      
      int first = 0;
      int last = a.length-1;
      int mid = (first+last)/2;
      while(first <= last)
      {
         System.out.println("mid " + mid);
         if (a[mid] == desired)
            return true;
         else if(a[mid] > desired )
            last = mid-1;
         else
            first = mid+1;

         mid = (first+last)/2;
      }
      return false;
   }
   
   
   public static Integer largest(Integer[] array, int first, int last) {
          
      System.out.println("First is " + first + " Last is " + last);
      int mid = (first+last)/2;
      if(first == mid)
      {
         return array[first];
      }

      System.out.println("mid is " + mid);
      Integer a = largest(array, first, mid-1);
      Integer b = largest(array, mid+1, last);
      System.out.println("comparing " + a + " to " + b);
      if(a.compareTo(b) > 0)
         return a;
      else
         return b;

   }
   
   public static ArrayList<Integer> duplicates(int[] array, int desired)
   {
      ArrayList<Integer> k = new ArrayList<Integer>(); 
      for(int i = 0; i < array.length; i++)
          if(array[i] == desired)
             k.add(i);
      return k;
   }
}
