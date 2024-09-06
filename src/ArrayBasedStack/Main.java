package ArrayBasedStack;

public class Main {
    public static void main(String[] args) {
        Stack newStack = new Stack(4);
        newStack.push(1);
        newStack.push(2);
        newStack.push(3);
        newStack.push(4);
        int result = newStack.pop();
        System.out.println(result);
        int result1 = newStack.pop();
        System.out.println(result1);
        int result2 = newStack.peek();
        System.out.println(result2);
    }
}
