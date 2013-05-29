package lab;

/** An interface for the ADT list
 * 
 * @author Victor Malchikov
 *
 * @param <T> 
 */

public interface EntryWayListInterface<T>
{
	/** Task: Adds a Head to the list.
	 *  List's size is increased by 1. 
	 * @param newEntry object to be added as a new entry.
	 * @return true if the addition is successful, or false 
	 */
	public abstract boolean insertHead(T newEntry);
	
	public abstract boolean insertTail(T newEntry);
	
	public abstract T deleteHead();
	
	public abstract T deleteTail();
	
	public abstract void display();
	
	public abstract int contains(T anEntry);
	
	public abstract boolean isEmpty();
	
	public abstract boolean isFull();
	

}
