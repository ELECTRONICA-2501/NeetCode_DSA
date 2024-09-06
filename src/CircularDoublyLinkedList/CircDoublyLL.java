package CircularDoublyLinkedList;

import com.sun.security.jgss.GSSUtil;

public class CircDoublyLL {
    public Node head;
    public Node tail;
    public int size;

    public Node CreateCDLL(int nodeValue){
        head = new Node(); //create a new node object and assign it to head.
        Node newNode = new Node(); //create another new node object and assign it to newNode
        newNode.value = nodeValue; // set the value of the newNode to the given nodevale

        head = newNode; //set head to new node same for tail
        tail = newNode;

        newNode.next = newNode;// point to the next ref
        newNode.prev = newNode;// point to the prev ref

        size = 1; // set the size to 1
        return head; // return the head of the list.

    }

    public void insertAlgoDCLL(int location, int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        if (head == null) {
            CreateCDLL(nodeValue);
            System.out.println("new node created.");
            return;
        } else if (location == 0) {
            newNode.prev = tail; //new nodes prev ref pointint to tail, in this case its a circular linked list newNode myst point to last node and vice versa
            newNode.next = head; //new nodes next ref points to head ref, which is the original node
            head.prev = newNode; // backwards link between orignial node and newNode.
            head = newNode; //head now reference newNode
            tail.next = newNode; //
            return;
        } else if (location >= size) {
            newNode.next = head; //new node points to what the current head is referenceing, first node
            newNode.prev = tail; // new node points to tails , the original last node.
            tail.next = newNode; // lastnode references the newNode now
            tail = newNode; // tail not is the new node
            head.prev = newNode; // first nodes. prev refernce points to the last tail, completing circular dll.
            return;
        } else {
            Node currentNode = head; //start at head
            for (int i = 0; i < location - 1; i++) {
                currentNode = currentNode.next; //loop
            }
            newNode.next = currentNode.next;
            newNode.prev = currentNode;
            currentNode.next = newNode;
            currentNode.next.prev = newNode;
        }
        size++;
    }
    public void TraversalCDLL() {
        if (head == null) {
            System.out.println("CDLL doesnt exist");
        } else {
            Node currentNode = head;
            for (int i = 0; i < size; i++) {
                System.out.println(currentNode.value);
                if (i != size - 1) {
                    System.out.println("-->");
                }
                currentNode = currentNode.next;
            }
        }
    }

    public void DeleteValDCLL(int location){
        if(head == null){
            System.out.println("Nothing to delete");
            return;
        } else if(location == 0){
            if(size == 1){
                head.next = head.prev = null; //self reference since this is circular/doubly
                head = tail = null; // set tail/head pointers to null
                size--;
                return;
            } else {
                head = head.next;//accessing the second node
                tail.next = head; //link between last node and second node.
                head.prev = tail; //link between second node to last node
                size--;
            }

        } else if (location >= size){
            if(size == 1){
                head.next = head.prev = null;
                head = tail = null;
                size--;
                return;
            } else {
                tail = tail.prev; // assign tail to the second to last node
                tail.next = head; // since our new tail is the second to last node, set that nodes next reference to point to head, completing circular function
                head.prev = tail; // head.prev now points at new tail, completing backwards link in circular function
                size--;
            }
        } else {
            Node currentNode = head;
            for(int i =0; i< location -1; i++){
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
            currentNode.next.prev =currentNode;
            size--;
        }


    }
    public void deleteEntireDCLL(){
        tail.next = null; // delete reference between first node and last node
        head.prev = null; // deletes reference between first and last node.
        // now u have gotten rid of ciruclar function and now have a doubly linked List
        Node currentNode = head;
        for (int i = 0; i < size; i++){
            currentNode.prev = null;
            currentNode.next = null;
            currentNode = currentNode.next;
        }
        tail = head = null;
    }
    public boolean searchDCLL(int nodeValue){
        if(head != null){
            Node currentNode = head;
            for (int i = 0; i < size; i++) {
                if( (nodeValue == currentNode.value) || (currentNode == tail) ){
                    System.out.println("Node value: "+ nodeValue + " found at index: (i) = " + i);
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        System.out.println("DCLL doesnt exist");
        return false;
    }

}
