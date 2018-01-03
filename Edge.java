package programmingAssignment4;
/**
* Represents an edge between two vertices in a graph. Modified Christine Reilly's Edge class.
*
* @author rosspowell
*/
public class Edge {
	
	/** The starting vertex of this edge */
	private int start;

    /** The destination vertex of this edge */
    private int dest;

    /** The weight of this edge */
    private int weight;

    /** Default Constructor initializes the data members to 0*/
    public Edge() {
    	start = 0;
    	dest = 0;
    	weight = 0;
    }
    
    /** Constructor initializes the data members */
    public Edge(int s, int d, int w) {
    	start = s;
        dest = d;
        weight = w;
    }
    
    /**
     * Return the value of the start vertex
     */
     public int getStart() {
         return start;
     }
    
    /**
    * Return the value of the destination vertex
    */
    public int getDest() {
        return dest;
    }

    /**
    * Return the value of the edge weight
    */
    public int getWeight() {
        return weight;
    }
    /**
     * used in shortest path method to set the weight of an edge to 1.
     * @param w
     */
    public void setWeight(int w) {
    	weight = w;
    }

}