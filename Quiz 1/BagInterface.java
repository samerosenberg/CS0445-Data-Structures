/**
An interface that describes the operations of a bag of objects.
@author Frank M. Carrano
 * This code is from Chapter 1 of
 * Data Structures and Abstractions with Java 4/e
 *      by Carrano 
 */
public interface BagInterface<T> {

    /** Gets the current number of entries in this bag.
    @return The integer number of entries currently in the bag. */
    public int getCurrentSize();


    /** Sees whether this bag is empty.
    @return True if the bag is empty, or false if not. */
    public boolean isEmpty();

    /** Adds a new entry to this bag.
    @param newEntry The object to be added as a new entry.
    @return True if the addition is successful, or false if not. */
    public boolean add(T newEntry);

    /** Removes one unspecified entry from this bag, if possible.
    @return Either the removed entry, if the removal
    was successful, or null. */
    public T remove();

    /** Removes one occurrence of a given entry from this bag,
    if possible.
    @param anEntry The entry to be removed.
    @return True if the removal was successful, or false if not */
    public boolean remove(T anEntry);

    /** Removes all entries from this bag. */
    public void clear();

    /** Counts the number of times a given entry appears in this bag.
    @param anEntry The entry to be counted.
    @return The number of times anEntry appears in the bag. */
    public int getFrequencyOf(T anEntry);

    /** Tests whether this bag contains a given entry.
    @param anEntry The entry to locate.
    @return True if the bag contains anEntry, or false if not. */
    public boolean contains(T anEntry);

    /** Retrieves all entries that are in this bag.
    @return A newly allocated array of all the entries in the bag.
            Note: If the bag is empty, the returned array is empty. */
    public T[] toArray();
    
    /**
     * Splits and adds the contents of the bag into two 
     * bags that are passed in as arguments. If there 
     * are an odd number of items, put the extra item 
     * into the first bag. The bag on which the method
     * is applied doesn't change.
     * @param first
     * @param second
     * @return a boolean value. If either bag 
               overflows, return false. Otherwise, 
               return true. 
     */
    boolean splitInto(BagInterface<T> first, BagInterface<T> second);
    /**
     * add all of the items from the argument into the bag.
     * @param toAdd
     * @return a boolean value indicating an overflow. 
     * If adding the items would cause the bag to overflow, 
     * do nothing and return false. Otherwise, add the items 
     * and return true.
     */
    boolean addAll(BagInterface<T> toAdd);

} // end BagInterface
