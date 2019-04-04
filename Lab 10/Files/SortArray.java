import java.util.*;

/********************************************************************
 * Class for sorting an array of Comparable objects from smallest to
 * largest.
 *
 * This code is based on code from Chapters 8 and 9 of
 * Data Structures and Abstractions with Java 4/e
 *      by Carrano
 *
 *
  * @version 4.0
 *
 ********************************************************************/


public class SortArray
{

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
     * ITERATIVE INSERTION SORT
     **************************************************************/
    /** Sorts the first n objects in an array into ascending order.
     * @param a An array of Comparable objects.
     * @param n An integer > 0.
     */

    public static <T extends Comparable<? super T>>
    void insertionSort(T[] a, int n) {
        insertionSort(a, 0, n - 1);
    } // end insertionSort



    /** Iterative insertion sort of the  objects in a range of locations in an array into ascending order.
     * @param a An array of Comparable objects.
     * @param first An integer >= 0 and < a.length.
     * @param last An integer > first and < a.length.
     */

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


    /** Inserts anEntry into the sorted entries a[begin] through a[end].
     * @param anEntry The entry to be inserted into the sorted portion of the array.
     * @param a An array of Comparable objects.
     * @param begin An integer >= 0 and < a.length.
     * @param end An integer > first and < a.length.
     */
    public static <T extends Comparable<? super T>>
    void insertInOrder(T anEntry, T[] a, int begin, int end) {
        int index = end; // index of last entry in the sorted portion

        // Make room, if needed, in sorted portion for another entry.
        while ((index >= begin) && (anEntry.compareTo(a[index])) < 1) {
            a[index + 1] = a[index]; // make room
            index--;
        } // end while

        // Assertion: a[index + 1] is available.
        a[index + 1] = anEntry; // insert

    } // end insertionSort



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


    /**************************************************************
     * MERGE SORT
     **************************************************************/


    /** Sorts the first n objects in an array into ascending order.
     * @param a An array of Comparable objects.
     * @param n An integer > 0.
     */
    public static <T extends Comparable<? super T>>
    void mergeSort(T[] a, int n)
    {
        mergeSort(a, 0, n-1);
    } // end mergeSort


    /** Merge sort on a portion of an array.  Creates a temporary array
     *  then calls the recursive function.
     * @param a An array of Comparable objects.
     * @param first An integer >= 0 that is the index of the first
     * array entry to consider.
     * @param last An integer >= 0 that is the index of the last
     * array entry to consider.
     */
    public static <T extends Comparable<? super T>>
    void mergeSort(T[] a, int first, int last)
    {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempArray = (T[]) new Comparable<?>[a.length]; // Unchecked cast
        mergeSort(a, tempArray, first, last);
    } // end mergeSort



    /** Recursively merge sort a portion of an array.
     * @param a An array of Comparable objects.
     * @param tempArray An array used by the merge step.
     * @param first An integer >= 0 that is the index of the first
     * array entry to consider.
     * @param last An integer >= 0 that is the index of the last
     * array entry to consider.
     */
    public static <T extends Comparable<? super T>>
    void mergeSort(T[] a, T[] tempArray, int first, int last)
    {

        if(first < last)        // We have some work to do
        {
            int mid = first + (last-first)/2;
            mergeSort(a, tempArray, first, mid);
            mergeSort(a, tempArray, mid+1, last);
            merge(a, tempArray, first, mid, last);
        }

    } // end mergeSort

    /** Merge the entries in two contiguous sorted sublists
     * @param a An array of Comparable objects.
     * @param tempArray A temporary array used in the merge.
     * @param first An integer >= 0 and < mid.
     * @param mid An integer  <= last.
     * @param last An integer  < a.length.
     */
    public static <T extends Comparable<? super T>>
    void merge(T[] a, T[] tempArray, int first, int mid, int last)
    {
        int beginHalf1 = first;
        int endHalf1 = mid;
        int beginHalf2 = mid + 1;
        int endHalf2 = last;
        // While both subarrays are not empty, compare an entry in one subarray with
        //an entry in the other; then copy the smaller item into the temporary array

        int index = 0; //Next available location in tempArray
        while ( (beginHalf1 <= endHalf1) &&(beginHalf2 <= endHalf2) )
        {
            if (a[beginHalf1].compareTo(a[beginHalf2]) <= 0)

            {
                tempArray[index] = a[beginHalf1];
                beginHalf1++;
            }
            else
            {
                tempArray[index] = a[beginHalf2];
                beginHalf2++;
            }
            index++;
        }
        // end while

        //Assertion: One subarray has been completely copied to tempArray.


        // copy any remaining values from the first subarray over to temp
        while(beginHalf1 <= endHalf1)
            tempArray[index++] = a[beginHalf1++];

        // copy any remaining values from the second subarray over to temp
        while(beginHalf2 <= endHalf2)
            tempArray[index++] = a[beginHalf2++];

        // copy values back
        for(int i=0; i<index; i++)
        {
            a[first+i]  = tempArray[i];
        } //end for
    } // end merge


