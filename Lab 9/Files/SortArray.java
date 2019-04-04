
/********************************************************************
 * Class for sorting an array of Comparable objects from smallest to
 * largest.
 *
 * This code is from Chapter 8 of
 * Data Structures and Abstractions with Java 4/e
 *      by Carrano
 *
 ********************************************************************/
public class SortArray {

    /**************************************************************
     * ITERATIVE SELECTION SORT
     **************************************************************/
    
    /** Sorts the first n objects in an array into ascending order.
     * @param a An array of Comparable objects.
     * @param n An integer > 0.
     */
    public static <T extends Comparable<? super T>> 
    void selectionSort(T[] a, int n) {
        for (int index = 0; index < n - 1; index++) {
            int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
            swap(a, index, indexOfNextSmallest);
            // Assertion: a[0] <= a[1] <= . . . <= a[index] <= all other a[unsorted]
        } // end for
    } // end selectionSort

    /** Finds the index of the smallest value in an array a.
     * @param a An array of Comparable objects.
     * @param first An integer >= 0 and < a.length that is the index of the first
     * array entry to consider.
     * @param last An integer >= 0 and < a.length that is the index of the last
     * array entry to consider.
     * @return The index of the smallest value among
     * a[first], a[first+1], . . . , a[last].
     */
    public static <T extends Comparable<? super T>> 
    int getIndexOfSmallest(T[] a, int first, int last) {
        T min = a[first];
        int indexOfMin = first;
        for (int index = first + 1; index <= last; index++) {
            if (a[index].compareTo(min) < 0) {
                min = a[index];
                indexOfMin = index;
            } // end if
            // Assertion: min is the smallest of a[first] through a[index].
        } // end for
        return indexOfMin;
    } // end getIndexOfSmallest

