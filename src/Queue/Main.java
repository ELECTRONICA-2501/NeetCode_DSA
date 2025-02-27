package Queue;

public class Main {
    public static void main(String[] args) {
        QueueArray newQueue = new QueueArray(4);

        newQueue.enqueue(1);
        newQueue.enqueue(2);
        newQueue.enqueue(3);
        newQueue.peek();
        System.out.println("current queue" + newQueue);

       // newQueue.dequeue();
        //newQueue.dequeue();
        //newQueue.dequeue();


    }
}
