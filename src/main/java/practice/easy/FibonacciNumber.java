package practice.easy;

public class FibonacciNumber {
    public int fib(int n) {
        int[] fibNumber=new int[n+1];
        if(fibNumber[n] != 0)
            return fibNumber[n];
        if(n<=1)
            return n;
        fibNumber[n] = fib(n-1) + fib(n-2);
        return fibNumber[n];
    }

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber=new FibonacciNumber();
        System.out.println(fibonacciNumber.fib(9));
        System.out.println(fibonacciNumber.fib(11));
    }
}
