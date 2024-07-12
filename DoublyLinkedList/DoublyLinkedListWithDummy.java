package DoublyLinkedList;

public class DoublyLinkedListWithDummy {
  public class Node {
      int data;
      Node next;
      Node prev;
      Node(int data) {
          this.data = data;
      }
  }

  private Node dummyHead;
  private Node dummyTail;

  public DoublyLinkedListWithDummy() {
      dummyHead = new Node(0); // Dummy head node
      dummyTail = new Node(0); // Dummy tail node
      dummyHead.next = dummyTail;
      dummyTail.prev = dummyHead;
  }

  public void ListAppend(int data) {
      Node newNode = new Node(data);
      Node last = dummyTail.prev;
      last.next = newNode;
      newNode.prev = last;
      newNode.next = dummyTail;
      dummyTail.prev = newNode;
  }

  public void ListPrepend(int data) {
      Node newNode = new Node(data);
      Node first = dummyHead.next;
      dummyHead.next = newNode;
      newNode.prev = dummyHead;
      newNode.next = first;
      first.prev = newNode;
  }

  public void printList() {
      Node current = dummyHead.next; // Start from the first real node
      while (current != dummyTail) {
          System.out.print(current.data + " ");
          current = current.next;
      }
      System.out.println();
  }
}