/** CS 0445 Spring 2018 (Adapted  from Dr. John Ramirez's assignment 2 code)
 Assignment 2 PrimQ<T> interface
 Carefully read the specifications for each of the operations and
 implement them correctly in your LinkedDS class.

 The overall logic of the PrimQ<T> is the following:
 
 Data are logically "added" in the same order that they are "removed".
 However, there is no requirement for the physical storage of the actual
 data except that your LinkedDS<T> class has a linked chain of nodes
 as its primary data structure.  You MAY NOT use ArrayList, Vector or any 
 predefined collection class for your LinkedDS<T> data.  
 */

public interface PrimQ<T>
{
	// Add a new Object to end of the PrimQ<T>.  If
	// all goes well, return true.  
	public boolean addItem(T newEntry);
	
	// Remove and return the "oldest" item in the PrimQ.  If the PrimQ
	// is empty, return null.
	public T removeItem();
		
	// Return true if the PrimQ is empty, and false otherwise
	public boolean empty();
	
	// Return the number of items currently in the PrimQ
	public int size();

	// Reset the PrimQ to empty status by reinitializing the variables
	// appropriately
	public void clear();
}
