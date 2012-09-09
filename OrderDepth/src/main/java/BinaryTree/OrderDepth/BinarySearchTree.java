package BinaryTree.OrderDepth;

public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {

	public BinaryNode<T> getLeftNode(BinaryNode<T> node) {
		return node.leftNode;
	}

	public BinaryNode<T> getRightNode(BinaryNode<T> node) {
		return node.rightNode;
	}

	public BinaryNode<T> insert(BinaryNode<T> root, T element) {

		if (root == null) {
			root = new BinaryNode<T>(element);
		} else {
			if (root.element.compareTo(element) > 0) {
				root.leftNode = insert(root.leftNode, element);
			} else if (root.element.compareTo(element) < 0) {
				root.rightNode = insert(root.rightNode, element);
			}
		}

		return root;
	}

}
