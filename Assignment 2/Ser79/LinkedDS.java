public class LinkedDS<T> implements PrimQ<T>, Reorder{
  protected Node firstNode;
  protected int numOfEntries;
  /**
  *  default constructor for LinkedDS class
  */
  public LinkedDS(){
    firstNode = null;
    numOfEntries = 0;
  }
  /**
  *  LinkedDS constructor
  *  @param oldList list to make a copy of
  */
  public LinkedDS(LinkedDS<T> oldList){
    firstNode = oldList.getNodeAt(1);
    Node currentNode = firstNode;
    while(currentNode!=null){
      addItem(currentNode.data);
      currentNode = currentNode.getNextNode();
    }
  }
  /**
  *  Prints linked list as String
  *  @return linked list as string
  */
  public String toString(){
    Node currentNode = firstNode;
    String str = "";
    while(currentNode != null){
      str += currentNode.getData()+" ";
      currentNode = currentNode.getNextNode();
    }
    return str;
  }
  /**
  *  Adds item to the end of the linked list
  *  @param newEntry entry to be added
  *  @return true if item can be added
  */
  public boolean addItem(T newEntry){
    Node newNode = new Node(newEntry);
		if (empty())
			firstNode = newNode;
		else
		{
			Node lastNode = getNodeAt(numOfEntries);
			lastNode.setNextNode(newNode);
		}
		numOfEntries++;
    return true;
  }
  /**
   * Remove first item from list
   * @return item to be removed
   */
	public T removeItem(){
    if(numOfEntries==0)
      return null;
    T temp = firstNode.getData();
    firstNode = firstNode.getNextNode();
    numOfEntries--;
    return temp;
  }
  /**
   * Check if linked list is empty
   * @return true if ll is empty, false otherwise
   */
	public boolean empty(){
    boolean result;
      if (numOfEntries == 0)
      {
         assert firstNode == null;
         result = true;
      }
      else
      {
         assert firstNode != null;
         result = false;
      }

      return result;
  }
  /**
   * Get size of linked list
   * @return size of linked list
   */
	public int size(){
    return numOfEntries;
  }
  /**
   * Clear contents of linked list
   */
	public void clear(){
    firstNode = null;
    numOfEntries=0;
  }
  /**
   * Shift list left by removing first item
   */
  public void shiftLeft(){
    removeItem();
  }
  /**
   * shift list right by removing last node
   */
  public void shiftRight(){
    Node currentNode = getNodeAt(numOfEntries-1);
    currentNode.setNextNode(null);
    numOfEntries--;
  }
  /**
   * Shift left num times
   * @param int num call shiftLeft num times
   */
  public void leftShift(int num){
    if(num <=0)
      return;
    if(num>= numOfEntries)
      firstNode = null;
    for(int i=0;i<num;i++){
      shiftLeft();
    }
  }
  /**
   * Shift the list right num times
   * @param int num call rightShift num times
   */
  public void rightShift(int num){
    if(num <=0)
      return;
    if(num>= numOfEntries)
      firstNode = null;
    for(int i=0;i<num;i++){
      shiftRight();
    }
  }
  /**
   * Rotate list left by taking number from front and adding to end
   * @param int num rotate left num times
   */
  public void leftRotate(int num){
    if(num <0)
      rightRotate(Math.abs(num));
    for(int i=0;i<num%numOfEntries;i++){
      Node currentNode = firstNode;
      getNodeAt(numOfEntries).setNextNode(currentNode);
      firstNode = firstNode.getNextNode();
      getNodeAt(numOfEntries).setNextNode(null);
    }
  }
  /**
   * Rotate list right by bringing the last number to the front
   * @param int num rotate right num times
   */
  public void rightRotate(int num){
    if(num <0)
      leftRotate(Math.abs(num));
    for(int i=0;i<num%numOfEntries;i++){
      getNodeAt(numOfEntries).setNextNode(firstNode);
      firstNode = getNodeAt(numOfEntries);
      getNodeAt(numOfEntries).setNextNode(null);
    }
  }
  /**
   * Reverse list
   */
  public void reverse(){
    Node currentNode = firstNode;
    Node previous = null;
    Node next = null;

    while(currentNode !=null){
      next = currentNode;
      currentNode = currentNode.getNextNode();
      next.setNextNode(previous);
      previous = next;
      firstNode = next;
    }
  }
  /**
   * Subclass Node to handle nodes in linked list
   */
  public class Node
	{
      private T data;
      private Node next;
      /**
       * Node constructor
       * @param T dataPortion hold data portion of node
       */
      public Node(T dataPortion)
      {
         data = dataPortion;
         next = null;
      }
      /**
       * Node constructor with nextNode
       * @param T    dataPortion holds value of node
       * @param Node nextNode    holds nextNode value for current node
       */
      public Node(T dataPortion, Node nextNode)
      {
         data = dataPortion;
         next = nextNode;
      }
      /**
       * Get data of current node
       * @return data of node
       */
      public T getData()
      {
         return data;
      }
      /**
       * Set data of current node
       * @param T newData change data to newData
       */
      public void setData(T newData)
      {
         data = newData;
      }
      /**
       * Get reference of next node relative to current node
       * @return next node
       */
      public Node getNextNode()
      {
         return next;
      }
      /**
       * Change next node reference of current noce
       * @param Node nextNode change current next to next node
       */
      public void setNextNode(Node nextNode)
      {
         next = nextNode;
      }
	}
  /**
   * Get reference of node at given position
   * @param  int givenPosition position of desired node
   * @return     node at givenPosition
   */
  private Node getNodeAt(int givenPosition)
	{
		assert !empty() && (1 <= givenPosition) && (givenPosition <= numOfEntries);
		Node currentNode = firstNode;
		for (int counter = 1; counter < givenPosition; counter++)
			currentNode = currentNode.getNextNode();

		assert currentNode != null;

		return currentNode;

  }
}
