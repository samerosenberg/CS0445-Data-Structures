/** CS 0445 Spring 2018 (Adapted  from Dr. John Ramirez's assignment 2 code)
 Assignment 2 Reorder interface
 Carefully read the specifications for the methods below and
 implement them in your LinkedDS<T> class.  You have to use the 
 most efficient way to implement these methods.
*/

public interface Reorder
{
	// Logically reverse the data in the Reorder object so that the item
	// that was logically first will now be logically last and vice
	// versa.  The physical implementation of this can be done in 
	// many different ways, depending upon how you actually implemented
	// your physical LinkedDS<T> class
	public void reverse();

	// Remove the logical last item of the DS and put it at the 
	// front.  As with reverse(), this can be done physically in
	// different ways depending on the underlying implementation.  
	public void shiftRight();

	// Remove the logical first item of the DS and put it at the
	// end.  As above, this can be done in different ways.
	public void shiftLeft();
	
	// Shift the contents of the DS num places to the left (assume the beginning 
	// is the leftmost node), removing the leftmost num nodes.  For example, if 
	// a list has 8 nodes in it (numbered from 1 to 8), a leftShift of 3 would 
	// shift out nodes 1, 2 and 3 and the old node 4 would now be node 1.  
	// If num <= 0 leftShift should do nothing and if num >= the length of the 
	// list, the result should be an empty list.
	public void leftShift(int num);
	
	// Same idea as leftShift above, but in the opposite direction.  For example, 
	// if a list has 8 nodes in it (numbered from 1 to 8) a rightShift of 3 would 
	// shift out nodes 8, 7 and 6 and the old node 5 would now be the last node
	// in the list.  If num <= 0 rightShift should do nothing and if num >= the 
	// length of the list, the result should be an empty list.
	public void rightShift(int num);
	
	// In this method you will still shift the contents of the list num places to 
	// the left, but rather than removing nodes from the list you will simply change 
	// their ordering in a cyclic way.  For example, if a list has 8 nodes in it 
	// numbered from 1 to 8), a leftRotate of 3 would shift nodes 1, 2 and 3 to the
	// end of the list, so that the old node 4 would now be node 1, and the old nodes 
	// 1, 2 and 3 would now be nodes 6, 7 and 8 (in that order).  The rotation should 
	// work modulo the length of the list, so, for example, if the list is length 8 then
	// a leftRotate of 10 should be equivalent to a leftRotate of 2.  If num < 0, the 
	// rotation should still be done but it will in fact be a right rotation rather than
	// a left rotation.
	public void leftRotate(int num);

	// Same idea as leftRotate above, but in the opposite direction.  For example, if a list 
	// has 8 nodes in it (numbered from 1 to 8), a rightRotate of 3 would shift nodes 8, 7 and 
	// 6 to the beginning of the list, so that the old node 8 would now be node 3, the old node 
	// 7 would now be node 2 and the old node 6 would now be node 1.  The behavior for num > the 
	// length of the list and for num < 0 should be analogous to that described above for leftRotate.
	public void rightRotate(int num);
}