package practice.medium;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i]+"";
        }
        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        if (strs[0].charAt(0) == '0') return "0";
        String largest = new String();

        for (String s : strs) {
            largest += s;
        }

        return largest;
    }
    public static void main(String[] args) {
        LargestNumber largestNumber=new LargestNumber();
        System.out.println(largestNumber.largestNumber(new int[]{1,2,3,4,5,6,7,8,9,0}));
    }
}
