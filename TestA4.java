package programmingAssignment4;

/**
* A test program for the Graph class.
* 
* Tests bfs, dfs, shortestPath, and dijkstras algorithm
* 
*/
public class TestA4 {

	public static void main(String[] args)
	{
        // g is an undirected, unweighted graph
		Graph g = new Graph(10);
		g.addVertex(0, "Buffalo");
		g.addVertex(1, "Glens Falls");
		g.addVertex(2, "Syracuse");
		g.addVertex(3, "Saratoga Springs");
		g.addVertex(4, "Amsterdam");
		g.addVertex(5, "Albany");
		g.addVertex(6, "Greenwich");
		g.addVertex(7, "Bronx");
		g.addVertex(8, "Manhattan");
		g.addVertex(9, "Long Island");

		g.addEdge(0,1);
		g.addEdge(0,3);
		g.addEdge(0,6);
		g.addEdge(0,7);
		g.addEdge(1,6);
		g.addEdge(1,5);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(2,8);
		g.addEdge(2,4);
		g.addEdge(4,9);
		g.addEdge(8,9);

		String output = g.bfs(3);
		System.out.println("BFS starting at 3");
		System.out.println(output);

		output = g.dfs(3);
		System.out.println("DFS starting at 3");
		System.out.println(output);
		System.out.println();
		

		output = g.shortestPath(3);
		System.out.println("Shortest paths starting at 3");
		System.out.println(output);

        //g2 is a directed, weighted graph
		Graph g2 = new Graph(10);
		g2.addVertex(0, "Buffalo");
		g2.addVertex(1, "Glens Falls");
		g2.addVertex(2, "Syracuse");
		g2.addVertex(3, "Saratoga Springs");
		g2.addVertex(4, "Amsterdam");
		g2.addVertex(5, "Albany");
		g2.addVertex(6, "Greenwich");
		g2.addVertex(7, "Bronx");
		g2.addVertex(8, "Manhattan");
		g2.addVertex(9, "Long Island");

		g2.addDirectedEdgeWithWeight(0,1,5);
		g2.addDirectedEdgeWithWeight(0,3,7);
		g2.addDirectedEdgeWithWeight(0,6,9);
		g2.addDirectedEdgeWithWeight(0,7,6);
		g2.addDirectedEdgeWithWeight(1,6,3);
		g2.addDirectedEdgeWithWeight(1,5,9);
		g2.addDirectedEdgeWithWeight(1,2,2);
		g2.addDirectedEdgeWithWeight(2,5,6);
		g2.addDirectedEdgeWithWeight(2,8,7);
		g2.addDirectedEdgeWithWeight(2,4,9);
		g2.addDirectedEdgeWithWeight(3,5,6);
		g2.addDirectedEdgeWithWeight(4,9,3);
		g2.addDirectedEdgeWithWeight(8,9,3);

		output = g2.dijkstras(0);
		System.out.println("Dijkstra's algorithm starting at 0");
		System.out.println(output);

	}

}