package CIrcularSinglyLinkedList;

public class CircularSLL {
    public Node head;
    public Node tail;
    public int size;
    public Node createCSLL(int nodeValue){
        head = new Node();
        Node node = new Node();
        node.value  = nodeValue;
        //reference to itself
        node.next = node;
        head = node;
        tail = node;
        size = 1;
        return head;
    }
    public void InsertCSLL(int nodeValue, int location) {
        Node newNode = new Node(); //create new node via node class.
        newNode.value = nodeValue; // set the nodeValues parameter equal to node.value
        if(head == null)
        { // if LL is empty
            createCSLL(nodeValue); // create new node
            System.out.println("new node created");
        }
        else if(location == 0) // if we want to insert at beginning of LL
        {
            newNode.next = head; //set the newNodes next = to what the head is pointed to
            head = newNode; // set the head = to the new node
            tail.next = head; // update tail.next reference to point to the new head.
        }
        else if(location >= size) // if we want to insert at the end of LL
        {
            newNode.next = tail.next; // NewNode will point to the head,  aka what tail.next is referencing
            tail.next = newNode;    // set tail.next to reference the new Node.
            tail = newNode;     // set tail equal to new node.
        }
        else // if we want to insert in the middle of our list.
        {
            Node currentNode = head; //create new node
            for(int i = 0; i < location - 1; i++){ //loop through until we reach before our desired location (location -1)
                currentNode = currentNode.next; // step through LL
            }
            newNode.next = currentNode.next; //have the newNodes reference point at what the currentNode reference is
            currentNode.next = newNode; // update the current node reference to point at the newly created node.
        }
    size++;
    }

    public void traversalOfCSLL() {
        if (head != null) {
            Node currentNode = head;
            for (int i = 0; i < size; i++) {
                System.out.println(currentNode.value);
                if (i != size - 1) {
                    System.out.println(" --> ");
                }
                currentNode = currentNode.next;
            }
        } else {
            System.out.println("CSLL Doesnt exist");
        }
    }

    public boolean searchingInCSSL(int nodeValue){
        //linear search, can create infinite loop
        if(head != null){
            Node currentNode = head;//start at head.
            //currentNode.value = nodeValue;
        for(int i =0; i<size; i++){
            if(nodeValue == currentNode.value){
                System.out.println("Node value " + currentNode.value + " found at index : "+ i);
                return true;
                }
            currentNode = currentNode.next; //keep looping through LL
            }
        }
        System.out.println("Node not found");
        return false;
    }

    //deletion algorithm
    public void DeleteCSLL(int location){
        if(head == null){
            System.out.println("Nothing to delete");
        } else if (location ==0) {
            head = head.next;
            tail.next = head;
            size--;
            if(size == 0){
                head = tail = null;
                head.next = null;
                size--;
            }
        } else if (location >= size) {
            Node currentNode = head;
            for (int i = 0; i < location -1; i++){
                currentNode = currentNode.next;
            }
            if (currentNode == head){
                head = tail = null;
                currentNode.next = null;
            } else {
                tail = currentNode;
                currentNode.next = head;
            }
            size--;
        } else {
            Node currentNode = head;
            for (int i = 0; i < location - 1; i++){
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
            size--;
        }
    }

    public void deleteALLofCSLL(){
        if(head == null){
            System.out.println("CSLL Does not exist");
        } else {
            head = null;
            tail.next = null;
            tail = null;
            System.out.println("CSLL has been deleted");
        }
    }
}


