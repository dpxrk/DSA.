package DoublyLinkedList;
public class DoublyLinkedList {

  public class Node {
      int data;
      Node next;
      Node prev;

      Node(int data) {
          this.data = data;
      }
  }

  private Node head;

  // Append a node to the end of the list
  public void ListAppend(int data) {
      Node newNode = new Node(data);
      if (head == null) {
          head = newNode;
          return;
      }

      Node last = head;
      while (last.next != null) {
          last = last.next;
      }
      last.next = newNode;
      newNode.prev = last;
  }

  // Prepend a node to the beginning of the list
  public void ListPrepend(int data) {
      Node newNode = new Node(data);
      if (head == null) {
          head = newNode;
          return;
      }

      newNode.next = head;
      head.prev = newNode;
      head = newNode;
  }

  // Insert a node after a given node
  public void ListInsertAfter(Node prevNode, int data) {
      if (prevNode == null) {
          System.out.println("The given previous node cannot be null");
          return;
      }

      Node newNode = new Node(data);
      newNode.next = prevNode.next;
      prevNode.next = newNode;
      newNode.prev = prevNode;

      if (newNode.next != null) {
          newNode.next.prev = newNode;
      }
  }

  // Remove a node from the list
  public void ListRemove(Node node) {
      if (node == null || head == null) {
          return;
      }

      if (head == node) {
          head = node.next;
      }

      if (node.next != null) {
          node.next.prev = node.prev;
      }

      if (node.prev != null) {
          node.prev.next = node.next;
      }
  }

  // Utility function to print the list from the head
  public void printList() {
      Node current = head;
      while (current != null) {
          System.out.print(current.data + " ");
          current = current.next;
      }
      System.out.println();
  }

  public static void main(String[] args) {
      DoublyLinkedList dll = new DoublyLinkedList();

      dll.ListAppend(10);
      dll.ListAppend(20);
      dll.ListPrepend(5);
      dll.printList();  // Output: 5 10 20

      dll.ListInsertAfter(dll.head.next, 15);
      dll.printList();  // Output: 5 10 15 20

      dll.ListRemove(dll.head.next.next);
      dll.printList();  // Output: 5 10 20
  }
}