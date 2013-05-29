import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
/**
 * This class implements a binary tree by using an array.
 * 
 * @author Charles Hoot 
 * @version 2.0
 */
public class ArrayBinaryTree<T> implements BinaryTreeInterface<T>,java.io.Serializable
{
    private T   theData[];
    private int height; // height of tree
    private int size;   // number of locations in array for a full tree of this height
    private final int ROOT = 1;
    private final Integer SENTINAL = -1;
    public ArrayBinaryTree()
    {
        // IMPLEMENT DEFAULT CONSTRUCTOR
        // INITIALIZE THE THREE INSTANCE DATA VARIABLES
      height = 1;
      size = 1;
      theData = (T[])new Object[4];
      theData[ROOT] = (T) SENTINAL;
      
    } 
    
    public ArrayBinaryTree(T rootData)
    {
        // IMPLEMENT THE CONSTRUCTOR FOR A ONE-NODE TREE
      this();
      theData[ROOT] = rootData;
    } 
    
    public ArrayBinaryTree(T rootData, ArrayBinaryTree<T> leftTree,
                                       ArrayBinaryTree<T> rightTree)
    {
        // IMPLEMENT THE CONSTRUCTOR THAT TAKES A NEW ROOT AND LEFT AND RIGHT SUBTREE
      this();
      
      theData[ROOT] = rootData;
      setRightSubtree(rightTree);
      setLeftSubtree(leftTree);
      height = (leftTree.getHeight() >= rightTree.getHeight())
               ?leftTree.getHeight()+1:rightTree.getHeight()+1;
      
    } 

