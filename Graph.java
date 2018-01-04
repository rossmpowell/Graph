package programmingAssignment4;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * This class is a Graph data structure, it holds the amount of vertices and the edges connecting them.
 * @author rosspowell
 *
 */
public class Graph {
	
	/** The vertex array where each vertices name will be stored */
	private Vertex[] v;
	
	/* The variable where we will store the Edges */
	private Edge[][] aMatrix;
	
	/**
	 * Constructor for the Graph class which initializes an v by v Adjacency Matrix
	 * @param v The amount of vertices that are in the Graph.
	 */
	public Graph(int v) {
		aMatrix = new Edge[v][v];
		for (int i = 0; i < aMatrix.length; i++) {
			aMatrix[i][i] = new Edge(i, i, 0);
		}
		//initalize the vertex array
		this.v = new Vertex[v];
		for (int i = 0; i < this.v.length; i++) {
			this.v[i] = new Vertex();
		}
	}
	
	/**
	 * Adds the name onto the null vertice in v 
	 * @param index The desired index in the vertex array
	 * @param name The desired name of the vertex
	 * @return Method returns true if the method is successful
	 */
	public boolean addVertex(int index, String name) {
		v[index].setName(name);
		return true;
	}
	
	
	/**
	 * This method returns the number of vertices within the Graph
	 * @return The number of vertices within the Graph (length of the Adjacency Matrix
	 */
	public int getNumEdges() {
		return aMatrix.length;
	}
	/**
	 * Adds a directed, unweighted edge from vertex v1 to vertex v2.
	 * @param v1 Vertex number of the starting vertex for the edge.
	 * @param v2 Vertex number of the destination vertex for the edge.
	 * @throws IllegalArguementException if either parameter is not a valid vertex number.
	 */
	public void addDirectedEdge(int v1, int v2) throws IllegalArgumentException {
		if (v1 < 0 || v2 < 0 || v1 > getNumEdges() || v2 > getNumEdges()) {
			throw new IllegalArgumentException("The starting vertex or ending vertex is out of range");
		}
		aMatrix[v2][v1] = new Edge(v1, v2, 1);
	}
	
	/**
	 * Adds a directed, weighted edge from vertex v1 to vertex v2.
	 * @param v1 Vertex number of the starting vertex for the edge.
	 * @param v2 Vertex number of the destination vertex for the edge.
	 * @param w Weight of the edge. Must be greater than zero.
	 * @throws IllegalArguementException if either parameter is not a valid vertex number.
	 */
	public void addDirectedEdgeWithWeight(int v1, int v2, int w) throws IllegalArgumentException {
		if (v1 < 0 || v2 < 0 || v1 > getNumEdges() || v2 > getNumEdges()) {
			throw new IllegalArgumentException("The starting vertex or ending vertex is out of range");
		}
		aMatrix[v2][v1] = new Edge(v1, v2, w);
	}
	
	/**
	 * Adds a undirected, weighted edge from vertex v1 to vertex v2.
	 * @param v1 Vertex number of the starting vertex for the edge.
	 * @param v2 Vertex number of the destination vertex for the edge.
	 * @throws IllegalArguementException if either parameter is not a valid vertex number.
	 */
	public void addEdge(int v1, int v2) throws IllegalArgumentException {
		if (v1 < 0 || v2 < 0 || v1 > getNumEdges() || v2 > getNumEdges()) {
			throw new IllegalArgumentException("The starting vertex or ending vertex is out of range");
		}
		aMatrix[v2][v1] = new Edge(v1, v2, 1);
		aMatrix[v1][v2] = new Edge(v2, v1, 1);
	}
	
	/**
	 * Adds a undirected, weighted edge from vertex v1 to vertex v2.
	 * @param v1 Vertex number of the starting vertex for the edge.
	 * @param v2 Vertex number of the destination vertex for the edge.
	 * @param w Weight of the edge. Must be greater than zero.
	 * @throws IllegalArguementException if either parameter is not a valid vertex number.
	 */
	public void addEdgeWithWeight(int v1, int v2, int w) throws IllegalArgumentException {
		if (v1 < 0 || v2 < 0 || v1 > getNumEdges() || v2 > getNumEdges()) {
			throw new IllegalArgumentException("The starting vertex or ending vertex is out of range");
		}
		aMatrix[v2][v1] = new Edge(v1, v2, w);
		aMatrix[v1][v2] = new Edge(v2, v1, w);
	}
	
