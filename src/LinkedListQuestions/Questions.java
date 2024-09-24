package LinkedListQuestions;

public class Questions {

    public Node head;
    public Node tail;
    public int size;
    public LinkedList N;
    public void deleteDupes(LinkedList linkedList){
        //two pointer approach --------------
        /*Outer loop: use on pointer called current to travese the list from the start
        * Inner loop: use a second pointer called runner to check all subsequent nodes for duplicates of the current node
        * Remove duplicates: if a duplicate is found update the pointer to bypass the duplicate node */
        if(linkedList.head == null) {
            return;
        }

        for(Node currentNode = linkedList.head; currentNode != null; currentNode = currentNode.next){
            for( Node runnerNode = currentNode; runnerNode.next != null; /* this part is empty because increment expression is written in body*/){
                if (runnerNode.next.value == currentNode.value){
                    runnerNode.next = runnerNode.next.next;
                } else {
                    runnerNode = runnerNode.next;
                }
            }
        }
    }
    //solution explained with example
    /*Example Walkthrough with a Sample List
        Consider the following linked list: 1 -> 2 -> 3 -> 2 -> 4 -> 1

        Initial Setup:

        currentNode starts at 1.
        runnerNode also starts at 1.
        First Iteration:

        currentNode = 1, runnerNode = 1.
        Check runnerNode.next (2) == currentNode (1): No duplicate, move runnerNode.
        Check runnerNode.next (3) == currentNode (1): No duplicate, move runnerNode.
        Check runnerNode.next (2) == currentNode (1): No duplicate, move runnerNode.
        Check runnerNode.next (4) == currentNode (1): No duplicate, move runnerNode.
        Check runnerNode.next (1) == currentNode (1): Duplicate found, remove runnerNode.next.
        The list now looks like: 1 -> 2 -> 3 -> 2 -> 4.

        Second Iteration:

        currentNode = 2, runnerNode = 2.
        Check runnerNode.next (3) == currentNode (2): No duplicate, move runnerNode.
        Check runnerNode.next (2) == currentNode (2): Duplicate found, remove runnerNode.next.
        The list now looks like: 1 -> 2 -> 3 -> 4.

        Third Iteration:

        currentNode = 3, runnerNode = 3.
        Check runnerNode.next (4) == currentNode (3): No duplicate, move runnerNode.
        Fourth Iteration:

        currentNode = 4, runnerNode = 4.
        Since runnerNode.next is null, the inner loop terminates.
        End of List:

        currentNode becomes null, and the outer loop terminates.
        The final list after removing duplicates: 1 -> 2 -> 3 -> 4.

        Summary
        Outer Loop: Traverses each node using currentNode.
        Inner Loop: Checks subsequent nodes for duplicates using runnerNode.
        Duplicate Check: If a duplicate is found, it removes the duplicate node by updating pointers.
        Increment: Moves runnerNode to the next node if no duplicate is found, otherwise removes the duplicate and rechecks the new runnerNode.next.*/

    //2nd question
    public Node nth(LinkedList linkedList,int N) {
        if (head == null) {
            return null;
        }
        Node currentNode = head;
        for(int i = 0; i < size - N - 1; i++){
            currentNode = currentNode.next;
        }
        return currentNode.next;
    }

    /*
    Singly Linked List - Rotate
Implement the following on the SinglyLinkedList class:

Rotate

This function should rotate all the nodes in the list by some number passed in. For instance, if your list looks like 1 -> 2 -> 3 -> 4 -> 5 and you rotate by 2, the list should be modified to 3 -> 4 -> 5 -> 1 -> 2. The number passed in  to rotate can be any integer.

Time Complexity : O(N), where N is the length of the list.

Space Complexity : O(1)

Examples

(Note: you do not need to re-implement push, the test will be provided with it)

singlyLinkedList = SinglyLinkedList()
singlyLinkedList.push(5)  // Success
singlyLinkedList.push(10)  // Success
singlyLinkedList.push(15)  // Success
singlyLinkedList.push(20)  // Success
singlyLinkedList.push(25)  // Success

singlyLinkedList.rotate(3)

singlyLinkedList.head.value  // 20
singlyLinkedList.head.next.value   // 25
singlyLinkedList.head.next.next.value  // 5
singlyLinkedList.head.next.next.next.value // 10
singlyLinkedList.head.next.next.next.next.value // 15
singlyLinkedList.tail.value // 15*/

    //answer with explanation

    public String rotate(int number){
        int index = number; //store the number passed in an index
        if (number < 0){ //
            index = number + size;
        }
        if(index < 0 || index >= size){
            return null;
        }
        if(index == 0){
            return "No rotation";
        }

        //start at the head;
        Node prevNode = head;
        for (int i = 0; i < index - 1; i++){
            prevNode = prevNode.next;
            //go through it until you reach the end.
        }
        if(prevNode == null){
            return "No rotation";
        }
        tail.next = head; //circular linked list now. last element points to head.
        head = prevNode.next; // the head now points at the last node
        tail = prevNode; //tail now is the prevNode
        prevNode.next = null;
        return "success";

    }
}
