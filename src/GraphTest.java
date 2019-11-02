public class GraphTest {

    public static void main(String[] args){

        int V = 13;    // number of verticies
        Graph graph = new Graph(V);
        graph.addEdge(7,8);
        graph.addEdge(0,2);
        graph.addEdge(0,1);
        graph.addEdge(6,0);
        graph.addEdge(3,4);
        graph.addEdge(5,4);
        graph.addEdge(5,3);
        graph.addEdge(9,10);
        graph.addEdge(9,11);
        graph.addEdge(9,12);
        graph.addEdge(11,12);
        graph.addEdge(5,0);
        graph.addEdge(4,6);

        System.out.println("number of vertices is " + graph.numOfVerticies());
        System.out.println("number of edges is " + graph.numOfEdges());

        // print the adjacent of each vertex in the graph
        for(int i=0; i<V; i++){
            StringBuilder str = new StringBuilder("[ ");
            for(int k: graph.adj(i))
                str.append(k + " ");
            str.append("]");
            System.out.println("adj list of vertex " + i + " is: " + str.toString());
        }

        // perform DFS
        GraphDFS dfs = new GraphDFS(graph,0);
        for(int i=0; i<V; i++){
            if(dfs.isConnected(i))
                System.out.println("vertex 0 is connected to vertex " + i);
            else
                System.out.println("vertex 0 is not connected to vertex " + i);
        }

        // perform BFS
        GraphBFS bfs = new GraphBFS(graph, 0);
        for(int i=0; i<V; i++)
            if(bfs.isConnected(i))
                System.out.println("shortest distance form vertex 0 to vertex " + i + " is " + bfs.distTo(i));


        // count number of connected components
        ConnectedComponents cc = new ConnectedComponents(graph);
        System.out.println("count of connected components is " + cc.count());
        for(int i=0; i<V; i++)
            System.out.println("component id of vertex " + i + " is " + cc.id(i));

    }

}
