import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;


public class StackPlay {
   
   public static void main(String[] args) {
      
      ArrayList<String> a = new ArrayList<String>(0);
      a.add("one");
      a.remove(a.size()-1);
      
      System.out.println(a.size());

      Stack<String> s = new Stack<String>();
      s.push("one");
      s.push("two");
      s.push("three");
      Stack<String> s2 = new Stack<String>();
      /*
      PriorityQueue<String> j = new PriorityQueue<String>();
      j.add("Jane");
      j.add("Jim");
      j.add("Jill");
      String name = j.remove();
      j.add(name);
      j.add("Jess");
      
      while(!j.isEmpty())
      {
         System.out.println(j.peek() + " " +j.remove() + " "+ j.size() + " " + j.peek() );
      }
      
      */
      System.out.println("*************************************");
      
      PriorityQueue<String> j = new PriorityQueue<String>();
      j.add("Jim");
      j.add("Jess");
      j.add("Jill");
      j.add("Jane");
      String n = j.remove();
      j.add(n);
      j.add(j.peek());
      j.add("Jim");
      j.remove();
      
      while(!j.isEmpty())
      {
         System.out.println(j.remove() + " "+ j.size());
      }
      
      System.out.println("*************************************");
      
      while(!s.isEmpty()) {
         s2.push(s.pop());
         
      }
      
      while(!s2.isEmpty()) {
         String tmp = s2.pop();
         System.out.println(tmp);
         s.push(tmp);
      }
      
      System.out.println("OR");
      display(s);
      
      
   }
   
   public static void display(Stack<String> s) {
      
      if(s.isEmpty())
         return;
     
      String tmp = s.pop();
      display(s);
      System.out.println(tmp);
      s.push(tmp);
   }
   

}
