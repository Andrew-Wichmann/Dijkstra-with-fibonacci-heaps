package dijkstra;

public class Node {
	protected int degree;
	public Node(){
		degree = 0;
	}
	public Node(int degree){
		this.degree = degree;
	}
	
	public int getDegree(){
		return degree;
	}
	
	public void setDegree(int degree){
		this.degree = degree;
	}
}