	/**
	 * Returns a string representation of the graph vertices traversed in breadth first order from the 
	 * specified starting vertex.
	 * @param start The starting vertex
	 * @return A string representation of the graph vertices traversed in breadth first order;
	 * for each node includes node name and vertex number.
	 * @throws IllegalArguementException if start is not a valid vertex number.
	 */
	public String bfs(int start) throws IllegalArgumentException {
		if(start < 0 || start > getNumEdges()) {
            throw new IllegalArgumentException("start is not a valid vertex: " + start);
        }

        String output = "";

        // Use a queue to store the nodes that are waiting to be visited.
        // Queue is an interface. We can declare a variable of type Queue
        // then create a LinkedList object for that Queue.
        Queue<Integer> q = new LinkedList<Integer>();

        // Initialize all vertices to unvisited
        makeAllUnvisited();

        // Enqueue the start vertex
        q.add(start);
        v[start].setWaiting();

        while(!q.isEmpty()) {
        	
            // Dequeue the vertex at the front of the queue and add its information
            // to the output string. Mark that vertex as visited.
            int dqv = q.remove();
            v[dqv].setVisited();
            output += "[" + v[dqv].getName() + ", " + dqv + "]; ";

            // Enqueue all adjacent, unvisited vertices to dqv.
            // Loop through dqv's edgeList. Add unvisited vertices to the
            // queue and set those vertices to the waiting state.
            LinkedList<Edge> edges = new LinkedList<Edge>();
            for (int i = 0; i < aMatrix[0].length; i++) {
            	if (aMatrix[i][dqv] != null && aMatrix[i][dqv].getWeight() != 0) {
            		edges.add(aMatrix[i][dqv]);
            	}
            }
            for(int i = 0; i < edges.size(); i++) {
                int destV = edges.get(i).getDest();
                if(v[destV].isUnvisited()) {
                    q.add(destV);
                    v[destV].setWaiting();
                }
            }
        }
        return output;
	}
	
	/**
	 * Sets every vertex in the graph to the unvisited state.
	 */
	 private void makeAllUnvisited() {
			for (int i = 0; i< getNumEdges(); i++) {
				v[i].setUnvisited();
			}
	}
	/**
	 * Returns a string representation of the graph vertices traversed in depth first order from the 
	 * specified starting vertex.
	 * @param start The starting vertex
	 * @return A string representation of the graph vertices traversed in depth first order;
	 * for each node includes node name and vertex number.
	 * @throws IllegalArguementException if start is not a valid vertex number.
	 */
	public String dfs(int start) throws IllegalArgumentException {
		 if(start < 0 || start > v.length) {
	            throw new IllegalArgumentException("start is not a valid vertex: " + start);
	     }
		 //String to hold the output
	     String output = "";
	     
	     Stack<Integer> s = new Stack<Integer>();
	     
	     // Initialize all vertices to unvisited
	     makeAllUnvisited();
	     
	     //Add starting vertex to the stack
	     s.push(start);
	     
	     //Visit starting vertex
	     v[start].setVisited();
	     output += "[" + v[start].getName() + ", " + start + "]; ";
	     
	     while(!s.isEmpty()) {
	    	 
	    	 //The peeked vertex
	    	 int pV = s.peek();
	    	 
	    	 //Find the edges that pV is adjacent to
	    	 LinkedList<Edge> edges = new LinkedList<Edge>();
	         for (int i = 0; i < aMatrix[0].length; i++) {
	             if (aMatrix[i][pV] != null && aMatrix[i][pV].getWeight() != 0) {
	            	 edges.add(aMatrix[i][pV]);
	             }
	         }
	         //If vertex has any adjacent vertices that were unvisited
	         boolean allDestIsVisited = true;
	         
	         //iterator variable in next loop
	         int i = 0;
	         
	         //See if a vertex has not been visited
	         while (i < edges.size() && allDestIsVisited) {
	             int destV = edges.get(i).getDest();
	             //See if the given vertex has been visited
	             if(v[destV].isUnvisited()) {
	            	 //Push the vertex if it has not been visited
	                 s.push(destV);
	                 
	                 //Visit found vertex
	                 v[destV].setVisited();
	                 output += "[" + v[destV].getName() + ", " + destV + "]; ";
	                 
	                 //The adjacent vertice has not been visited.
	                 allDestIsVisited = false;
	             }
	             i++;
	         }
	         //If there are no unvisited vertices, pop the Stack
	         if (allDestIsVisited) {
	        	 s.pop();
	         }
	         
	         
	     }
	        
	     return output;
	}
	
