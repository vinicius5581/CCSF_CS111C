

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
/**
 * This class implements a binary tree by using an array.
 * 
 * @author Charles Hoot 
 * @version 2.0
 */
public class ArrayBinaryTree<T>
             implements BinaryTreeInterface<T>,java.io.Serializable
{
    private T   theData[];
    private int height; // height of tree
    private int size;   // number of locations in array for a full tree of this height
    
    public ArrayBinaryTree()
    {
    	size=0;
    	theData = (T[]) new Object[size];
    	height=0;
        // IMPLEMENT DEFAULT CONSTRUCTOR
        // INITIALIZE THE THREE INSTANCE DATA VARIABLES      
    } 
    
    public ArrayBinaryTree(T rootData)
    {
    	size=1;
    	theData = (T[]) new Object[size];
    	height=1;
    	theData[0]=rootData;
        // IMPLEMENT THE CONSTRUCTOR FOR A ONE-NODE TREE     
    } 
    
    public ArrayBinaryTree(T rootData, ArrayBinaryTree<T> leftTree,
                                       ArrayBinaryTree<T> rightTree)
    {
    	size=3;
    	theData = (T[]) new Object[size];
    	height=3;
    	theData[0]=rootData;
    	if ((leftTree != null) && !leftTree.isEmpty())
    			setLeftSubtree(leftTree);
    	if ((rightTree != null) && !rightTree.isEmpty())
    		    setRightSubtree(rightTree);
    	if ((leftTree != null) && (leftTree != this))
    		leftTree.clear();
    	if ((rightTree !=null) && (rightTree != this))
    		rightTree.clear();
        // IMPLEMENT THE CONSTRUCTOR THAT TAKES A NEW ROOT AND LEFT AND RIGHT SUBTREE
    } 

    public void setTree(T rootData)
    {
    	theData = (T[]) new Object[size];
    	height =1;
    	size=1;
    	theData[0]=rootData;
    	setLeftSubtree(null);
    	setRightSubtree(null);
        // SET THE TREE TO BE A NEW ONE-NODE TREE
        // UPDATE THE HEIGHT, SIZE, ROOT, AND SUBTREES
    } 

    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                                    BinaryTreeInterface<T> rightTree)
    {
    	size=3;
    	theData = (T[]) new Object[size];
    	height=3;
    	theData[0]=rootData;
    	if ((leftTree != null) && !leftTree.isEmpty())
    			setLeftSubtree((ArrayBinaryTree<T>)leftTree);
    	if ((rightTree != null) && !rightTree.isEmpty())
    		    setRightSubtree((ArrayBinaryTree<T>)rightTree);
    	if ((leftTree != null) && (leftTree != this))
    		leftTree.clear();
    	if ((rightTree !=null) && (rightTree != this))
    		rightTree.clear();
        // SET THE TREE TO BE A NEW TREE WITH THE SPECIFIED ROOT AND LEFT AND RIGHT SUBTREES
        // UPDATE THE HEIGHT, SIZE, ROOT, AND SUBTREES       
    } 

       
    /* 
	 * Finds the size of the array necessary to fit a tree of height h. 
     */
    private int getSizeFromHeight(int h)
    {
    	int totalSize = ((2^getHeight()-1));
    	return totalSize;
        // YOU MIGHT FIND THIS METHOD HELPFUL
        // IT CALCULATES THE SIZE OF THE ARRAY NEEDED TO ACCOMODATE A TREE OF HEIGHT H
    }
        
    /*
     * Copies the data values from the given subtree into the leftsubtree.
     * Precondition: The array theData is large enough to hold the new values.
     */
    private void setLeftSubtree(ArrayBinaryTree<T> subTree)
    {
    	for (int i = 0; i < getHeight(); i++)
    	{
    		for (int j = 0; j < 2; j++)
    		{
    			theData[j + getSizeFromHeight(getHeight())] = subTree.theData[i];
    		}
    	}
    	
        // YOU MIGHT FIND THIS METHOD HELPFUL
        // IT TAKES IN THE VALUES OF THE LEFT SUBTREE AND ADDS THEM TO THE ARRAY
    }
    
    /*
     * Copies the data values from the given subtree into the rightsubtree. 
     * Precondition: The array theData is large enough to hold the new values.
     */
    private void setRightSubtree(ArrayBinaryTree<T> subTree)
    {
    	for (int i = 0; i < getHeight(); i++)
    	{
    		for (int j = 0; j < 2; j++)
    		{
    			theData[j] = subTree.theData[i];
    		}
    	}
        // YOU MIGHT FIND THIS METHOD HELPFUL
        // IT TAKES IN THE VALUES OF THE LEFT SUBTREE AND ADDS THEM TO THE ARRAY
    }
    
    public T getRootData()
    {
    	T rootData = null;
    	if (theData[0]!=null)
    		rootData=theData[0];
    	return rootData;
        // RETURNS THE ROOT OF THE TREE
        // BE SURE TO ACCOUNT FOR EMPTY TREES
    } 
    
    public boolean isEmpty()
    {
    	return theData[0]==null;
        // RETURNS TRUE IF THE TREE IS EMPTY
    } 

    public void clear()
    {
    	theData = (T[]) new Object[0];
        // EMPTIES THE TREE
    }

    protected void setRootData(T rootData)
    {
    	theData[0]=rootData;
       // SETS THE ROOT OF THE TREE TO A NEW VALUE
    }

    public int getHeight()
    {
    	double height = Math.log(theData.length+1)/Math.log(2.0);
    	int h = (int) Math.round(height);
    	return h;
        // GETS THE HEIGHT OF THE TREE
        // HINT: YOU MIGHT WANT TO ADD A PRIVATE METHOD THAT HELPS FIND THE HEIGHT USING RECURSION
    }
       
    public int getNumberOfNodes()
    {
    	int nullcount=0;
    	for (int i = 0; i < theData.length; i++)
    	{
    		if (theData[i] ==null)
    			nullcount+=1;
    	}
    	return getHeight()-nullcount;
        // RETURNS THE NUMBER OF NODES IN THE TREE
        // REMEMBER THAT NOT ALL SPOTS OF THE ARRAY WILL NECESSARILY BE FILLED
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
    
    private void resizeArray()
    {
        // RESIZE THE ARRAY
        // FIND THE NEW SIZE NEEDED BASED ON THE HEIGHT
        // COPY THE CONTENTS OVER AND UPDATE HEIGHT AND SIZE
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

   // public Iterator<T> getPreorderIterator()
    //{
     //   return new PreorderIterator();
    //} 
    
    //private class PreorderIterator implements Iterator<T>
    {
        // EXTRA CREDIT
        // IMPLEMENT THE PREORDER ITERATOR
        
        //public PreorderIterator()
        {
        } 
        
       // public boolean hasNext()
        {
        } 
        
       // public T next()
        {
        } 
        
        //public void remove()
        {
        } 
    } // end PreorderIterator
    
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
}   
    

