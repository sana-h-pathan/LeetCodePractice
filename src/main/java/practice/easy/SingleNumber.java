package practice.easy;

import java.util.HashMap;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> numberCount=new HashMap<>();
        for(int n : nums) {
            numberCount.put(n, numberCount.getOrDefault(n, 0) + 1);
        }
        for(int n : nums) {
            if(numberCount.get(n)==1)
                return n;
        }
        return 0;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber=new SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[]{4,1,2,1,2}));
    }
}
