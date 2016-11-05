package Dijkstra;

import static org.junit.Assert.*;

import org.junit.Test;


public class GraphTest{

	private static final int MAX_DEGREE_IN_TESTS = 5;
	private static final int NUMBER_OF_NODES_IN_TESTS = 30;
	Graph testGraph;

	//This test ensures the default constructor creates an empty graph
	@Test
	public void test_empty_initialization() {
		testGraph = new Graph();
		assertNull(testGraph.edges);
		assertNull(testGraph.nodes);
	}
	
	//This test ensures the getters and setter work with a newly initialized graph
	@Test
	public void test_getters_and_setters_with_new_initialization() {
		testGraph = new Graph();
		assertNull(testGraph.getEdges());
		assertNull(testGraph.getNodes());
	}

	//This set of tests test the initialization of an undirected graph
	@Test
	public void test_that_a_node_gets_initialized() {
		testGraph = new Graph();
		node testNode = testGraph.nodeFactory();
		assertNotNull(testNode);
		assertEquals(0, testNode.degree);
	}
	
	@Test
	public void test_that_all_nodes_get_initialied_by_the_factory() {
		testGraph = new Graph();
		testGraph.nodes = testGraph.setOfNodesFactory(NUMBER_OF_NODES_IN_TESTS);
		for(int i = 0; i < NUMBER_OF_NODES_IN_TESTS; i++){
			node selectedNode = testGraph.nodes[i];
			assertNotNull(selectedNode);
			assertEquals(0, selectedNode.degree);
		}
	}
	
	@Test
	public void test_that_edges_get_intialized() {
		testGraph = new Graph();
		testGraph.edges = testGraph.edgesFactory(NUMBER_OF_NODES_IN_TESTS, MAX_DEGREE_IN_TESTS);
		for(int i = 0; i < NUMBER_OF_NODES_IN_TESTS; i++){
			for(int j = 0; j < MAX_DEGREE_IN_TESTS; j++){
				assertNotNull(testGraph.edges[i][j]);
			}
		}
	}
	
	@Test
	public void test_that_selectRandomNode_selects_a_valid_node()	{
		
	}
	
	@Test
	public void test_all_nodes_have_at_least_one_edge()	{
		testGraph = new Graph(30, 5, false);
		for(int i=0; i < testGraph.nodes.length;i++){
			assertNotNull(testGraph.edges[i][0]);
		}
	}
}