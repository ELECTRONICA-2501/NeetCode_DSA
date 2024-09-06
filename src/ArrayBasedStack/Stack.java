package ArrayBasedStack;

public class Stack {
    //array based stack. Fixed size.
    int[] arr;
    int topOfStack;

    public Stack(int size){
        this.arr = new int[size];
        this.topOfStack = -1; //no element in stack yet. when you push an element
        //to the top of the stack its index will be 0 cuz arrays start at zero.
        System.out.println("The stack is created with size of: " + size );
    }

    public boolean isEmpty(){
        if (topOfStack == -1){
            System.out.println("Stack is empty");
            return true;
        }else {
            return false;
        }
    }

    public boolean isFull(){
        if(topOfStack == arr.length-1){
            System.out.println("Stack is full");
            return true;
        } else {
            return false;
        }
    }

    public void push(int value){
        if(isFull()){
            System.out.println("stack is full");
        } else {
            arr[topOfStack + 1] = value; //insert the value at the position about the current top of stack
            topOfStack++; //increment the top stack to point to the new topofstack
            System.out.println("value successfully inserted. Stack value: " + value);
        }
    }
    public int pop(){
        //should delete and return last element from stack
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1; //return negative one to indicate stack is empty
        }else{
            int topStack = arr[topOfStack]; //topStack stores the value at the top of the stack;
            topOfStack--; // decrement the topstack to tremove the top element from the stack

            return topStack; // return the value that was at the top of the stack
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }else {
            return arr[topOfStack];
        }
    }

    public void deleteStack() {
        arr = null;
        System.out.println("The stack has been deleted");
    }
}
