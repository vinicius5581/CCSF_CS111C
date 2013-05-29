package test;

public class Demo 
{
   public static void main(String[] args)
   {
      Point a = new Point();
      PointUser pu = new PointUser(a);
      a.setX(2);
      Point check = pu.getPoint();
      System.out.println(check.getX());
   }
}
