package practice.easy;

import java.util.Arrays;

public class RunningSum {
    public int[] runningSum(int[] nums) {
        int i=1;
        while (i<nums.length){
            nums[i]+=nums[i-1];
            i++;
        }
        return nums;

    }

    public static void main(String[] args) {
        RunningSum runningSum=new RunningSum();
        System.out.println(Arrays.toString(runningSum.runningSum(new int[]{1,2,3})));
    }
}
