package dijkstra;

public class Edge {
	protected Node from;
	protected Node to;
	public Edge(Node from, Node to){
		this.from = from;
		this.to = to;
	}
}