    public void setTree(T rootData)
    {
        // SET THE TREE TO BE A NEW ONE-NODE TREE
        // UPDATE THE HEIGHT, SIZE, ROOT, AND SUBTREES
      height = 1;
      size = 1;
      theData = (T[])new Object[4];
      theData[ROOT] = rootData;
      
    } 

    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                                    BinaryTreeInterface<T> rightTree)
    {
        // SET THE TREE TO BE A NEW TREE WITH THE SPECIFIED ROOT AND LEFT AND RIGHT SUBTREES
        // UPDATE THE HEIGHT, SIZE, ROOT, AND SUBTREES
      int rightCount = 3;
      int leftCount = 3;
      
      
      if(rightTree == null)
         rightTree = new ArrayBinaryTree();
      else{
         System.out.println(rightTree.getRootData() + ": Right Root");
         rightCount = ((ArrayBinaryTree<T>) rightTree).getArraySize();
         
      }if(leftTree == null)
         leftTree = new ArrayBinaryTree();
      else{
         leftCount = ((ArrayBinaryTree<T>) leftTree).getArraySize();
         System.out.println(leftTree.getRootData() + " : Left Root");
      }
      setRightSubtree((ArrayBinaryTree<T>) rightTree);   
      setLeftSubtree((ArrayBinaryTree<T>) leftTree);
      //resizeArray(theData.length + rightCount + leftCount);
      resizeArray(theData.length + 
            ((ArrayBinaryTree<T>) rightTree).getNumberOfNodes() + 
               ((ArrayBinaryTree<T>) leftTree).getNumberOfNodes());
      System.out.println((theData.length) + " : NodeCount");
      theData[ROOT] = rootData;
      
    } 

       
    /* 
    * Finds the size of the array necessary to fit a tree of height h. 
     */
    protected int getArraySize(){return theData.length;}
    private int getSizeFromHeight(int h)
    {
        // YOU MIGHT FIND THIS METHOD HELPFUL
        // IT CALCULATES THE SIZE OF THE ARRAY NEEDED TO ACCOMODATE A TREE OF HEIGHT H
      return (int)Math.pow(2,h)-1;
    }
        
    /*
     * Copies the data values from the given subtree into the leftsubtree.
     * Precondition: The array theData is large enough to hold the new values.
     */
    private int setLeftSubtree(ArrayBinaryTree<T> subTree)
    {
        // YOU MIGHT FIND THIS METHOD HELPFUL
        // IT TAKES IN THE VALUES OF THE LEFT SUBTREE AND ADDS THEM TO THE ARRAY
      int factor = 1;
      int node = 1;
      int numOnLevel;
      int height = subTree.getHeight();
      int levelsAdded = 0;    
      for(int level = 1; level<=height; level++){
         numOnLevel = (int)Math.pow(2, level-1);
         for(int i = 0; i < numOnLevel;i++){
            theData[node+factor] = subTree.getData(node);
            
            node++;
         }// end row loop
         factor*=2;
         levelsAdded++;
      }// end level loop
      return levelsAdded;
    }
    
    /*
     * Copies the data values from the given subtree into the rightsubtree. 
     * Precondition: The array theData is large enough to hold the new values.
     */
    private int setRightSubtree(ArrayBinaryTree<T> subTree)
    {
        // YOU MIGHT FIND THIS METHOD HELPFUL
        // IT TAKES IN THE VALUES OF THE LEFT SUBTREE AND ADDS THEM TO THE ARRAY
      int factor = 2;
      int node = 1;
      int numOnLevel;
      int levelsAdded = 0;
      
      for(int level = 1; level<=height; level++){
         numOnLevel = (int)Math.pow(2, level-1);
         
         for(int i = 0; i < numOnLevel;i++){
            theData[node+factor] = subTree.getData(node);
            System.out.println(theData[node+factor] + ": copied");
            System.out.println(subTree.getData(node) + ": supposed to copy");
            node++;
         }// end row loop
         factor*=2;
         levelsAdded++;
      }// end level loop
      return levelsAdded;
    }
    
    public T getRootData()
    {
        // RETURNS THE ROOT OF THE TREE
        // BE SURE TO ACCOUNT FOR EMPTY TREES
      return theData[ROOT] != null? theData[ROOT]:null;
    } 
    
    public boolean isEmpty()
    {
        // RETURNS TRUE IF THE TREE IS EMPTY
      return theData[ROOT] == null;
    } 

    public void clear()
    {
        // EMPTIES THE TREE
      for(int i = 0; i < theData.length; i++)
         theData[i] = null;
    }

    protected void setRootData(T rootData)
    {
       // SETS THE ROOT OF THE TREE TO A NEW VALUE
      theData[ROOT] = rootData;
    }

    public int getHeight()
    {
        // GETS THE HEIGHT OF THE TREE
        // HINT: YOU MIGHT WANT TO ADD A PRIVATE METHOD THAT HELPS FIND THE HEIGHT USING RECURSION
      //System.out.println(theData[ROOT] != null);
      return (theData[ROOT] != null)? theHeight(ROOT):1;
      
    }
    private int theHeight(int node){
      
      if(leftChild(node) > 0 &&
            leftChild(node) < theData.length &&
               theData[leftChild(node)] != null){        
         return 1 + theHeight(leftChild(node));
         
      }else if (rightChild(node) > 0 &&
               rightChild(node) < theData.length &&
                  theData[rightChild(node)] != null){
         
         return 1 + theHeight(rightChild(node));
         
      }else{         
         return 1;         
      }
    }
       
    public int getNumberOfNodes()
    {
        // RETURNS THE NUMBER OF NODES IN THE TREE
        // REMEMBER THAT NOT ALL SPOTS OF THE ARRAY WILL NECESSARILY BE FILLED
      //return (nodeExists(ROOT))? countNodes(ROOT):null;
      int count = 1;
      for(int i = 1; i<theData.length; i++){
         if(theData[i] != null)
            count++;
      }
      return count;
      //return countNodes(ROOT);
    }
    private int countNodes(int node){
      
      
      if(theData[leftChild(node)] != null)
         return 1 + countNodes(leftChild(node));
      if(theData[rightChild(node)] != null)
         return 1 + countNodes(rightChild(node));
      return 1;
      
    }
    
 
    /*
     * The following operations allow one to move in the tree and test to see
     * whether a child exists. These methods have already been implemented.
     */
    protected boolean hasLeftChild(int i)
    {
        return nodeExists( ( 2 * i + 1) );
    }
    protected int leftChild(int i)
    {
        return 2 * i + 1;
    }
        
    protected boolean hasRightChild(int i)
    {
        return nodeExists( ( 2 * i + 2) );
    }
    protected int rightChild(int i)
    {
        return 2 * i + 2;
    }    
    
    protected boolean nodeExists(int i)
    {
        return (i >= 0 && i < size)  && (theData[i] != null);
    }
    protected int parent(int i)
    {
        return (i - 1) / 2;
    }
    protected T getData(int i)
    {
        T result = null;
        
        if (nodeExists(i))
            result = theData[i];
        return result;
    }
    
    private void resizeArray(int newSize)
    {
        // RESIZE THE ARRAY
        // FIND THE NEW SIZE NEEDED BASED ON THE HEIGHT
        // COPY THE CONTENTS OVER AND UPDATE HEIGHT AND SIZE
      T[] temp = (T[]) new Object[newSize];
      
      for(int i = 0; i < theData.length && theData[i] != null; i++){
         temp[i] = theData[i];
         System.out.println(temp[i]);
      }
      theData = temp;
      System.out.println("Resize new Length = " + theData.length);
    }

    public Iterator<T> getInorderIterator()
    {
        return new InorderIterator();
    } 
    
    private class InorderIterator implements Iterator<T>
    {
        private Stack<Integer> nodeStack;
        private Integer currentNode;
        
        public InorderIterator()
        {
            nodeStack = new Stack<Integer>();
            currentNode = 0;
        } 
        
        public boolean hasNext()
        {
            return !nodeStack.isEmpty() || nodeExists(currentNode);
        } 
        
        public T next()
        {
            Integer nextNode = -1;
            
            // find leftmost node with no left child
            while (nodeExists(currentNode))
            {
                nodeStack.push(currentNode);
                currentNode = leftChild(currentNode);
            } 
                        
            // get leftmost node, then move to its right subtree
            if (!nodeStack.isEmpty())
            {
                nextNode = nodeStack.pop();
                assert nodeExists(nextNode); // since nodeStack was not empty before the pop
                currentNode = rightChild(nextNode); // right subchild
            }
            else
                throw new NoSuchElementException();
                
            return theData[nextNode];
        } 
        
        public void remove()
        {
            throw new UnsupportedOperationException();
        } 
    } // end InorderIterator
