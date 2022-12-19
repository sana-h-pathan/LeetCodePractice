package practice.easy;

import java.util.HashSet;

public class ContainDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet numSet=new HashSet();
        for(int i=0;i<nums.length;i++){
            if(!numSet.contains(nums[i]))
                numSet.add(nums[i]);
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainDuplicate containDuplicate=new ContainDuplicate();
        System.out.println(containDuplicate.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}
