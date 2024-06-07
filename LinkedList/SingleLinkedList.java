package LinkedList;
public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    // Cretae a linked List
    public Node createLinkedList(int nodeValue){
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    //insert into a linked list
        //0. If link list doesn't
        //1. inserting at the begining
        //2. Inserting at the ending
        //3. Insert anywhere
    public void insertInLinkedList(int nodeValue, int location){
        Node node = new Node();
        node.value = nodeValue;
        if(head == null) {
            createLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            tail.next = node;
            node.next = null;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            // 2. The new node will need to point to the node currently at this position
            // (existing nodes past this point will be pushed toward the 'tail')
            node.next = tempNode.next;
            // 2. Corrected an assignment and removed redundant variable
            tempNode.next = node;

        }
        size++;
    }

    //Traverse a Linked List
    public void traverseLinkedList(){
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("\n");
    }

    //Search for a Node

    public boolean searchNode (int nodeValue){
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++){
                if (tempNode.value == nodeValue){
                    System.out.println("Found the node: " + tempNode.value + " at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }


    //Deleting a Node from a Single linked List
    //0. If link list doesn't
    //1. deleting at the begining
    //2. deleting at the ending
    //3. deleting anywhere in the list

    // 1. Complete the delete method
    public void deleteFromLocation(int location) {
        // Not required by the assignment, but I decided to use try/catch in case an index outside the length of the SLL
        try {
            // Case 0: the list has no nodes
            if (head == null)
                System.out.println("SLL does not exist.");
            else if (location < 0 || location >= size)
                throw new IndexOutOfBoundsException("SLL has no node at location " + location);
            // Case 1: remove from location 0 (the head)
            else if (location == 0) {
                head = head.next;

                // This could result in no nodes remaining
                // Show a warning if this happens
                if (head == null)
                    System.out.println("Warning: SLL no longer exists.");
            }
            // Case 2: remove the tail
            else if (location == size - 1) {
                Node curNode = head;
                int index = 0;

                // We'll need to use a loop to find the node before the tail
                while (index < location - 1) {
                    curNode = curNode.next;
                    index++;
                }

                // Remove the tail from the LinkedList, and make the current node the new tail
                curNode.next = null;
                tail = curNode;
            }
            // Case 3: delete from anywhere [else] in the list
            else {
                Node curNode = head;
                int index = 0;

                // We'll need to use a loop to find the node before the specified location
                while (index < location - 1) {
                    curNode = curNode.next;
                    index++;
                }

                curNode.next = curNode.next.next;
            }

            size--;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }
    }
}
