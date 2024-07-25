
import java.util.ArrayList;


public class IDLList<E> {
	//Inner class
	private static class Node<E>{
		E data;
		Node<E> next;
		Node<E> prev;
		
		public Node (E elem) {
			this.data= elem;
			this.next = null;
			this.prev = null;
		}
		
		
		public Node (E elem, Node<E>prev, Node<E>next) {
			this.data = elem;
			this.prev= prev;
			this.next = next;
		}
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices;
	
	
	public IDLList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
		this.indices = new ArrayList<>();
	}
	
	public boolean add(int index, E elem) throws IndexOutOfBoundsException {
		//create newNode.
		Node<E> newNode;
		
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index should be in the boundary of 0 to size");
		}
		
		if (index == 0) {			
			//If given index is 0, we want to make that the head.
			newNode = new Node<>(elem, null, head);
			
			//Check to see if there is a head. If there is, we make the newNode the head.
			if (head != null) {
				head.prev = newNode;
			}else {
				head = newNode;
			}
			
			if (tail == null) {
				tail=head;
			}
			
		} else if (index == size) {
			//If given index is at the end, we want to make that the tail.
			newNode = new Node<>(elem, tail, null);
			
			//set the tail.next to the newNode, considering it was null before.
			tail.next= newNode;
			//then adjust the tail pointer to the newNode.
			tail = newNode;
		} else {
			//Adding into an index that's not the beginning or the end.
			Node<E> nextNode = indices.get(index);
			Node<E> prevNode = nextNode.prev;
			//create the new node and initialize it with the previousNode and the nextNode.
			newNode = new Node<>(elem, prevNode, nextNode);
			prevNode.next = newNode;
			nextNode.prev = newNode;
		}
		
		indices.add(index, newNode);
		size++;		
		return true;
	}
	
	public boolean add(E elem) {
		return add(0, elem);
	}
	
	public boolean append(E elem) {
		return add(size, elem);
	}
	
	//Returns the object at position index from the head
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index should be in the boundary of 0 to size");
		}
		
		return indices.get(index).data;
	}
	
	public E getHead(){
		if (head == null) {
			throw new IllegalStateException("List is Empty; there is no head.");
		}
		
		return head.data;
	}
	
	public E getLast() {
		if (tail == null) {
			throw new IllegalStateException("List is Empty; there is no tail.");
		}
		
		return tail.data;
	}
	
	public int size() {
		return size;
	}
	
	//removes and returns the element at the head;
	public E remove() {
		if (head == null) {
			throw new IllegalStateException("List is Empty; There is no head");
		}
		
		Node<E> nodeToRemove = head;
		head = head.next;
		
		if (head != null) {
			head.prev = null;
		}else {
			tail = null;
		}
		
		indices.remove(0);
		size--;
		return nodeToRemove.data;
	}
	
	public E removeLast() {
		if (tail == null) {
			throw new IllegalStateException("List is Empty; there is no tail.");
		}
		
		Node<E> nodeToRemove = tail;
		tail = tail.prev;
		
		if (tail != null) {
			tail.next = null;
		} else {
			head= null;
		}
		
		indices.remove(size -1);
		size--;
		return nodeToRemove.data;
	}
	
	//removes and returns the element at the index "index". use the index for fast access
	public E removeAt(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index should be in the boundary of 0 to size");
		}
		
		Node<E> nodeToRemove = indices.get(index);
		Node<E> prevNode = nodeToRemove.prev;
		Node<E> nextNode = nodeToRemove.next;
		
		if (prevNode != null) {
			prevNode.next = nextNode;
		} else {
			head = nextNode;
		}
		
		if (nextNode != null) {
			nextNode.prev = prevNode;
		} else {
			tail = prevNode;
		}
		
		indices.remove(index);
		size--;
		return nodeToRemove.data;
	}
	
	public boolean remove(E elem) {
		for (int i = 0; i < size; i++) {
			if (indices.get(i).data.equals(elem)) {
				removeAt(i);
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<E> currentNode = head;
		while (currentNode != null) {
			sb.append(currentNode.data).append(" ");
			currentNode = currentNode.next;
		}
		return sb.toString();
	}
	
	

	public static void main(String[] args) {
//		IDLList<Integer> list = new IDLList<>();
//        list.append(66);
//        list.append(87);
//        list.append(2);
//        list.append(21);
//        list.append(8);
//        list.append(44);
//        list.append(31);
//        list.append(56);
//        list.append(66);
//        list.append(87);
//        list.append(2);
//        list.append(21);
//        list.append(8);
//        list.append(44);
//        list.append(31);
//        list.append(56);
//        list.append(66);
//        list.append(87);
//        list.append(2);
//        list.append(21);
//        list.append(8);
//        list.append(44);
//        list.append(31);
//        list.append(56);
//        list.add(1,9);
//        list.add(2, 1);
//        System.out.println(list);      
//        list.removeAt(0);
//        System.out.println(list);
//        list.remove(44);
//        System.out.println(list); 

	}

}