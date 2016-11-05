package dijkstra;
import java.lang.Math;

public class Graph {
	private int MAX_DISTANCE_LENGTH = 100;
	protected Node[] nodes;
	protected int[][] edges;
	
	//an empty instantiation of a graph will be completely empty
	public Graph(){
		nodes = null;
		edges = null;
	}
	
	//a specific instantiation of a graph requires the size
	//of the graph and the max degree of each node.
	public Graph(int graphSize, int maxDegree, boolean directed){
		nodes = setOfNodesFactory(graphSize);
		edges = edgesFactory(graphSize, maxDegree);
		initializeEdges(maxDegree, directed);
	}

	protected Node nodeFactory() {
		return new Node();
	}

	protected Node[] setOfNodesFactory(int graphSize) {
		Node[] returnSet = new Node[graphSize];
		for(int i = 0; i < graphSize; i++){
			returnSet[i]=nodeFactory();
		}
		return returnSet;
	}

	protected int[][] edgesFactory(int size, int maxDegree) {
		return new int[size][maxDegree];
	}
	
	private void initializeEdges(int maxDegree, boolean directed) {
		//go through each node and initialize a random number of and randomly weighted edges
		for(int i=0; i<nodes.length; i++){
			
			int randomNumberOfEdges = generateRandomNumberOfEdges(maxDegree, nodes[i]);
			nodes[i].setDegree(randomNumberOfEdges);
			
			for(int j=0; j<randomNumberOfEdges; j++){
				
				//Select a random node
				int randomNodeSelector = selectRandomNode();
				
				//Create the edge between the for-loop-selected node and the randomly selected node
				double randomLength = Math.random() * MAX_DISTANCE_LENGTH;
				edges[i][randomNodeSelector] = (int)Math.floor(randomLength);
				//If the graph is undirected, the reverse edge must be added.
				//This edge also must have a random weight.
				if(!directed){
					edges[randomNodeSelector][i] = (int)Math.floor((Math.random() * MAX_DISTANCE_LENGTH));
				}
				
				//Increment the degree of the randomly selected node.
				nodes[randomNodeSelector].setDegree(nodes[randomNodeSelector].getDegree()+1);
			}
		}
		
	}

	protected int generateRandomNumberOfEdges(int maxDegree, Node node) {
		//The number of edge must not be more than the maxDegree specified by the user
		//The maxDegree must be subtracted from the current degree of the node to ensure
		//the max is not exceeded due to previous rounds that generate edges to this node.
		return (int)Math.floor((Math.random() * (maxDegree-node.getDegree())));
	}

	protected int selectRandomNode() {
		return (int)Math.floor((Math.random() * nodes.length));
	}

	/* NOT YET IMPLEMENTED OR TESTED
	public boolean addNode(node newNode){
		numOfNodes++;
		nodes[numOfNodes]=newNode;
		return true;
	}
	*/
	
	//getters and setters for the graph
	public Node[] getNodes(){
		return nodes;
	}
	
	public int[][] getEdges(){
		return edges;
	}
}