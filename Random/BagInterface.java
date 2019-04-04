public interface BagInterface<T>{

  /**Adds an entry to the BagInterface
  *@param newEntry The entry to be added
  *@return True is te addition is successful and false otherwise
  */
  public boolean addEntry(T newEntry);
  /**Removes an arbitrary entry from the bad if possible
  *@return The removed entry, or null if the bag is empty
  */
  public T remove();
  /**Removes a particular entry from the bag
  *@param anEntry The entry to be removed
  @return True if anEntry has been removed, false otherwise
  public boolean remove(T anEntry);

/**
*Postcondition: Th bag is empty. This is a shallow clear
*/
  public void clear();

  public boolean isEmpty();

  public int getSize();

}
