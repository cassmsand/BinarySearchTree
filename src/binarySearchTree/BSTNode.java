package binarySearchTree;

public class BSTNode<E>{
	
	//instance variables
	private E data;
	private BSTNode<E> left;
	private BSTNode<E> right;
	
	//Constructor
	public BSTNode(E data, BSTNode<E> left, BSTNode<E> right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	//Getters and setters
	public E getData() {
		return data;
	}

	public BSTNode<E> getLeft() {
		return left;
	}

	public BSTNode<E> getRight() {
		return right;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setLeft(BSTNode<E> left) {
		this.left = left;
	}

	public void setRight(BSTNode<E> right) {
		this.right = right;
	}

	
	
}
