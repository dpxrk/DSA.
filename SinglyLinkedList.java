public class SinglyLinkedList {
    private Node head;

    private static class Node{
      int data;
      Node next;

      Node(int data) {
        this.data = data;
        this.next = null;
      }
    }

    public SinglyLinkedList(){
      this.head = null;
    }

    //Method to append a node to the end of the list
    public void ListAppend(int data){
      Node newNode = new Node(data);
      if (head == null){
        head = newNode;
        return;
      }

      Node current = head;

      while (current.next != null){
        current = current.next;
      }

      current.next = newNode;
    }

    //Method to prepend to the beginning of the list
    public void ListPrepend(int data){
      Node newNode = new Node(data);
      newNode.next = head;
      head = newNode;
    }

    public void ListInsertAfter(Node prevNode, int data){
      if (prevNode == null){
        System.out.println("The given previous node is null");
        return;
      }

      Node newNode = new Node(data);
      newNode.next = prevNode.next;
      prevNode.next = newNode;
    }


    public void printList() {
      Node current = head;
      while (current != null) {
          System.out.print(current.data + " ");
          current = current.next;
      }
      System.out.println();
    }

    public static void main(String[] args) {
      SinglyLinkedList list = new SinglyLinkedList();

      // Test ListAppend
      list.ListAppend(1);
      list.ListAppend(2);
      list.ListAppend(3);
      list.printList(); // Output: 1 2 3

      // Test ListPrepend
      list.ListPrepend(0);
      list.printList(); // Output: 0 1 2 3

      // Test ListInsertAfter
      Node secondNode = list.head.next; // Node with data 1
      list.ListInsertAfter(secondNode, 5);
      list.printList(); // Output: 0 1 5 2 3
  }

}

