package BinaryTree.OrderDepth;

public class BinaryNode<T extends Comparable<T>>{
	T element;
	BinaryNode<T> leftNode;
	BinaryNode<T> rightNode;
	
	BinaryNode(T element){
		this.element =  element;
		this.leftNode = null;
		this.rightNode = null;
	}
}