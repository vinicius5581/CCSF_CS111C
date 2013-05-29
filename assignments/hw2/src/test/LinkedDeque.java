package test;

/**
 * A class that implements the ADT deque by using a doubly linked chain of nodes.
 * 
 * @author Frank M. Carrano
 * @version 2.0
 */
public class LinkedDeque<T> implements DequeInterface<T>, 
                                       java.io.Serializable
{
  private DLNode firstNode; // references node for front of deque
  private DLNode lastNode;  // references node for back of deque
   
   public LinkedDeque()
   {
      firstNode = null;
      lastNode = null;
   } // end default constructor
   
   // 24.38
   public void addToFront(T newEntry)
   {
     DLNode newNode = new DLNode(null, newEntry, firstNode);
     
     if (isEmpty())
       lastNode = newNode;
     else
       firstNode.setPreviousNode(newNode);
       
     firstNode = newNode;
   } // end addToFront

   // 24.38
   public void addToBack(T newEntry) // similar to enqueue in 24.03
   {
      DLNode newNode = new DLNode(lastNode, newEntry, null);
      
      if (isEmpty())
         firstNode = newNode;
      else
         lastNode.setNextNode(newNode);
      
      lastNode = newNode;
   } // end addToBack

   public T getFront() // same as in LinkedQueue 24.04
   {
      T front = null;
      
      if (!isEmpty())
         front = firstNode.getData();
      
      return front;
   } // end getFront

   public T getBack()
   {
      T back = null;
      
      if (!isEmpty())
         back = lastNode.getData();
      
      return back;
   } // end getBack

   // 24.39
   public T removeFront()
   {
     T front = null;
     
     if (!isEmpty())
     {
       front = firstNode.getData();
       firstNode = firstNode.getNextNode();
       
       if (firstNode == null)
         lastNode = null;
       else
         firstNode.setPreviousNode(null);
     } // end if
     
     return front;
   } // end removeFront
      
   // 24.39
   public T removeBack()
   {
      T back = null;
      
      if (!isEmpty())
      {
         back = lastNode.getData();
         lastNode = lastNode.getPreviousNode();
         
         if (lastNode == null)
            firstNode = null;
         else
            lastNode.setNextNode(null);
      } // end if
      
      return back;
   } // end removeBack

   public boolean isEmpty()
   {
      return (firstNode == null) &&(lastNode == null);
   } // end isEmpty
   
   public void clear()
   {
      firstNode = null; 
      lastNode = null;
   } // end clear

   private class DLNode implements java.io.Serializable
   {
      private T      data;     // deque entry
      private DLNode next;     // link to next node
      private DLNode previous; // link to previous node

      private DLNode(T dataPortion)
      {
         data = dataPortion;
         next = null;   
         previous = null;  
      } // end constructor
      
      private DLNode(DLNode previousNode, T dataPortion, DLNode nextNode)
      {
         data = dataPortion;
         next = nextNode;  
         previous = previousNode;
      } // end constructor

      private T getData()
      {
         return data;
      } // end getData

      private void setData(T newData)
      {
         data = newData;
      } // end setData

      private DLNode getNextNode()
      {
         return next;
      } // end getNextNode
      
      private void setNextNode(DLNode nextNode)
      {
         next = nextNode;
      } // end setNextNode

      private DLNode getPreviousNode()
      {
         return previous;
      } // end getPreviousNode
      
      private void setPreviousNode(DLNode previousNode)
      {
         previous = previousNode;
      } // end setPreviousNode
   } // end DLNode
} // end LinkedDeque
