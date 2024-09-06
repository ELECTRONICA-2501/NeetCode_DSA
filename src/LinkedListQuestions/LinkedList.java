package LinkedListQuestions;

public class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    public void createLL(int nodeValue){
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;

        head = newNode;
        tail = newNode;

        size = 1;

    }

    public void insertNode(int nodeValue){ // this is SLL
        //no need to add location becuase by delaut we will add node in at the end of LL
        Node newNode = new Node();
        newNode.value = nodeValue;
        // create and assign node value

        //if we are pluging in at the end then we must update tail and tail.next value to point to the newNode
        newNode.next = null; // if at the end, in a SLL, tail.next ref will  be null.
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void traversal(){
        Node currentNode = head;
        for(int i = 0; i < size; i++){
            System.out.println("Node value: "+ currentNode.value);
            if( i != size - 1){
                System.out.println(" --> ");
            }
            currentNode = currentNode.next;
        }
        System.out.println( " \n ");
    }
}