	/**
	 * Returns a string that contains information about the shortest path from the given node to every node in
	 * the graph, including the path from the given node to itself. This method considers the shortest path
	 * assuming the edges are unweighted. The string should have an end of line after each path from the given
	 * node to another node.
	 * @param start The starting vertex
	 * @return A string containing information about the shortest path from the given node to every node in the graph.
	 * @throws IllegalArguementException if start is not a valid vertex number.
	 */
	public String shortestPath(int start) throws IllegalArgumentException {
		if(start < 0 || start > getNumEdges()) {
            throw new IllegalArgumentException("start is not a valid vertex: " + start);
        }

        String output = "";
        
        //LinkedList of LinkedLists that store the graphs path
      	LinkedList<LinkedList<Integer>> vertexPath = new LinkedList<LinkedList<Integer>>();
      	
      	
      	for(int i = 0; i < v.length; i++) {
			//Integer LinkedList that stores the previously visted vertices
			vertexPath.add(new LinkedList<Integer>());
		}
      	
      	//Array of strings to hold each paths string representation
      	String[] vertexString = new String[v.length];
      	
      	for(int i = 0; i < vertexString.length; i++) {
			vertexString[i] = "";
			vertexString[i] += "Minimum weight path from " + v[start].getName() + " " + start + " to " +
					v[i].getName() + " " + i + " is ";
		}
      	
        // Use a queue to store the nodes that are waiting to be visited.
        // Queue is an interface. We can declare a variable of type Queue
        // then create a LinkedList object for that Queue.
        Queue<Integer> q = new LinkedList<Integer>();
        
        int[] pathLen = new int[v.length];
		//Initialize the path of each to be the max value
		for(int i = 0; i < pathLen.length; i++) {
			pathLen[i] = Integer.MAX_VALUE;
		}
        // Initialize all vertices to unvisited
        makeAllUnvisited();
        
        //The pathLen of the start vertex is 0
        pathLen[start] = 0;
        
        // Enqueue the start vertex
        q.add(start);
        
        
        
        v[start].setWaiting();
        
        
        while(!q.isEmpty()) {
        	
            // Dequeue the vertex at the front of the queue
            // Mark that vertex as visited.
            int dqv = q.remove();
            v[dqv].setVisited();
            

            // Enqueue all adjacent, unvisited vertices to dqv.
            // Loop through dqv's edgeList. Add unvisited vertices to the
            // queue and set those vertices to the waiting state.
            LinkedList<Edge> edges = new LinkedList<Edge>();
            for (int i = 0; i < aMatrix[0].length; i++) {
            	if (aMatrix[i][dqv] != null && aMatrix[i][dqv].getWeight() != 0) {
            		edges.add(aMatrix[i][dqv]);
            	}
            }
            for(int i = 0; i < edges.size(); i++) {
                int destV = edges.get(i).getDest();
                if(v[destV].isUnvisited()) {
                	//update the pathLen of the destination vertex
                	pathLen[destV] = pathLen[dqv] + 1;
					
                	//Update the vertexPath
                	for (int j = 0; j < vertexPath.get(dqv).size(); j++) {
						vertexPath.get(destV).add(vertexPath.get(dqv).get(j));
					}
					vertexPath.get(destV).add(destV);
                	
                    q.add(destV);
                    
                    v[destV].setWaiting();
                }
            }
        }
        //Format the output string with the newFound pathlengths and vertexStrings/vertexPath values.
    	for (int i = 0; i < vertexString.length; i++) {
    		vertexString[i] += pathLen[i] + "; path from " + v[start].getName() + " " + start + " ";
    		if (pathLen[i] == 0) {
    			vertexString[i] += "to " + v[start].getName() + " " + start + " ";
    		} else {
    			for (int j = 0; j < vertexPath.get(i).size(); j++) {
    				vertexString[i] += "to " + v[vertexPath.get(i).get(j)].getName() + " " + vertexPath.get(i).get(j) + " ";
    			}
    		}
    			
    		//put each vertexString (Path and Path Length) into the array and make a new line for each one
    		output += vertexString[i] + "\n";
    	}
    	//return the output string 
    	return output;
	}		
			
