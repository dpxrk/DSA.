
public class LinkedList {
	public int size;
	public Node head;
	
	public LinkedList() {
		this.size = 0;
		this.head = null;
	}
	
	// Nodes : A container that has value, address to the next node.
	public class Node {
		public Object item;
		public Node next;
		
	}
		
	public void insertNode(int item) {
		Node nodey = new Node();
		nodey.item = item;
		Node currentNode = this.head;
		
		if (this.head == null) {
			this.head = nodey;
			this.head.next = currentNode;
			this.size = 1;
			
		} else {
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			
			currentNode.next = nodey;
			nodey.next = null;
			this.size++;
		}
		
		
	}
	
	public void printNode() {
		if (this.size < 1) {
			System.out.println("The list is empty");
		} else {
			Node current = this.head;
			for ( int i = 0; i < this.size; i++) {
				System.out.println("Node " + current.item + " is at location " + i);
				current = current.next;
			}
		}
	}

	public int getSize() {
		return this.size;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList myList = new LinkedList();
		
		myList.insertNode(23);
		myList.insertNode(29);
		myList.printNode();
		System.out.println("getSize: " + myList.getSize());
		
		
	}

}
