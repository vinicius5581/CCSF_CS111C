
public class ThreadDemo
{
   public static void main(String[] args) throws InterruptedException
   {
      System.out.println("Main Thread.");
      NewThread t = new NewThread("Subthread");
      t.start();
      
      Thread c = Thread.currentThread();
      System.out.println(c.getName() + " is going to sleep!");
   //   c.sleep(4000);
      t.interrupt();
      System.out.println(c.getName() + " is woke up!");

   }
}