	/**
	 * Returns a string that contains information about the shortest path from the given node to every node in
	 * the graph, including the path from the given node to itself. This method uses Dijkstra's algorithm for
	 * finding the shortest path assuming the edges are weighted. The string should have an end of line after
	 * each path from the given node to another node.
	 * @param start The starting vertex
	 * @return A string containing information about the shortest path from the given node to every node in the graph.
	 * @throws IllegalArgumentException if start is not a valid vertex number.
	 */
	public String dijkstras(int start) throws IllegalArgumentException {
		if (start < 0 || start > getNumEdges()) {
			throw new IllegalArgumentException("The starting vertex is out of range");
		}
		
		//output string variable
		String output = "";
				
		//LinkedList of LinkedLists that store the graphs path
		LinkedList<LinkedList<Integer>> vertexPath = new LinkedList<LinkedList<Integer>>();
				
		//Array of strings to hold each paths string representation
		String[] vertexString = new String[v.length];
		
		makeAllUnvisited();
		for(int i = 0; i < v.length; i++) {
			//Integer LinkedList that stores the previously visted vertices
			vertexPath.add(new LinkedList<Integer>());
		}
		
		for(int i = 0; i < vertexString.length; i++) {
			vertexString[i] = "";
			vertexString[i] += "Minimum weight path from " + v[start].getName() + " " + start + " to " +
					v[i].getName() + " " + i + " is ";
		}
		
		int[] pathLen = new int[v.length];
		//Initialize the path of each to be the max value
		for(int i = 0; i < pathLen.length; i++) {
			pathLen[i] = Integer.MAX_VALUE;
		}
		
		//Create a priority queue of type VertexMinWeight which will prioritize based off of weight of the current path.
		PriorityQueue<VertexMinWeight> pq = new PriorityQueue<VertexMinWeight>();
		
		//Path length of the start vertex is always 0
		pathLen[start] = 0;
		
		
		//Add the first vertex and its weight
		pq.add(new VertexMinWeight(start , 0));
		
		//vertex integer is equal to the start vertex integer
		int vertex = start;
		
		//While theres something in the PriorityQueue
		while (!pq.isEmpty()) {
			
			
			//Cycle through the priority queue
			//if the vertex has adjacent vertice that has not been visited, set vertex equal to the nameNum
			for (int i = 0; i < pq.size(); i++) {
				//If the vertex in the pq is unvisited
				if (v[pq.peek().getNameNumber()].isUnvisited()) {
					//get the number of this vertex that is unvisited
					vertex = pq.poll().getNameNumber();
					break;
				} else {
					//if it is visited delete the vertex from the PriorityQueue
					pq.poll();
				}
			}
			//set the new vertex to visited
			v[vertex].setVisited();
			
			//edges that are the adjacent adeges to the graph
			LinkedList<Edge> edges = new LinkedList<Edge>();
			
			//cycle through aMatrix to find the adjancent vertices and add them to edges
			for (int i = 0; i < aMatrix[0].length; i++) {
				
	            if (aMatrix[i][vertex] != null && aMatrix[i][vertex].getWeight() != 0) {
	           	 	edges.add(aMatrix[i][vertex]);
	            }
	        }
			
			//for all the edges in the adjacent vertex (edge)  list
			for(int i = 0; i < edges.size(); i++) {
				int destV = edges.get(i).getDest();
				//If the current path length is less than the pathlength stored in the pathLen arrray
				if(pathLen[destV] > (pathLen[vertex] + edges.get(i).getWeight())) {
					vertexPath.get(destV).clear();
					for (int j = 0; j < vertexPath.get(vertex).size(); j++) {
						vertexPath.get(destV).add(vertexPath.get(vertex).get(j));
					}
					vertexPath.get(destV).add(destV);
					//Set the pathLen of the specific vertex to the current pathLen
					pathLen[destV] = (pathLen[vertex] + edges.get(i).getWeight());
					//Add any of these pathLengths to the PQ
					pq.add(new VertexMinWeight(edges.get(i).getDest(), pathLen[destV]));
					
				}
			}
			
			
		}
		//Format the output string with the newFound pathlengths and vertexStrings/vertexPath values.
		for (int i = 0; i < vertexString.length; i++) {
			vertexString[i] += pathLen[i] + "; path from " + v[start].getName() + " " + start + " ";
			if (pathLen[i] == 0) {
				vertexString[i] += "to " + v[start].getName() + " " + start + " ";
			} else {
				for (int j = 0; j < vertexPath.get(i).size(); j++) {
					vertexString[i] += "to " + v[vertexPath.get(i).get(j)].getName() + " " + vertexPath.get(i).get(j) + " ";
				}
			}
			
			//put each vertexString (Path and Path Length) into the array and make a new line for each one
			output += vertexString[i] + "\n";
		}
		//return the output string 
		return output;
	}		
	
 }
