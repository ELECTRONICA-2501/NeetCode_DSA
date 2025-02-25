package Recursion;

public class Factorial {
    // Factorial is example: 5! = 120 = 5*4*3*2*1
    public int factorial(int n){
        if(n <=1 ){
            return n;
        }
        return n*factorial(n-1);
    }
}
