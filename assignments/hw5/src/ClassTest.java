
public class ClassTest implements Comparable
{
   private int length;
   private int[] array;
   public int d = 0;
   protected int e = 0;
   
   public ClassTest()
   {
      length = 0;
      array = new int[10];
      for(int i = 0; i < array.length; i++)
         array[i] = i;
   }
   
   public boolean compare(ClassTest a)
   {
      ClassTest b = a;
      int size = b.length;
      b.length = 10;
      System.out.println("inside classtest " + b.length);
      return false;
      
   }
   
   public int getLength()
   {
      return length;
   }
   
   private int getLength2()
   {
      return length;
   }

   @Override
   public int compareTo(Object arg0) {
      // TODO Auto-generated method stub
      return 0;
   }
}
