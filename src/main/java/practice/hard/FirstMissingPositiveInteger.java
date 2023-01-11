package practice.hard;

import java.util.*;

public class FirstMissingPositiveInteger {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Set<Integer> current = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            current.add(nums[i]);
        }
        int i = 1;
        for(; i < Integer.MAX_VALUE; i++){
            if(!current.contains(i))
                return i;
        }
        return i;
    }

        public static void main(String[] args) {
        FirstMissingPositiveInteger fis=new FirstMissingPositiveInteger();
        System.out.println(fis.firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}
