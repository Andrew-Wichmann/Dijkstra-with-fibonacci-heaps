package Dijkstra;

public class node {
	protected int degree;
	public node(){
		degree = 0;
	}
	public node(int degree){
		this.degree = degree;
	}
	
	public int getDegree(){
		return degree;
	}
	
	public void setDegree(int degree){
		this.degree = degree;
	}
}
