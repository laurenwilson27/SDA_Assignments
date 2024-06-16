package DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertDLL(1, 0);
        doublyLinkedList.insertDLL(2, 1);
        doublyLinkedList.insertDLL(3, 2);
        doublyLinkedList.insertDLL(4, 3);
        doublyLinkedList.insertDLL(5, 4);
        doublyLinkedList.searchForValue(5);

        doublyLinkedList.traverseDLL();
        doublyLinkedList.deleteDLL(3);
        doublyLinkedList.traverseDLL();

        doublyLinkedList.reverseTraverseDLL();
        doublyLinkedList.searchForValue(5);
    }
}
