package Queue;
//Queues are Data Structures that follow the FIFO Manner
//whatever element is first goes out first
//
//Can implement a queue in two ways,
//1. Arrays ==> Linear Queue, Circular Queue
//2. LinkedList
public class QueueArray {
    int[] arr;
    int topOfQueue;
    //topOfQueue: Represents the index of the last element added to the queue.
    // It is used to track where the next element should be enqueued.
    int beginningOfQueue;
    //beginningOfQueue: Represents the index of the first element to be removed from the queue.
    // It is used to track where the next element should be dequeued from.

    public QueueArray(int size){
        this.arr = new int[size];
        this.topOfQueue = -1; //topOfQueue being -1 means there are no elements in the queue yet, as it represents the index of the last element added.
        this.beginningOfQueue = -1; //being -1 means there is no starting element in the queue, as it represents the index of the first element to be removed.
        System.out.println("The queue is successfully created with a size of: "+ size);

    }

    public boolean isFull() {
        if (topOfQueue == arr.length - 1) {
            //this will check if the top of the queue is the same as the last element, if so then we are at max capacity
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty(){
        if((beginningOfQueue == -1) || (beginningOfQueue == arr.length)){
            return true;
        }else {
            return false;
        }
    }

    public void enqueue(int value){
        if(isFull()){
            System.out.println("Queue is full");
        } else if (isEmpty()) {
            beginningOfQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Queue initialized and added value at the beginning of queue: "+ value);
        } else {
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Queue added values of " + value + "at the index of : " + topOfQueue);
        }
    }

    public void dequeue(){
        int ElementToBeRemoved;
        if(isEmpty()){
            System.out.println("Queue is already empty");
        } else if (beginningOfQueue == topOfQueue){
            ElementToBeRemoved = arr[beginningOfQueue];
            beginningOfQueue = -1;
            topOfQueue = -1;
            System.out.println("Queue element removed" + ElementToBeRemoved);
            System.out.println("queue pointers read: " + beginningOfQueue + " & top" + topOfQueue);

        } else {
            ElementToBeRemoved = arr[beginningOfQueue];
            //arr[beginningOfQueue] = null;
            beginningOfQueue++;
            System.out.println("queue element removed: " +ElementToBeRemoved );
            System.out.println("queue pointers read: " + beginningOfQueue + " & top" + topOfQueue);
        }
    }
    public int deQueue(){
        if(isEmpty()){
            System.out.println("Shit empty");
            return -1;
        } else {
            int elementToBeRemoved = arr[beginningOfQueue];
            beginningOfQueue++;
            if(beginningOfQueue > topOfQueue){
                topOfQueue = beginningOfQueue = -1;
            }
            return elementToBeRemoved;
        }
    }

    public void peek(){
        int elementatBeginning;
        if( isEmpty()){
            System.out.println("Queue is empty");
        } else {
            elementatBeginning = arr[beginningOfQueue];
            System.out.println("peeky: "+ elementatBeginning);
        }
    }


}
