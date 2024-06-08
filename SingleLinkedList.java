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
            node.next = tempNode.next;
            tempNode.next = node;
        }
        size++;
    }

    //Traverse a Linked List
    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
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

    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The linked list does not exist");
            return;
        } else if (location == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else if (location >= size) {
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) {
                head = tail = null;
                size--;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public void deleteLinkedList() {
        head = null;
        tail = null;
        size = 0;
        System.out.println("The linked list deleted successfully");
    }

    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.createLinkedList(5);
        sll.insertInLinkedList(10,1);
        sll.insertInLinkedList(15, 2);
        sll.insertInLinkedList(20, 3);
        sll.insertInLinkedList(25, 4);

        System.out.println("Linked List after insertion: ");
        sll.traverseLinkedList();

        System.out.println("Searching for node with value 15: ");
        sll.searchNode(15);

        System.out.println("Deleting node at location 2: ");
        sll.deleteNode(2);
        sll.traverseLinkedList();

        System.out.println("Deleting the entire linked list: ");
        sll.deleteLinkedList();
        sll.traverseLinkedList();
    }

}


