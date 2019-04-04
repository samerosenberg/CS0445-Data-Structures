public boolean add(T newEntry) {
		boolean result = aBag.add(newEntry);
		if(!result) {
			doubleCapacity();
			result = aBag.add(newEntry);
		}
		return result;
	}

  private final T[] bag;
	private int numberOfEntries;
	private static final int MAX_CAPACITY = 10000;
	private boolean maxcap = false;;

  public boolean add(T newEntry){
    checkInitialization();

    if(numberOfEntries >= bag.length() && bag.length()*2<=MAX_CAPACITY){ //check if bag is full
      bag = Arrays.copyOf(bag,bag.length()*2); //change size to twice original length
		}else if(bag.length()*2>MAX_CAPACITY && !maxcap){
			bag = Arrays.copyOf(bag,MAX_CAPACITY);//set bag size to max capacity
			maxcap = true;
		}else if(maxcap && numberOfEntries+1 > bag.length()){//check if at max capacity and trying to add another item
			return false;
		}
		bag[numberOfEntries] = newEntry; //add new entry
		numberOfEntries++; // increment num of entries by 1
    return true;
  }


class Bag {
	public static void main(String[] args) {
		
	}
}
