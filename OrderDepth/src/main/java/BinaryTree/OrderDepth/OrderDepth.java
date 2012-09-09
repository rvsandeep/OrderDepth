package BinaryTree.OrderDepth;

import java.util.LinkedList;
import java.util.List;

public class OrderDepth {

	/**
	 * @param args
	 *            Main method of the program.
	 */
	public static void main(String[] args) {

		BinaryTree<Integer> tree = new BinarySearchTree<Integer>();

		BinaryNode<Integer> root = null;

		int[] inputs = { 2, 3, 34, 1, 12 };

		root = buildTree(tree, root, inputs);

		int height = getHeightOfTree(root);
		List<Integer>[] orderDepth = getOrderDepth(tree, root, inputs, height);

		for (List<Integer> list : orderDepth) {
			System.out.println(list);
		}
	}

	/**
	 * @param tree
	 * @param root
	 * @param inputs
	 * @param height
	 * @returns the OrderDepth,i.e an array of lists,each list having nodes at
	 *          each height.
	 * 
	 */
	public static List<Integer>[] getOrderDepth(BinaryTree<Integer> tree,
			BinaryNode<Integer> root, int[] inputs, int height) {

		@SuppressWarnings("unchecked")
		List<Integer>[] orderDepth = (LinkedList<Integer>[]) new LinkedList[height + 1];

		int currentHeight = 0;

		preorderTraversal(root, orderDepth, currentHeight);
		return orderDepth;
	}

	/**
	 * @param tree
	 * @param root
	 * @param inputs
	 * @return root, to the tree with input elements inserted
	 */
	public static BinaryNode<Integer> buildTree(BinaryTree<Integer> tree,
			BinaryNode<Integer> root, int[] inputs) {
		for (int element : inputs) {
			root = tree.insert(root, element);
		}
		return root;
	}

	/**
	 * @param root
	 * @return height of Tree with given root
	 */
	public static int getHeightOfTree(BinaryNode<Integer> root) {
		if (root == null)
			return -1;
		return Math.max(getHeightOfTree(root.leftNode) + 1,
				getHeightOfTree(root.rightNode) + 1);
	}

	/**
	 * @param root
	 * @param orderDepth
	 * @param currentHeight
	 *            traverses the tree in preorder format (root,leftNodeOfRoot and
	 *            rightNodeOfRoot)
	 */
	public static void preorderTraversal(BinaryNode<Integer> root,
			List<Integer>[] orderDepth, int currentHeight) {
		if (root != null) {
			if (orderDepth[currentHeight] == null) {
				List<Integer> elements = new LinkedList<Integer>();
				elements.add(root.element);
				orderDepth[currentHeight] = elements;
			} else {
				orderDepth[currentHeight].add(root.element);
			}
			preorderTraversal(root.leftNode, orderDepth, currentHeight + 1);

			preorderTraversal(root.rightNode, orderDepth, currentHeight + 1);
		}
	}

}
