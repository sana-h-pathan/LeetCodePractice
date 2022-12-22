package practice.easy;

public class SquareRoot {
    int mySqrt(int x) {
        int  r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return  r;
    }

    public static void main(String[] args) {
        SquareRoot squareRoot=new SquareRoot();
        System.out.println(squareRoot.mySqrt(115));
        System.out.println(squareRoot.mySqrt(81));
    }
}
