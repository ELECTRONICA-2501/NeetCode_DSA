package LLBasedStack;

public class Stack {
    LL linkedList;

    public Stack(){
        linkedList = new LL();
    }
    public void push(int value){
        linkedList.InsertAlgorithmSLL(value, 0);
        System.out.println("Inserted " + value + " in Stack");
    }
    public boolean isEmpty() {
        if ( linkedList.head == null){
            return true;
        }else {
            return false;
        }
    }
    public int pop(){
        int result = -1;
        if(isEmpty()){
            System.out.println("The stack is empty");
            return -1;
        } else {
            result = linkedList.head.value;
            linkedList.deleteValSLL(0);
        }
        return result;
    }
    public int peek(){
        if ( isEmpty()){
            System.out.println("The stack is empty");
            return -1;
        }else {
            return linkedList.head.value;
        }
    }

    public void deleteStack(){
        linkedList.head = null;
        System.out.println("Stack is deleted");
    }
}
