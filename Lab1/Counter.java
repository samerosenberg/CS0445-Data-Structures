
/**
 * The counter class implements a counter that will roll over to the initial
 * value when it hits the maximum value.
 *
 * @author Charles Hoot
 * @version 4.0
 */
public class Counter
{
    // PUT PRIVATE DATA FIELDS HERE
    private int min;
    private int max;
    private int count;
    private boolean rolledOver = false;
    /**
     * The default constructor for objects of class Counter.  Minimum is 0 and the maximum
     * is the largest possible integer.
     */
    public Counter()
    {
        count =0;
        min = 0;
        max = Integer.MAX_VALUE;
    }


    /**
     * The alternate constructor for objects of class Counter.  The minimum and maximum values are given as parameters.
     * The counter starts at the minimum value.
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     * */
    public Counter(int min1, int max1)
    {
        min = min1;
        max = max1;
        count =min;
        if(min>=max)
          throw new CounterInitializationException("Min greater than max");
    }

    /**
     * Determine if two counters are in the same state
     *
     * @param  otherObject   the object to test against for equality
     * @return     true if the objects are in the same state
     */
    public boolean equals(Object otherObject)
    {
        boolean result = false;
        if (otherObject instanceof Counter)
        {
            Counter c = (Counter) otherObject;

            if(c.count==count && c.min == min && c.max == max && c.rolledOver == rolledOver)
                result = true;

        }
        return result;
    }



    /**
     * Increases the counter by one
     */
    public void increase()
    {
        rolledOver = false;
        if(count<max){
            count++;
        }
        else {
            count = min;
            rolledOver = true;
        }
    }


     /**
     * Decreases the counter by one
     */
    public void decrease()
    {
        rolledOver = false;
        if(count > min) count--;
        else{
            count = max;
            rolledOver = true;
        }
    }

    /**
     * Get the value of the counter
     *
     * @return     the current value of the counter
     */
    public int value()
    {
        // CHANGE THE RETURN TO GIVE THE CURRENT VALUE OF THE COUNTER
        return count;

    }


    /**
     * Accessor that allows the client to determine if the counter
     *             rolled over on the last count
     *
     * @return     true if the counter rolled over
     */
    public boolean rolledOver()
    {

        return rolledOver;
    }

    /**
     * Override the toString method to provide a more informative
     * description of the counter
     *
     * @return     a descriptive string about the object
     */
    public String toString()
    {
        return count + "";
    }

}
