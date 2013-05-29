import java.util.List;


public class Bs<T> 
{
   int length;
   int pos =0;
   int[] a;
   List<T> list;
   List<T> tmp;
   
   public Bs(List<T> t)
   {
      list = t;
   }
   
   public Bs(int length)
   {
      this.length = length;
      a = new int[length];
      int j = 9;
   }
   
   public Bs(int[] array)
   {
      this(10);
      for(int i : array)
         add(i);
   }
   
   public void add(int b)
   {
      a[pos] = b;
      pos++;
   }
   
   public static<T> void put(List<? super T> a)
   {
      
   }
   
   public static<T >void get(List<? extends T> a)
   {
      
   }
   
   public static<T> void copy(List<? super T> dst, List<? extends T> src)
   {
   ////   for(int i = 0; i< src.size(); i++)
    //  {
       //  dst.add(i, src.get(i));
   //   }
    //  
    //  for(int i = 0; i < dst.size(); i++)
     //    System.out.println(dst.get(i));
   }
}
