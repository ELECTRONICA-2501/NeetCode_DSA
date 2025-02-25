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
    int beginningOfQueue;

    public QueueArray(int size){
        this.arr = new int[size];
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
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


}
