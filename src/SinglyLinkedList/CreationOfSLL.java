package SinglyLinkedList;



public class CreationOfSLL {
    public Node head;
    public Node tail;
    public int size;



    public Node nextNodeRef(int nodeValue){
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void InsertAlgorithmSLL(int location, int nodeValue){
        Node node = new Node(); //create new node, this is created locally.
        node.value = nodeValue; //add value to be passed on

        if (head==null){ //check if list is empty, if so, call next nodeRef to create node instance and add value
            nextNodeRef(nodeValue);
            return;
        } else if (location == 0) { //else if the location is at the beginning,
            node.next = head;   //set the new nodes next to the current head
            head = node; // update the head to the new one
        } else if (location >= size){ // if the location is at or beyond the end
            node.next = null; //new node will be the last, so it is set to null
            tail.next = node; // current tails next should point to the new node
            tail = node;     // update tail to the new node
        } else { //inserting in the middle
            Node tempNode = head; //start from the head
            int index = 0; // initialize index
            while (index < location -1){ // iterate through the node just before desired location
                tempNode = tempNode.next; // move to the next node
                index++; // increment index
            }
            Node nextNode = tempNode.next; // tempNode is the node before our desired location, tempnode.next points to the desired location "NextNOde"
            tempNode.next = node; // tempNode.next now points to our new node we are inserting, which becomes our new desired location,
            nextNode = node.next; // the new nodes next now points to the nextNode in the link.
        }
        size++;
    }
    public void printList() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");

        System.out.println("Head: " + (head != null ? head.value : "null"));
        System.out.println("Tail: " + (tail != null ? tail.value : "null"));
        System.out.println("Size: " + size);
        System.out.println();
    }

    public void traversalSLL(){

        if(head == null){
            System.out.println("Linked list is empty");
        } else {
            Node tempNode = head; //start from the head
            for(int i = 0; i < size; i++){
                System.out.println(tempNode.value);
                if (i != size - 1){
                    System.out.println( " -> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }
    public boolean searchNodeVal(int nodeValue){
        if(head != null){
            Node current = head;
            for(int i = 0; i < size; i++){
                if (nodeValue == current.value){
                    System.out.println(current.value+ " node value found at index : "+i+"");
                    return true;
                }
                current = current.next;
            }
        }
        System.out.println("Node value: '"+ nodeValue +"' not found");
        return false;
    }
    //BruteForce Approach
    public void deleteValSLL(int location) {
        if (head == null){
            System.out.println("SLL is empty");
            return;
        } else if (location == 0) { //if element is at first location
            head = head.next;// set head to second node, effectively removing the first node.
            size--; //reduce size
            if(size == 0){ // If the list becomes empty set tail to null
                tail = null;
            }
        } else if (location >= size) { //if element is at tail
            Node tempNode = head; //create a temp node to start at head
            for (int i = 0; i < size - 1; i++) { //iterate through the LL until u reach the second to last element
                tempNode = tempNode.next; //in each iteration we move through the LL
            }
            if (tempNode == head) { //if the list had one node, set both head and tail to null, decrement and return
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = null; //otherwise, set tempNode to null, effectvely removing the last node.
            tail = tempNode; //update tail to tempNode, and decrement
            size--;
        }else { //if node is int the middle
            Node tempNode = head; //start at head
            for (int i=0; i< location -1; i++){ //iterate through list until you find the node just before the one u want to delete
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next; //bypass the node to be deleted and decrement
            size--;

        }
    }

    public void deleteALLSLL(){
        head = null;
        tail = null;
        System.out.println("SLL Deleted Successfully");
    }

//    public boolean insert(int data, int index){
//        Node node = new Node();
//        node.value = data;
//
//        if (head == null){
//            nextNodeRef(data);
//        }
//
//    }

}

