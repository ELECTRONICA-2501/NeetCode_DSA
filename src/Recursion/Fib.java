package Recursion;

public class Fib {

    public int fib(int n) {
        // simple recursive call for fibonacci series
        //011235813 etc
        //first base case
        if (n <= 1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
}
