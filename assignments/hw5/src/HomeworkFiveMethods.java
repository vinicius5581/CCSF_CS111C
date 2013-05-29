import java.util.Scanner;


public class HomeworkFiveMethods {

   public static void main(String[] args) {
      
      displayRowOfCharacters('*', 5);
      System.out.println("check");
      
     // int number = getInteger();
      //System.out.println(number);
      
      //int n = factorial(3);
      //System.out.println(n);
      
      int[] a = {3, 2, 1};
      //displayArrayBackWards(a, );
      //reverseArray(a,0);
     // for(int i : a)
      //   System.out.println(i);
      
      reverseArrayB(a, 0);
      
     String w = reverseString("word", 0);
     System.out.println(w);
     
     boolean yes = isPalindrome("level");
     if(yes)
        System.out.println("yes");
     
     int sum = sum(a, 0, 2);
     System.out.println(sum);
     
     System.out.println(findSmallest(a, a[0], a.length));
     
   }
   
   public static void displayRowOfCharacters(char c, int n)
   {
      //return when we hit 0; prior to that print c
      if(n > 0)
      {
         System.out.print(c);
         displayRowOfCharacters(c, n-1);
      }
      else
         System.out.println();
   }
   
   private static int getInteger() {
      
      System.out.println("Please enter number between 1 and 10");
      Scanner sc = new Scanner(System.in);
      String input = sc.next();
      int number = Integer.parseInt(input);
      if (!(number >= 1 && number <=10))
      {
         return getInteger();
      }
      else
         return number;
            
   }
   
   private static int factorial(int n)
   {
      if(n == 0)
         return 1;
      else
         return n*factorial(n - 1);
   }
   
   private static void displayArrayBackWards(int[] array, int n)
   {
      
      if(n < array.length)
      {
         displayArrayBackWards(array, n+1);
         System.out.println(array[n]);
      }
      
   }
   
   private static void reverseArray(int[] array, int position)
   {
      
      if(position < array.length)
      {
         int temp = array[array.length -(position+1)];
         reverseArray(array, position+1);
         array[position] = temp;
         System.out.println("Index: " + position + " now contains: " + temp);
      }
   }
   
   public static void reverseArrayB(int[] array, int position)
   {
      if(position < array.length)
      {
         int temp = array[array.length - (position + 1)];
         System.out.println(array[array.length - (position+1)]);
         reverseArrayB(array, position+1);
         array[position] = temp;
         System.out.println("Index: " + position + " now contains: " + temp);
      }
   }
   
   private static String reverseString(String word, int ch)
   {
      if(ch < word.length())
      {
         String c = word.substring(ch, ch+1);
         return (reverseString(word, ch+1) + c);
      }
      else
         return "";
   }
   
   
   private static boolean isPalindrome(String word)
   {
      
      if(word.length() == 1 || word.length() == 0 )
         return true;
      else
      {
         String start = word.substring(0, 1);
         String end = word.substring(word.length() - 1, word.length());
         if(start.equals(end))
         {
            word = word.substring(1, word.length()-1);
            return isPalindrome(word);
         }
         else
            return false;
      }
      
   }
   
   private static int sum(int[] array, int first, int last)
   {
      if(first == last)
         return array[first];
      else
      {
         int mid = (first+last)/2;
         int a = sum(array, first, mid);
         int b = sum(array, mid+1, last);
         return a+b;
      }
   }
   
   private static int findSmallest(int[] array, int smallest, int position)
   {
      if(position < array.length)
      {
         int small = smallest;
         if(smallest > array[position])
            small = array[position];
         return findSmallest(array, small, position+1);
      }
      else
         return smallest;
   }
}
