package practice.medium;

public class ReverseInteger {
    public int reverse(int x) {
        int rem = 0 ;
        int result = 0;
        int next = 0;
        while (x !=0){
            rem = x%10;
            next = result*10 + rem;
            if((next-rem)/10 != result)
                return 0;
            result = next;
            x = x/10;
        }
        return result;
    }
    public static void main(String[] args) {
        ReverseInteger reverseInteger=new ReverseInteger();
        reverseInteger.reverse(432);
    }
}
