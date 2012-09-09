package BinaryTree.OrderDepth;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for OrderDepth
 */
public class OrderDepthTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public OrderDepthTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(OrderDepthTest.class);
	}

	BinaryTree<Integer> tree = new BinarySearchTree<Integer>();

	BinaryNode<Integer> root = null;

	public void tearDown() throws Exception {
		root = null;
	}
	
	/**
	 * Rigourous Test :-)
	 */
	
	public void testOrderDepth1() {

		int[] inputs = { 2, 3, 12 };

		root = OrderDepth.buildTree(tree, root, inputs);

		int height = OrderDepth.getHeightOfTree(root);
		assertEquals(2, height);

		@SuppressWarnings("unchecked")
		List<Integer>[] expectedOrderDepth = (LinkedList<Integer>[]) new LinkedList[height + 1];
		expectedOrderDepth[0] = new LinkedList<Integer>(Arrays.asList(2));
		expectedOrderDepth[1] = new LinkedList<Integer>(Arrays.asList(3));
		expectedOrderDepth[2] = new LinkedList<Integer>(Arrays.asList(12));

		boolean got = true;
		List<Integer>[] obtainedOrderDepth = OrderDepth.getOrderDepth(tree, root, inputs,
				height);
		got = isEqual(height, expectedOrderDepth, got, obtainedOrderDepth);

		assertTrue(got);

	}

	public void testOrderDepth2() {

		int[] inputs = { 2, 3, 34, 1, 12 };

		root = OrderDepth.buildTree(tree, root, inputs);

		int height = OrderDepth.getHeightOfTree(root);
		assertEquals(3, height);

		@SuppressWarnings("unchecked")
		List<Integer>[] expectedOrderDepth = (LinkedList<Integer>[]) new LinkedList[height + 1];
		expectedOrderDepth[0] = new LinkedList<Integer>(Arrays.asList(2));
		expectedOrderDepth[1] = new LinkedList<Integer>(Arrays.asList(1, 3));
		expectedOrderDepth[2] = new LinkedList<Integer>(Arrays.asList(34));
		expectedOrderDepth[3] = new LinkedList<Integer>(Arrays.asList(12));

		boolean got = true;
		List<Integer>[] obtainedOrderDepth = OrderDepth.getOrderDepth(tree, root, inputs,
				height);
		got = isEqual(height, expectedOrderDepth, got, obtainedOrderDepth);

		assertTrue(got);

	}
//	testing when no inputs are given
	public void testOrderDepth3() {

		int[] inputs = {};

		root = OrderDepth.buildTree(tree, root, inputs);

		int height = OrderDepth.getHeightOfTree(root);
		assertEquals(-1, height);

		@SuppressWarnings("unchecked")
		List<Integer>[] expectedOrderDepth = (LinkedList<Integer>[]) new LinkedList[height + 1];
	
		boolean got = true;
		List<Integer>[] obtainedOrderDepth = OrderDepth.getOrderDepth(tree, root, inputs,
				height);
		got = isEqual(height, expectedOrderDepth, got, obtainedOrderDepth);

		System.out.println(got);
		assertTrue(got);

	}
	private boolean isEqual(int height, List<Integer>[] orderDepth,
			boolean got, List<Integer>[] obtained) {
		for (int i = 0; i < height + 1; i++) {
			if (!orderDepth[i].equals(obtained[i])) {
				got = false;
				break;
			}
		}
		return got;
	}
}
