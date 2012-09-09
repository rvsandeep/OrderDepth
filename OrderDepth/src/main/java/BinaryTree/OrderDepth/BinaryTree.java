package BinaryTree.OrderDepth;

public interface BinaryTree<T extends Comparable<T>> {
	
	public BinaryNode<T> getLeftNode(BinaryNode<T> node);
	
	public BinaryNode<T> getRightNode(BinaryNode<T> node);
	
	public BinaryNode<T> insert(BinaryNode<T> root,T element);
	
}
