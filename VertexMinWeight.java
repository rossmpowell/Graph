package programmingAssignment4;

/**
 * Class that contains the vertex index and priority. The lowest value for priority is
 * considered to be the most important.
 * @author rosspowell
 *
 */
public class VertexMinWeight implements Comparable<VertexMinWeight> {
	
	/** variable to contain the vertex number*/
	private int nameNum;
	
	/** priority of this vertice number*/
    private int priority;

    /**
    *
    * Constructor.
    *
    * @param nN The name number
    * @param p The priority.
    */
    public VertexMinWeight(int nN, int p) {
        nameNum = nN;
        priority = p;
    }

    /**
    *
    * Accessor for nameNum.
    *
    * @return The name.
    */
    public int getNameNumber() {
        return nameNum;
    }

    /**
    *
    * Accessor for priority.
    *
    * @return The priority.
    */
    public int getPriority() {
        return priority;
    }

    /**
    *
    * Implement compareTo so that when this class is used in a priority queue,
    * the lowest value of priority will be the first removed from the queue.
    */
    public int compareTo(VertexMinWeight other) {
    	//If the priority of this object is the same as others
    	if(getPriority() == other.getPriority()) {
    		return 0;
    	//If the priority of this object is less than others
    	} else if (getPriority() < other.getPriority()) {
    		return -1;
    	//If the priority of this object is greater than others
    	} else {
    		return 1;
    	}

    }
    
    /**
     * Method returns a String representation of the VertexMinWeight object
     */
    public String toString() {
    	return getNameNumber() + " " + getPriority();
    }


}
