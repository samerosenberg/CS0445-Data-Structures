import java.util.*;
import java.io.*;
class MultiDS<T> implements PrimQ<T>, Reorder {
  private final T[] array;
  private int numberOfEntries;
  private Random rand = new Random();

  /**
    default constructor for MultiDS class
  */
  public MultiDS(){
    this(52);
  }

  /**
    MultiDS constructor
    @param capacity of array
  */
  public MultiDS(int capacity){
			@SuppressWarnings("unchecked")
			T[] temp = (T[]) new Object[capacity];//Object is the upper bound of the type parameter T
			array = temp;
			numberOfEntries = 0;

  }
  /**
    Adds new item
    @param item item to be added
    @return true if addition is successful, false if not
  */
	public boolean addItem(T item){
    if(numberOfEntries >= array.length){
      return false;
    }
    else{
      array[numberOfEntries] = item;
      numberOfEntries++;
      return true;
    }

  }

	/**
    Remove item from array
    @return Returns item to be removed
  */
	public T removeItem(){
    T result = array[0];
    for(int i=1; i<numberOfEntries;i++){
      array[i-1] = array[i];
    }
    if(numberOfEntries < array.length)
      array[numberOfEntries] = null;
    if(numberOfEntries==1){
      array[0]=null;
    }
    numberOfEntries--;
    return result;
  }

	/**
    Returns first element in array
    @return First element in array
  */
	public T top(){
    if(numberOfEntries>0)
      return array[0];
    else
      return null;
  }

	/**
    Checks if array is full
    @return true if array is full, false otherwise
  */
	public boolean full(){
    return numberOfEntries == array.length;
  }

	/**
    Checks if array is empty
    @return true if array is empty, false otherwise
  */
	public boolean empty(){
    return numberOfEntries == 0;
  }

	/**
    Return size of array
    @return size of array
  */
	public int size(){
    return numberOfEntries;
  }

	/**
    Clears array
  */
	public void clear(){
    while(numberOfEntries>0){
      removeItem();
    }
  }

  /**
    Reverses order or elements in current array
  */
	public void reverse(){
    for(int i=0; i<numberOfEntries/2; i++){
      T temp = array[i];
      array[i] = array[numberOfEntries -i -1];
      array[numberOfEntries -i -1] = temp;
    }


  }

	/**
    Shifts all elements in array to the right
  */
	public void shiftRight(){
    T temp = array[numberOfEntries-1];
    for(int i =numberOfEntries;i>0;i--){
      array[i]= array[i-1];
    }
    array[0]=temp;
    if(numberOfEntries < array.length)
      array[numberOfEntries] = null;
  }

	/**
    Shifts all elements in the array to the left
  */
	public void shiftLeft(){
    T temp = array[0];
    for(int i =1;i<numberOfEntries;i++){
      array[i-1]= array[i];
    }
    array[numberOfEntries-1] = temp;
  }

  /**
    Shuffles elements in array
  */
	public void shuffle(){
    for(int i=0;i<numberOfEntries;i++){
      int random = rand.nextInt(numberOfEntries);
      T temp = array[i];
      array[i] = array[random];
      array[random] = temp;
    }
  }

	/**
    Returns elements in the array as a String
    @return elements in array as string
  */
  public String toString(){
    String str = "";
    for(int i =0; i<numberOfEntries;i++){
      str+=array[i]+" ";
    }
    return str;
  }

}