    /** Swaps the array entries a[i] and a[j].
     * @param a An array of  objects.
     * @param i An integer >= 0 and < a.length.
     * @param j An integer >= 0 and < a.length. 
     * 
     * Modified from Carrano to use generics.
     */
    private static <T> 
    void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    } // end swap


    /**************************************************************
     * RECURSIVE INSERTION SORT WITH A RECURSIVE INSERT
     **************************************************************/


    /** Sorts the first n objects in an array into ascending order.
     * @param a An array of Comparable objects.
     * @param n An integer > 0.
     */
    public static <T extends Comparable<? super T>>
    void insertionSort(T[] a, int n)
    {   
        insertionSort(a, 0, n-1);
    } // end insertionSort
    


    /** Recursively sorts the  objects in a range of locations in an array into ascending order.
     * @param a An array of Comparable objects.
     * @param first An integer > 0 and < a.length.
     * @param last An integer > first and < a.length.
     */    
    private static <T extends Comparable<? super T>>
    void insertionSort(T[] a, int first, int last)
    {
        if (first < last)
        {
            // Sort all but the last entry
            insertionSort(a, first, last-1);
            // Insert the last entry in sorted order
            insertInOrder(a[last], a, first, last-1);
        } // end if
    } // end insertionSort
    
    

    /** Recursively insert a value into its correct location
     * @param entry The item to insert.
     * @param a An array of Comparable objects.
     * @param begin An integer >= 0 that is the index of the first
     * array entry to consider.
     * @param end An integer >= 0 that is the index of the last
     * array entry to consider.
     */
    public static <T extends Comparable<? super T>>
    void insertInOrder(T anEntry, T[] a, int begin, int end)
    {
    // Inserts entry into the sorted array entrys a[first] through a[last].
    if (anEntry.compareTo(a[end]) >= 0)
        a[end+1] = anEntry;
            else if (begin < end)
            {
                a[end+1] = a[end];
                insertInOrder(anEntry, a, begin, end-1);
            }
            else // begin == end and enEntry < a[end]
            {
                a[end+1] = a[end];
                a[end] = anEntry;
            }
    }  // end insertInOrder
    

    
    
    /**************************************************************
     * ITERATIVE INSERTION SORT (PROVIDED FOR REFERNCE)
     **************************************************************/
    /** Sorts the first n objects in an array into ascending order.
     * @param a An array of Comparable objects.
     * @param n An integer > 0.
     */
    
    /* Provided for reference.  Modify the recursive insertion sort
     * for the lab.
     * 
    public static <T extends Comparable<? super T>> 
    void insertionSort(T[] a, int n) {
        insertionSort(a, 0, n - 1);
    } // end insertionSort

     */
    
    /** Iterative insertion sort of the  objects in a range of locations in an array into ascending order.
     * @param a An array of Comparable objects.
     * @param first An integer >= 0 and < a.length.
     * @param last An integer > first and < a.length.
     */
    
    /* Provided for reference.  Modify the recursive insertion sort
     * for the lab.
     * 
    public static <T extends Comparable<? super T>> 
    void insertionSort(T[] a, int first, int last) {
        T nextToInsert;
        boolean foundLocation;
        int loc;

        for (int unsorted = first + 1; unsorted <= last; unsorted++) {
            nextToInsert = a[unsorted];
            insertInOrder(nextToInsert, a, first, unsorted - 1);
        } // end for
    } // end insertionSort
    */
    
    /** Inserts anEntry into the sorted entries a[begin] through a[end].
     * @param anEntry The entry to be inserted into the sorted portion of the array.
     * @param a An array of Comparable objects.
     * @param begin An integer >= 0 and < a.length.
     * @param end An integer > first and < a.length.
     */
    
    /* Provided for reference.  Modify the recursive insertion sort
     * for the lab.
     * 
    public static <T extends Comparable<? super T>> 
    void insertInOrder(T anEntry, T[] a, int begin, int end) {
        int index = end; // index of last entry in the sorted portion

        // Make room, if needed, in sorted portion for another entry
        while ((index >= begin) && (anEntry.compareTo(a[index])) < 1) {
            a[index + 1] = a[index]; // make room
            index--;
        } // end while

        // Assertion: a[index + 1] is available.
        a[index + 1] = anEntry; // insert

    } // end insertionSort
    */
    
    /**************************************************************
     * ITERATIVE SHELL SORT
     **************************************************************/
    /** Sorts the first n objects in an array into ascending order.
     * @param a An array of Comparable objects.
     * @param n An integer > 0.
     */
    public static <T extends Comparable<? super T>> 
    void shellSort(T[] a, int n) {
        shellSort(a, 0, n - 1);
    } // end shellSort

    /** Use incremental insertion sort with different increments to 
     * sort a range of values in the array.
     * @param a An array of Comparable objects.
     * @param first An integer >= 0.
     * @param last An integer > first and < a.length.
     */
    public static <T extends Comparable<? super T>> 
    void shellSort(T[] a, int first, int last) {
        int n = last - first + 1; // number of array entries
        int space = n/2;
        while (space > 0) {
            for (int begin = first; begin < first + space; begin++) {
                incrementalInsertionSort(a, begin, last, space);
            }
            space = space/2;
        } // end while
    } // end shellSort

    /** Sorts equally spaced entries of an array into ascending order.
    @param a An array of Comparable objects.
    @param first The integer index of the first array entry to
            consider; first >= 0 and < a.length.
    @param last The integer index of the last array entry to
            consider; last >= first and < a.length.
    @param space the difference between the indices of the
            entries to sort.
            */
    public static <T extends Comparable<? super T>> 
    void incrementalInsertionSort(T[] a, int first, int last, int space) {
        int unsorted, index;
        for (unsorted = first + space; unsorted <= last;
                unsorted = unsorted + space) 
        {
            T nextToInsert = a[unsorted];
            index = unsorted - space;
            while ((index >= first) && (nextToInsert.compareTo(a[index]) < 0)){
                a[index + space] = a[index];
                index = index - space;
            } // end while
            a[index + space] = nextToInsert;
        } // end for
    } // end incrementalInsertionSort
}// end SortArray
