package dijkstra;

import static org.junit.Assert.*;

import org.junit.Test;

public class NodeTest {

	private static final int SET_DEGREE_TEST_DEGREE = 9;
	Node testNode = new Node();
	
	@Test
	public void test_initialization() {
		assertEquals(0, testNode.degree);
	}

	@Test
	public void test_getting_the_degree() {
		assertEquals(0, testNode.getDegree());
	}
	
	@Test
	public void test_setting_the_degree() {
		testNode.setDegree(SET_DEGREE_TEST_DEGREE);
		assertEquals(SET_DEGREE_TEST_DEGREE, testNode.degree);
	}
}
