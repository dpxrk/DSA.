package SinglyLinkedList;

public class SinglyLinkedListWithDummy {
  public class Node {
      int data;
      Node next;
      Node(int data) {
          this.data = data;
      }
  }

  private Node dummy;

  public SinglyLinkedListWithDummy() {
      dummy = new Node(0); // Dummy node
  }

  public void ListPrepend(int data) {
      Node newNode = new Node(data);
      newNode.next = dummy.next;
      dummy.next = newNode;
  }

  public void ListAppend(int data) {
      Node newNode = new Node(data);
      Node last = dummy;
      while (last.next != null) {
          last = last.next;
      }
      last.next = newNode;
  }

  public void printList() {
      Node current = dummy.next; // Start from the first real node
      while (current != null) {
          System.out.print(current.data + " ");
          current = current.next;
      }
      System.out.println();
  }
}