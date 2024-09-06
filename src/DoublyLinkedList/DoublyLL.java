package DoublyLinkedList;
public class DoublyLL {

    public Node head;
    public Node tail;
    public int size;

    public Node createDoublyLL(int nodeValue){
        head = new Node();
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        newNode.prev = null;
        //create link between tail, head & new node
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }
    public void InsertAlgDLL(int nodeValue, int location){
        Node newNode = new Node();
        newNode.value = nodeValue;
        if(head == null)
        {
            createDoublyLL(nodeValue);
            System.out.println("New DLL Created");
            return;
        }
        else if(location == 0)
        {
            newNode.next = head; //new node reference points at what the current head is pointing to
            newNode.prev = null; //first nodes prev reference is always null
            head.prev = newNode; //create backward link between current first node and new node we are inserting
            head = newNode; // head points at newly created node.
        }
        else if (location >= size)
        {
            newNode.next = null;
            tail.next = newNode;
            newNode.prev = tail; //creates backward link between newly created node and current last node.
            tail = newNode;
        }
        else
        {
            Node currentNode = head;
            for(int i = 0; i < location -1; i++){
                currentNode = currentNode.next;
            }
            newNode.prev = currentNode;//create backwards link between new node and current node
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }

    public void Traversal(){
        if(head != null){
            Node currentNode = head;
            for(int i = 0; i < size; i++){
                System.out.println(currentNode.value);
                if(i != size - 1 ){
                    System.out.println(" --> ");
                }
                currentNode = currentNode.next;
            }
        } else {
            System.out.println("DLL Doesnt exist loser");
        }
        //System.out.println("\n");
    }

    public void ReverseTraversal(){
        if(head != null){
            Node currentNode = tail; //start at tails
            for(int i = 0; i < size; i++){
                System.out.println(currentNode.value);
                if (i != size - 1){
                    System.out.println(" <-- ");
                }
                currentNode = currentNode.prev;
            }
        } else {
            System.out.println("DLL Doesnt exist m8!");
        }
        System.out.println("\n");
    }
    public boolean searchDLL(int nodeValue) {
        //check if head exist
        if (head != null) {
            Node currentNode = head;
            for (int i = 0; i < size; i++) {
                if(nodeValue == currentNode.value){
                    System.out.println("Current Node value: " + currentNode.value + "Found at index "+ i);
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        //else return false
        System.out.println("Value not found");
        return false;

    }

    //Deletion
    public void DeleteDLLNode(int location){
        if (head == null){
            System.out.println("DLL doesnt exist");
            return;
        } else if (location == 0) {
            if(size == 1){
                head = tail = null;
            }
            head = head.next;
            head.prev = null;
            return;
        } else if (location >= size) {
            if(size == 1){
                head = tail = null;
            }
            tail = tail.prev;
            tail.next = null;
            return;
        } else {
            Node currentNode = head;
            for(int i = 0; i < location - 1; i++){
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
            currentNode.next.prev = currentNode;
        }
        size--;
    }

    public void DeleteEntireDLL(){

        Node currentNode = head;
        for(int i=0; i < size && currentNode != null; i++){
            //for loop runs for the number of nodes in the list, or until currentnode becomes null, withing the loop next node is saved in nextNode
            //the nurrent nodes prv and next pointers are nullified to detach it, the current node is then updated to move throught the list
            Node nextNode = currentNode.next; //  save the next node
            currentNode.prev = null;
            currentNode.next = null;
            currentNode = nextNode;
        }
        head = tail = null;
        size = 0;
        System.out.println("DLL Deleted");
    }
}
