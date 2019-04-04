package QueuePackage;


import java.util.*;

/**
 * A class that will implement the event queue.  
 * 
 * 
 * @author Charles Hoot 
 * @version 4.0
 */

    
public class SimulationEventQueue implements SimulationEventQueueInterface
{
    private Vector<SimulationEvent> queue;// queue front is first in the vector
    private double theCurrentTime;

    /**
     * Constructor for objects of class BankLine
     */
    public SimulationEventQueue()
    {
        queue = new Vector<SimulationEvent>();
        theCurrentTime = 0.0;
    } // end constructor
    
    public void add(SimulationEvent newEvent)
    {
        if(newEvent.getTime() < theCurrentTime)
        {
            //System.out.println("Fails to add event... before the current time");
        }
        else if(queue.isEmpty())
        {
            // Just add it in
            queue.add(newEvent);
            //System.out.println("   added to empty queue");
        }
        else
        {
            // Iterate over the queue to find the position to add the item.
            System.out.println("Adding an event " + newEvent + " at time " + newEvent.getTime());
            int pos = -1;
            boolean foundLarger = false;
            Iterator<SimulationEvent> iter = queue.iterator();
            while(iter.hasNext() && !foundLarger)
            {
                pos++;
                SimulationEvent check = iter.next();
                //System.out.println("  checked against time " + check.getTime() );
                
                // Events at the same time should go in the order that they were
                // created, so we want to find the position of the first event with
                // a time greater than our time.
                foundLarger = check.getTime() > newEvent.getTime();
            }
            
            System.out.println("   pos is " + (pos));
            System.out.println("   foundLarger is " + (foundLarger));
            
            if(!foundLarger)
            {
                queue.add(newEvent);        // add to end
                System.out.println("   added to end ");
            }
            else 
            {
                queue.add(pos,newEvent);        // legal to add
                System.out.println("   added to position " + (pos));
            }
         }       
    } // end add

    public SimulationEvent peek()
    {
        SimulationEvent front = null;
        if (isEmpty())
            throw new EmptyQueueException("Attempting to access entries on an empty queue.");
        else
            front = queue.get(0);
        return front;
    } // end get
    

    public SimulationEvent remove() {
        SimulationEvent front = null;
        if (isEmpty()) {
            throw new EmptyQueueException("Attempting to access entries on an empty queue.");
        } else {
            front = queue.get(0);
            queue.remove(0);
            theCurrentTime = front.getTime();
            //System.out.println("Removed the first event " + front + " time is now " + theCurrentTime);
        } // end if
        return front;
    } // end remove

    public boolean isEmpty()
    {
        return queue.isEmpty();
    } // end isEmpty
    
    public void clear()
    {
        queue.clear();
    } // end clear

	/** Gets the size of the event queue.
        * @return The number of entries currently in the event queue.
        */
	public int getSize()
	{
	   return queue.size();
	}
	
	/**
	 * Get the current time of the simulation
	 * 
	 * @return The time for the first event on the queue.
	 */
	public double getCurrentTime()
	{
	   return theCurrentTime;
	}

}