/*
    public Iterator<T> getPreorderIterator()
    {
        return new PreorderIterator();
    } 
    
    private class PreorderIterator implements Iterator<T>
    {
        // EXTRA CREDIT
        // IMPLEMENT THE PREORDER ITERATOR
        
        public PreorderIterator()
        {
        } 
        
        public boolean hasNext()
        {
        } 
        
        public T next()
        {
        } 
        
        public void remove()
        {
        } 
    } // end PreorderIterator
    */
    public Iterator<T> getPostorderIterator()
    {
        return new PostorderIterator();
    } 
    
    private class PostorderIterator implements Iterator<T>
    {
        private Stack<PostOrderNode> nodeStack;
        
        public PostorderIterator()
        {
            nodeStack = new Stack<PostOrderNode>();
            if (!isEmpty())
                nodeStack.push(new PostOrderNode(0, PostOrderState.LEFT));
        } 
        
        public boolean hasNext()
        {
            return !nodeStack.isEmpty();
        } 
        
        public T next()
        {
            T result = null;
            if (nodeStack.isEmpty())
            {
                throw new NoSuchElementException();
            }
            else
            {
                PostOrderNode top = nodeStack.pop();
                PostOrderState state = top.state;
                
                while (state != PostOrderState.TOP)
                {
                    if (state == PostOrderState.LEFT)
                    {
                        top.state = PostOrderState.RIGHT;
                        nodeStack.push(top);
                        
                        if (hasLeftChild(top.node)) // hasLeftChild
                            nodeStack.push(new PostOrderNode(leftChild(top.node), PostOrderState.LEFT));
                    }
                    else
                    {
                        assert state == PostOrderState.RIGHT;
                        top.state = PostOrderState.TOP;
                        nodeStack.push(top);
                        
                        if (hasRightChild(top.node)) // hasRightChild
                            nodeStack.push(new PostOrderNode(rightChild(top.node), PostOrderState.LEFT));
                    }
                    top = nodeStack.pop();
                    state = top.state;
                }
                result = theData[top.node];
            }
           
            return result;
        } 
        
        public void remove()
        {
            throw new UnsupportedOperationException();
        } 
    } // end PostorderIterator 
    
    private enum PostOrderState {TOP, LEFT, RIGHT};
    
    private class PostOrderNode
    {
        public Integer node;
        public PostOrderState state;
        
        PostOrderNode(Integer theNode, PostOrderState theState)
        {
            node = theNode;
            state = theState;
        }
    }
    
    public Iterator<T> getLevelOrderIterator()
    {
        throw new UnsupportedOperationException();
    } 
    
    /* display the contents of the array */
    public void display()
    {
        for (int i = 0; i < size; i++)
        {
            if (nodeExists(i))
                System.out.println("index: " + i + " has " + getData(i));
        }
    }

   @Override
   public Iterator<T> getPreorderIterator() {
      // TODO Auto-generated method stub
      return null;
   }
}   
    

