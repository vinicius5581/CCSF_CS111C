import java.util.ArrayList;


public class BinarySearchTree 
{
   private Node root;
   
   public BinarySearchTree(int[] a)
   {

      for(int i = 0; i < a.length; i++)
      {
         if(i == 0)
            root = new Node(a[i]);
         else
         {
            if(root.data >= a[i])
               addLeft(a[i], root.left, root);  
            else
               addRight(a[i], root.right, root);
         }
      }
   }
   
   public void addLeft(int val, Node left, Node root)
   {
      
      if(left == null)
      {
         root.left = new Node(val);  
      }
      if(left != null)
      {
         if(left.data >= val)
            addLeft(val, left.left, left);
         else
            addRight(val, left.right, left);
      }
      
   }
   
   
   public void addRight(int val, Node right, Node root)
   {
      if(right == null)
      {
         root.right = new Node(val);  
      }
      if(right != null)
      {
         if(right.data < val)
            addRight(val, right.right, right);
         else
            addLeft(val, right.left, right);
      }
   }
   
   public Node getRoot()
   {
      return root;
   }
   public void print(Node root)
   {
      if(root == null)
         return;
      else
      {
         print(root.left);
         System.out.println(root.data);
         print(root.right);
      }
   }
   
   private class Node
   {
      public int data;
      public Node left;
      public Node right;
   
      
      public Node(int val)
      {
         data = val;
         left = null;
         right = null;
      }

      
   }
   
} 
