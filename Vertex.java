package programmingAssignment4;
/**
* Represents a vertex in a graph.
*
* @author rosspowell
*/
public class Vertex{
    /** The name associated with this vertex */
    private String name;

    /** Flag used for algorithms that traverse the graph */
    private FlagValue flag;

    public Vertex() {
    	name = null;
    }
    /**
    * Constructor initializes the name of the vertex.
    *
    * @param n The name associated with this vertex.
    */
    public Vertex(String n) {
        name = n;
    }
    
    /**
    * Accessor method for the name of this vertex.
    *
    * @return The name associated with this vertex.
    */
    public String getName() {
        return name;
    }

    /**
    * Mutator method for the name of this vertex.
    *
    * @param n The name associated with this vertex.
    */
    public void setName(String n) {
        name = n;
    }

    /**
    * Set flag to the waiting state.
    */
    public void setWaiting()
	{
		flag = FlagValue.WAITING;
	}

    /**
    * Set flag to the unvisited state.
    */
	public void setUnvisited()
	{
		flag = FlagValue.UNVISITED;
	}

    /**
    * Set flag to the visited state.
    */
	public void setVisited()
	{
		flag = FlagValue.VISITED;
	}

    /**
    * Returns true if flag is set to the unvisisted state.
    *
    * @return true if flag is set to the unvisisted state
    */
	public boolean isUnvisited()
	{
		return (flag == FlagValue.UNVISITED);
	}

    /**
    * Returns true if flag is set to the visisted state.
    *
    * @return true if flag is set to the visisted state
    */
	public boolean isVisited()
	{
		return (flag == FlagValue.VISITED);
	}

}