    /**************************************************************
     * QUICK SORT - NO BELLS AND WHISTLES
     *      RECURSIVE
     *      NO MEDIAN OF THREE
     *      NO INSERTION SORT ON SMALL ARRAYS
     **************************************************************/


    /** Sorts the first n objects in an array into ascending order.
     * @param a An array of Comparable objects.
     * @param n An integer > 0.
     *
     */
    public static <T extends Comparable<? super T>>
    void basicQuickSort(T[] a, int n)
    {
        basicQuickSort(a, 0, n-1);
    } // end basicQuickSort




    /** Recursively sorts an array into ascending order. Does not use median of three.
    * Does not do insertion sort on small sub arrays.
    *
    * @param a An array of Comparable objects.
    * @param first An integer >= 0 that is the index of the first
    * array entry to consider.
    * @param last An integer >= 0 that is the index of the last
    * array entry to consider.
    */
    public static <T extends Comparable<? super T>>
    void basicQuickSort(T[] a, int first, int last)
    {
        if (last - first + 1 > 1)  // Number of to be sorted is greater than 1
        {
            // Create the partition: Smaller | Pivot | Larger
            int pivotIndex = basicPartition(a, first, last);
            // Sort subarrays Smaller and Larger
            basicQuickSort(a, first, pivotIndex-1);
            basicQuickSort(a, pivotIndex+1, last);
        } // end if
    } // end basicQuickSort



    /** Partitions an array as part of quick sort into two subarrays
    * called Smaller and Larger that are separated by a single
    * entry called the pivot.
    * Entries in Smaller are left of the pivot and <= pivot.
    * Entries in Larger are right of the pivot and >= pivot.
    * @param a An array of Comparable objects.
    * @param first The integer index of the first array entry;
    * first >= 0.
    * @param last The integer index of the last array entry;
    * last >= first  last < a.length.
    * @return the index of the pivot */
    public static <T extends Comparable<? super T>>
    int basicPartition(T[] a, int first, int last)
    {
       // Pivot will be the last value in the sub sequence

        int pivotIndex = last;
        T pivot = a[pivotIndex];

        // Determine subarrays Smaller = a[first..endSmaller]
        // and Larger = a[endSmaller+1..last-1]
        // such that entries in Smaller are <= pivot and
        // entries in Larger are >= pivot; initially, these subarrays are empty

        int indexFromLeft = first;
        int indexFromRight = last - 1;
        boolean done = false;
        while (!done)
        {
            // Starting at beginning of array, leave entries that are < pivot;
            // locate first entry that is >= pivot; you will find one,
            // since last entry is >= pivot
            while (a[indexFromLeft].compareTo(pivot) < 0)
                indexFromLeft++;

            // Starting at end of array, leave entries that are > pivot;
            // locate first entry that is <= pivot; you may not find one, so stop
            // at first.
            while (a[indexFromRight].compareTo(pivot) > 0  && indexFromRight > first)
                indexFromRight--;

            // Assertion: a[indexFromLeft] >= pivot
            if (indexFromLeft < indexFromRight)
            {
                swap(a, indexFromLeft, indexFromRight);
                indexFromLeft++;
                indexFromRight--;
            }
            else
                done = true;
        } // end while

        // Place pivot between Smaller and Larger subarrays
        swap(a, pivotIndex, indexFromLeft);
        pivotIndex = indexFromLeft;

        // Assertion:
        // Smaller = a[first..pivotIndex-1]
        // Pivot = a[pivotIndex]
        // Larger = a[pivotIndex + 1..last]
        return pivotIndex;
    } // end basicPartition


    /**************************************************************
     * QUICK SORT - A SECOND VERSION
     *      RECURSIVE
     *      NO MEDIAN OF THREE
     *      DOES INSERTION SORT ON SMALL ARRAYS
     **************************************************************/


    /** Sorts the first n objects in an array into ascending order.
     * @param a An array of Comparable objects.
     * @param n An integer > 0.
     *
     */
    public static <T extends Comparable<? super T>>
    void version2QuickSort(T[] a, int n)
    {
        version2QuickSort(a, 0, n-1);
        insertionSort(a, 0, n-1);
    } // end version2QuickSort


    private static int MIN_SIZE = 10;
    /**
     * Set the minimum size (MIN_SIZE) of a subarray that quick sort will do recursively
     *
     * @param  size   The size to use; must be > 0.  If size is not positive,
     * the MIN_SIZE value will not be changed.
     */
    public static void setQuickSortMinimumSize(int size)
    {
        if(size > 0)
            MIN_SIZE = size;
    }




