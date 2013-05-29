import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DemoBST 
{
   public static String car = "d";
   public static void main(String args[])
   {
      int[] a = { 1, 2, 3, 4, 5 };
      BinarySearchTree bst = new BinarySearchTree(a);
      bst.print(bst.getRoot());
      
      System.out.println("*******************");
      
      int[] b = { 5, 4, 3, 2, 1 };
      bst = new BinarySearchTree(b);
      bst.print(bst.getRoot());
      
      System.out.println("*******************");
      
      int[] c = { 10, 11, 20, 8, 7, 2, 1 };
      bst = new BinarySearchTree(c);
      bst.print(bst.getRoot());
      ArrayList<String> sss = new ArrayList<String>();
      sss.add("hello");
      sss.add("hello");
      sss.add("hello");
      sss.add("dd");
      sss.add("hello");
      sss.add("dd");
      for(int i = 0; i < sss.size() && !sss.get(i).equals("dd"); i++)
         ;
      
     // true = boolean sd;
      boolean sd =true;
      if(sd == true)
         System.out.println("dd");
      
      boolean cot = (1 != 3);
      boolean coj = (1 == 1);
      System.out.println(cot + " " + coj);
      
      int kd = 1;
      for ( ; kd < 4; kd++)
         coj = true;
      
      String test = "";
      if(test.equals(null))
         System.out.println("test");
      
      List<Number> objs = new ArrayList<>();
      List<Integer> ii = new ArrayList<>();
      //objs.addAll(ii);
     // objs.add(44);
    //  objs.add(45);
      ii.add(3);
      ii.add(2);
      //Bs<Integer> k = new Bs<>(objs);
      //Bs<Number> jk = new Bs<>(ii);
      Bs.copy(objs, ii);
      Bs.put(objs);
      Bs.put(ii);
      List<Object> adf = new ArrayList<>();
      Bs<Object> ddd = new Bs<>(adf);
      List<? super Integer> testd = new ArrayList<Object>();
      testd.add(1);
     // testd.add(1.0);
      
      /*
      if("a".compareTo(null) > 0)
         System.out.println("j");
      else if(true)
         System.out.println("");
      */
      if("".equals(null))
         System.out.println("null");
      else if(true)
         System.out.println("   s");
      int[] array1 = new int[10];
      for(int d = 0; d < array1.length; d++)
         System.out.println(array1.length);
      
     // HashMap<String, String>[] kkk = (HashMap<String, String>[]) new Comparable[10];
      //kkk[1] = "String";
      //kkk[0] = "String";
      //if(kkk[0].compareTo(kkk[1]) == 0)
       //  System.out.println("eq");
      Integer cc =1;
      Integer dd = 10;
     // for(int l = 0; l < 4; l++)
     //    l = l-1;
      String dk = null;
      //if(dk.equals(null))
      //   System.out.println("aaaaaaaaa");
      
      if(cc == dd)
         System.out.println("cc");
      if(cc.equals(dd))
         System.out.println("cc");

      if(cc.compareTo(dd) != 1)
         System.out.println("dddddd");
      
      Integer h;
      Integer p;
      h = p = 1;
      System.out.println(h + " " + p);
      //Node<String> newNode = new Node<String>("a");
      
      ClassTest aa = new ClassTest();
      ClassTest bb = new ClassTest();
      
      aa.compare(bb);
      System.out.println("out " + bb.getLength());
      ClassTest2 ccc = new ClassTest2();
      //ccc.getLength2();
      if(1 > aa.compareTo(bb))
         System.out.println("heel");
      
      Node<String> ssd = new Node<>("a");
      ssd.set(new Node<String>("aa"));
     // Node<String> sse= ssd.next;
      for(Node n = ssd; n != null; n = n.next)
         System.out.println("no way");
      
      for(int i = 0; i < 5; i ++)
      {
         if(i < 4 || i < 2)
            System.out.println(i);
         if(i < 4 && i < 2)
            System.out.println(i);
      }
   }
   
   public static void d(int i, String car)
   {
      i = 1; 
      car = "a";
   }
   
 
}


