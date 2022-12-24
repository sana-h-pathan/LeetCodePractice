package practice.medium;

public class ReverseInteger {
    public int reverse(int input) {
        long reversed=0;
        while(input!=0){
            reversed=reversed*10+input%10;
            input /=10;
        }
        if(reversed<Integer.MIN_VALUE || reversed>Integer.MAX_VALUE) {
            System.out.println(reversed);
            return 0;
        }
        return (int)reversed;
    }
    public static void main(String[] args) {
        ReverseInteger reverseInteger=new ReverseInteger();
        reverseInteger.reverse(1534236469);
    }
}