    /** Recursively sorts an array into ascending order. Does not use median of three.
     * Will do insertion sort on subarrays smaller or equal to MIN_SIZE.
    *
    * @param a An array of Comparable objects.
    * @param first An integer >= 0 that is the index of the first
    * array entry to consider.
    * @param last An integer >= 0 that is the index of the last
    * array entry to consider.
    */
    public static <T extends Comparable<? super T>>
    void version2QuickSort(T[] a, int first, int last)
    {
        if (last - first + 1 >= MIN_SIZE) // Number of to be sorted is at least MIN_SIZE
        {
            // create the partition: Smaller | Pivot | Larger
            int pivotIndex = basicPartition(a, first, last);
            // sort subarrays Smaller and Larger
            version2QuickSort(a, first, pivotIndex-1);
            version2QuickSort(a, pivotIndex+1, last);
        } // end if
    } // end version2QuickSort


    /**************************************************************
     * QUICK SORT - A THIRD VERSION
     *      RECURSIVE
     *      MEDIAN OF THREE
     *      DOES INSERTION SORT ON SMALL ARRAYS
     *
     *      ASIDE FROM WHEN AND HOW MANY TIMES THE INSERTION SORT IS DONE,
     *      THIS IS THE VERSION FROM THE BOOK
     **************************************************************/



    /** Sorts the first n objects in an array into ascending order.
     * @param a An array of Comparable objects.
     * @param n An integer > 0.
     *
     */
    public static <T extends Comparable<? super T>>
    void version3QuickSort(T[] a, int n)
    {
        version3QuickSort(a, 0, n-1);
        insertionSort(a, 0, n-1);
    } // end version3QuickSort



    /** Recursively sorts an array into ascending order. Uses quick sort with
    * median-of-three pivot selection for arrays of at least
    * MIN_SIZE entries, and uses insertion sort for other arrays.

    *  Modified from the book so that there is just a single call to insertion
    *  sort after all the recursion has taken place.  The performance in terms of
    *  comparisons will be the same, but you avoid some method call overhead.
    *
    * @param a An array of Comparable objects
    * @param first An integer >= 0 that is the index of the first
    * array entry to consider
    * @param last An integer >= 0 that is the index of the last
    * array entry to consider
    */
    public static <T extends Comparable<? super T>>
    void version3QuickSort(T[] a, int first, int last)
    {
        if (last - first + 1 >= MIN_SIZE)  // Number of to be sorted is at least MIN_SIZE
        {
            // Create the partition: Smaller | Pivot | Larger
            int pivotIndex = partition(a, first, last);
            // Sort subarrays Smaller and Larger
            version3QuickSort(a, first, pivotIndex-1);
            version3QuickSort(a, pivotIndex+1, last);
        } // end if
    } // end version3QuickSort


    /** Sorts the first, middle, and last entries of an
    * array into ascending order.
    * @param a An array of Comparable objects
    * @param first The integer index of the first array entry; first >= 0 and < a.length
    * @param mid The integer index of the middle array entry
    * @param last The integer index of the last array entry;
    * last - first >= 2, last < a.length */
    public static <T extends Comparable<? super T>>
    void sortFirstMiddleLast(T[] a, int first, int mid, int last)
    {
        order(a, first, mid); // make a[first] <= a[mid]
        order(a, mid, last); // make a[mid] <= a[last]
        order(a, first, mid); // make a[first] <= a[mid]
    } // end sortFirstMiddleLast


    /** Orders two given array entries into ascending order
    * so that a[i] <= a[j].
    * @param a An array of Comparable objects.
    * @param i An integer >= 0 and < array.length.
    * @param j An integer >= 0 and < array.length.
    */
    public static <T extends Comparable<? super T>>
    void order(T[] a, int i, int j)
    {
        if (a[i].compareTo(a[j]) > 0)
            swap(a, i, j);
    } // end order


