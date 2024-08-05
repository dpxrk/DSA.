import java.util.Random;
import java.util.Stack;


/***
 * 
 * @Author Daniel Park 
 * Completed in Eclipse
 * 
 */
public class Treap<E extends Comparable<E>> {
	
	/**
	 * Private node class
	 * @param <E>
	 */
	private static class Node<E>{
		public E data;
		public int priority;
		public Node<E> left;
		public Node<E> right;
		
		public Node(E data, int priority) {
			if (data == null) {
				throw new IllegalArgumentException("Data is null");
			}
			this.data = data;
			this.priority = priority;
			this.left = null;
			this.right = null;
		}
		
		/**
		 * Switching a node's left to the node's position
		 * 
		 * @return Node<E>
		 */
		public Node<E> rotateRight(){
			Node<E> newNode = this.left;
			this.left = newNode.right;
			newNode.right = this;
			return newNode;
			
		}
		
		/**
		 * 
		 * Switching a node's right to the node's position
		 * @return Node<E>
		 */
		public Node<E> rotateLeft(){
			Node<E> newNode = this.right;
			this.right = newNode.left;
			newNode.left = this;
			return newNode;			
		}
		
	}
	
	private Random priorityGenerator;
	private Node<E> root;
	
	/**
	 * 
	 * Constructor of Treap;
	 */
	
	public Treap() {
		this.priorityGenerator = new Random();
		this.root = null;
	}
	/**
	 *  Second constructor of Treap;
	 * @param seed
	 */
	public Treap(long seed) {
		this.priorityGenerator = new Random(seed);
		this.root = null;
	}
	
	
	/**
	 * 
	 * @param key
	 * @return boolean to let us know if the node with key 
	 * has been added
	 */
	public boolean add(E key) {
		int priority = priorityGenerator.nextInt();
		return add(key, priority);
	}
	
	/**
	 * 
	 * Implementing a stack, we are able to add node to the stack
	 * to help us keep track of parent // child nodes.
	 * 
	 * 
	 * @param key
	 * @param int priority
	 * @return boolean to let us know if the node has been added 
	 */
	
	public boolean add(E key, int priority) {
		if (root == null) {
			root = new Node<E>(key, priority);
			return true;
		}
		
		Stack<Node<E>> stack = new Stack<>();
		Node<E> currentNode = root;
		
		while (true) {
			stack.push(currentNode);
			int comparison = key.compareTo(currentNode.data);
			if (comparison == 0) {
				return false;
			} else if (comparison < 0) {
				if (currentNode.left == null) {
					currentNode.left = new Node<>(key, priority);
					stack.push(currentNode);
					break;
				} else {
					currentNode = currentNode.left;
				}
			} else {
				if (currentNode.right == null) {
					currentNode.right = new Node<>(key, priority);
					stack.push(currentNode);
					break;
				}else {
					currentNode = currentNode.right;
				}
			}
		}
		
		
		reheap(stack);
		return true;
	}
	
	/*
	 * A helper function that will bubble up a stack
	 * to make sure that the nodes are in the correct order
	 * 
	 * 
	 * @param Stack<Node<E>> stack
	 *  
	 */
	
	
	public void reheap(Stack<Node<E>>stack) {
		Node<E> childNode = stack.pop();
		
		while (!stack.isEmpty()) {
			Node<E> parentNode = stack.pop();
			if (parentNode.priority < childNode.priority) {
				if (parentNode.left == childNode) {
					childNode = parentNode.rotateRight();
				} else {
					childNode = parentNode.rotateLeft();
				}		
				if (!stack.isEmpty()) {
					Node<E> grandParentNode = stack.peek();
				
					if (grandParentNode.left == parentNode) {
						grandParentNode.left = childNode;
					} else {
						grandParentNode.right = childNode;
						}
					} else {
						this.root = childNode;
				}
			} else {
				//break if no rotation is required.
				break;
			}
		}
	}
	
	/*
	 * 
	 * @param key
	 * @return boolean to let us know if the node has been deleted based off of key
	 * 
	 */
	
	public boolean delete(E key) {
		if (root == null) {
			return false;
		}
		
		return delete(null, root, key);
	}
	
	/*
	 * Helper function to make sure after deleting the node,
	 * that the stack readjusted after deletion
	 * 
	 * @param Node<E> parent
	 * @param Node<E> node
	 * @param <E> key
	 * @return boolean 
	 */
	 private boolean delete(Node<E> parent, Node<E> node, E key) {
	     if (node == null) return false;

	     int comparison = key.compareTo(node.data);
	     if (comparison < 0) {
	         return delete(node, node.left, key);
	     } else if (comparison > 0) {
	         return delete(node, node.right, key);
	     } else {
	         if (node.left == null || node.right == null) {
	             Node<E> child = (node.left != null) ? node.left : node.right;
	             if (parent == null) {
	                 root = child;
	             } else if (parent.left == node) {
	                 parent.left = child;
	             } else {
	                 parent.right = child;
	             }
	         } else {
	             if (node.left.priority > node.right.priority) {
	                 node = node.rotateRight();
	                 if (parent == null) {
	                     root = node;
	                 } else if (parent.left == node) {
	                     parent.left = node;
	                 } else {
	                     parent.right = node;
	                 }
	                 delete(node, node.right, key);
	             } else {
	                 node = node.rotateLeft();
	                 if (parent == null) {
	                     root = node;
	                 } else if (parent.left == node) {
	                     parent.left = node;
	                 } else {
	                     parent.right = node;
	                 }
	                 delete(node, node.left, key);
	             }
	         }
	         return true;
	      }
	 }
	 
	 /*
	  * 
	  * 
	  * @param Node<E> root
	  * @param E key
	  * @return boolean 
	  */
	
	private boolean find(Node<E> root, E key) {
		if (root == null) return false;
		int comparison = key.compareTo(root.data);
		if (comparison == 0) {
			return true;
		} else if (comparison <0){
			return find(root.left, key);
		} else {
			return find(root.right, key);
		}
		
	}
	
	/*
	 * @param key 
	 * @return boolean 
	 */
	
	public boolean find(E key) {
		return find(root, key);
	}
	
	/*
	 * 
	 * @return String returning the stack in a string form 
	 * 
	 */
	 @Override
	 public String toString() {
		 StringBuilder sb = new StringBuilder();
	     toString(root, sb);
	     return sb.toString();
	 }

	 private void toString(Node<E> node, StringBuilder sb) {
	     if (node == null) return;
	     sb.append("( key = ").append(node.data).append(", priority = ").append(node.priority).append(")");
	     if (node.left != null || node.right != null) {
	         sb.append("(");
	         toString(node.left, sb);
	         
	         if (node.right != null) {
	             sb.append(",");
	         }
	         
	         toString(node.right, sb);
	         sb.append(")");
	     }
	 }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Treap<Integer> testTree = new Treap<>();
	    testTree.add(4, 19);
	    testTree.add(2, 31);
	    testTree.add(6, 70);
	    testTree.add(1, 84);
	    testTree.add(3, 12);
	    testTree.add(5, 83);
	    testTree.add(7, 26);

	    
	    
	    System.out.println(testTree.toString());

	    testTree.delete(5);
	    testTree.delete(6);
	     
	    System.out.println(testTree.toString());

	}

}
