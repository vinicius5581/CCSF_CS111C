package test;

public interface EntryWayListInterface<T>
{
  /** Task: Adds a new entry to the end of the list.
   *        Entries currently in the list are unaffected.
   *        The list’s size is increased by 1.
   *  @param newEntry  the object to be added as a new entry
   *  @return true if the addition is successful, or false if the list
   *          is full */
  boolean insertHead(T newEntry);
    /** Task: Adds a new entry to the head of the list.
     *        Entries are now at the next higher position within the list.
     *        List's size increased by 1.
     *  @param newEntry the object to add as a new entry.
     *  @return true if the addition is successful, false if the list is full.*/
  boolean insertTail(T newEntry);
    /** Task: Adds a new entry to the end of the list.
     *        Entries don't change at all.
     *  @param newEntry the object to add as a new entry.
     *  @return true if the addition is successful, false if the list is full.*/
  T deleteHead(); 
    /** Task: Delete the entry that is at the head of the list.
     *        All other entries swift back one posistion
     *        List's size decreased by 1.
     *  @param none
     *  @return the entry that is at the head of the list if any.*/
  T deleteTail();
    /** Task: Delete the entry that is at the end of the list.
     *        Entrires don't change.
     *        List's size decreased by 1.
     *  @param none
     *  @return the entry that is at the end of the list if any.*/
  void display();
    /** Task: print all the enties in the list head to tail in the list.
     *  @param none
     *  @return none */
  int contains(T anEntry);
    /** Task: search the list, find the match entry and return its posistion number.
     *  @param anEntry the object that we are looking for in the list.
     *  @return the integal posistion number of the matched object.*/
  boolean isEmpty();
    /** Task: check the list is empty or not.
     *  @return true of the list has no entry, false if the has any.*/
  boolean isFull();
    /** Task: check the list is full or not.
     *  @return true of the list is full of entries, false if it still has empty space.*/
}