    /** Partitions an array as part of quick sort into two subarrays
    *       called Smaller and Larger that are separated by a single
    *       entry called the pivot.
    *       Entries in Smaller are <= pivot and appear before the pivot in the array
    *       Entries in Larger are >= pivot and appear after the pivot in the array.
    * @param a An array of Comparable objects.
    * @param first The integer index of the first array entry;
    *       first >= 0 and < a.length.
    * @param last The integer index of the last array entry;
    *       last - first >= 3; last < a.length.
    * @return The index of the pivot */
    public static <T extends Comparable<? super T>>
    int partition(T[] a, int first, int last)
    {
        int mid = first + (last - first)/2;
        sortFirstMiddleLast(a, first, mid, last);

        // Assertion: The pivot is a[mid]; a[first] <= pivot and
        // a[last] >= pivot, so do not compare these two array entries
        // with pivot.

        // Move pivot to next-to-last position in array
        swap(a, mid, last - 1);


        int pivotIndex = last - 1;
        T pivot = a[pivotIndex];

        // determine subarrays Smaller = a[first..endSmaller]
        // and Larger = a[endSmaller+1..last-1]
        // such that entries in Smaller are <= pivot and
        // entries in Larger are >= pivot; initially, these subarrays are empty

        int indexFromLeft = first + 1;
        int indexFromRight = last - 2;

        // The following statement has been modified from the book code so that
        // the partition will not fail when applied to a small range (1, 2)
        // We will rely on sortMiddleFirstLast operation to correctly handle these
        // size ranges, but must prevent the while loop from executing.  If we do
        // not do this the indexFromLeft and indexFromRight above can be set to
        // an invalid array index.  If MIN_SIZE is set to be large enough this will
        // not be an issue.
        boolean done = last - first < 3;  // Had 3 or fewer entries in the range
        while (!done)
        {
            // Starting at beginning of array, leave entries that are < pivot;
            // locate first entry that is >= pivot; you will find one,
            // since last entry is >= pivot
            while (a[indexFromLeft].compareTo(pivot) < 0)
                indexFromLeft++;

            // Starting at end of array, leave entries that are > pivot;
            // locate first entry that is <= pivot; you will find one,
            // since first entry is <= pivot
            while (a[indexFromRight].compareTo(pivot) > 0)
                indexFromRight--;

            assert a[indexFromLeft].compareTo(pivot) >= 0
                    && a[indexFromRight].compareTo(pivot) <= 0;

            if (indexFromLeft < indexFromRight)
            {
                swap(a, indexFromLeft, indexFromRight);
                indexFromLeft++;
                indexFromRight--;
            }
            else
                done = true;
        } // end while

        // Place pivot between Smaller and Larger subarrays
        swap(a, pivotIndex, indexFromLeft);
        pivotIndex = indexFromLeft;

        // Assertion:
        // Smaller = a[first..pivotIndex-1]
        // Pivot = a[pivotIndex]
        // Larger = a[pivotIndex + 1..last]

        return pivotIndex;
    } // end partition

    // ADD CODE FOR YOUR BITONIC MERGE SORT METHODS HERE


    /**************************************************************
     * KTH ORDER STATISTIC - BASIC ALGORITHM THAT SORTS FIRST
     *        ARRAY MAY BE SORTED OR UNSORTED
     **************************************************************/

    /** Find the kth item of the first n items in sorted order
     * @param a An array of Comparable objects.
     * @param n An integer > 0 and less than or equal to a.length.
     * @param k An integer > 0 and less than or equal to n.
     */
    public static <T extends Comparable<? super T>>
    T basicKthItem(T[] a, int k, int n)
    {
        basicQuickSort(a, 0, n-1);
        return( a[k-1] );
    } // end kthItem


    /**************************************************************
     * KTH ORDER STATISTIC - ALGORITHM THAT USES PARTITION
     *        ARRAY MAY BE SORTED OR UNSORTED
     **************************************************************/


    /** Find the kth item of the first n items in sorted order.
     * @param a An array of Comparable objects.
     * @param n An integer >= 0 and less than or equal to a.length.
     * @param k An integer >= 0 and less than or equal to n.
     */
    public static <T extends Comparable<? super T>>
    T kthItem(T[] a, int k, int n)
    {
        return kthItem(a, k-1, 0, n-1);
    } // end kthItem


    /** Recursively find the kth item in a sorted sublist of items
     * @param a An array of Comparable objects.
     * @param k An integer >= 0 that is the position to return.
     * @param first An integer >= 0 that is the index of the first
     * array entry to consider.
     * @param last An integer >= 0 that is the index of the last
     * array entry to consider.
     */
    private static <T extends Comparable<? super T>>
    T kthItem(T[] a, int k, int first, int last)
    {
        T result = a[first];
        //System.out.println("call: " + k + " " + first + " " + last + " ");
        int pivot=0;
        if(last==first){
            pivot =basicPartition(a,first,last);
            System.out.print(pivot+" "+ k +",  ");
        }
        if(last>first){
            pivot = basicPartition(a,first,last);
            System.out.print(pivot+" "+ k +",  ");
        }
        if(k<pivot){
             kthItem(a,k,first,pivot-1);
        }
        else if(k>pivot){
             kthItem(a,k,pivot+1,last);
        }
        else if(k==pivot){
            result = a[pivot];
        }
        return result;
        //COMPLETE THIS RECURSIVE METHOD



    } // end kthItem



}// end SortArray
