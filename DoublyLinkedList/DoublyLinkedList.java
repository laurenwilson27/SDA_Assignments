package DoublyLinkedList;

public class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int size;

    //Create a DLL
    public DoublyNode createDLL(int nodeValue) {
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }


    //insert into a DLL
    //0. If link list doesn't
    //1. inserting at the begining
    //2. Inserting at the ending
    //3. Insert anywhere

    public void  insertDLL (int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if(head == null) {
            createDLL(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = null;
            head.prev = tail;
            head = newNode;
        } else if (location >= size) {
            newNode.next = null;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }

    //Traverse a Linked List
    public void traverseDLL(){
        if (head == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if (i != size -1) {
                    System.out.print(" <-> ");

                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("\n");
    }

    // Reverse Traverse
    public void reverseTraverseDLL() {
        if (tail == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode curNode = tail;

            // I decided to write a different sort of loop from the above
            // This loop simply continues toward the head until it reaches a null node (ie, has gone past the head)
            while (curNode != null) {
                System.out.print(curNode.value);
                if (curNode.prev != null)
                    System.out.print(" <-> ");

                curNode = curNode.prev;
            };
        }

        System.out.println();
    }

    // Search Node
    public void searchForValue(int value) {
        if (head == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode curNode = head;

            for (int i = 0; i < size; i++) {
                if (curNode.value == value) {
                    System.out.println("Value " + value + " was found at index " + i);
                    return;
                }

                curNode = curNode.next;
            }

            System.out.println("Value " + value + " was not found.");
        }
    }

    // Deletion Method
    public void deleteDLL(int index) {

        if (head == null) {
            System.out.println("DLL does not exist");
        } else if (index < 0 || index >= size) {
            System.out.println("Index " + index + " is out of bounds for deletion");
        } else {
            if (index == 0) {
                // Case 1: delete the head
                head.next.prev = null;
                head = head.next;
            } else if (index == size - 1) {
                // Case 2: delete the tail
                // (This is much simpler in a doubly linked list)
                tail.prev.next = null;
                tail = tail.prev;
            } else {
                // Case 3: delete from between head and tail
                DoublyNode curNode = head.next;

                // First, find the node before the one we want to delete
                for (int i = 1; i < index - 1; i++) {
                    curNode = curNode.next;
                }

                // The next node is the node to be deleted
                // Trim it out by connecting the nodes around it
                curNode.next = curNode.next.next;
                curNode.next.prev = curNode;
            }

            size -= 1;
        }
    }

    // Delete entire DLL
    // If no index is specified, empty the entire DLL
    public void deleteDLL() {
        head = null;
        tail = null;
        size = 0;
    }

}
