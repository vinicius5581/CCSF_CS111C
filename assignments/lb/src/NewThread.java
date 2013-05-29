
public class NewThread extends Thread
{
   private String name;
   
   public NewThread(String name)
   {
      this.name = name;
   }
   
   public void run()
   {
      for(int i = 0; i < 5; i++)
      {
          System.out.println(name +" says Hi. " + i);
          try {
            this.sleep(1000);
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
       }
   }
}
