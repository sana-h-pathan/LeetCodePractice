package practice.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSums {
    public static void main(String[] args) {
        TwoSums twoSums=new TwoSums();
        twoSums.twoSum(new int[]{2,7,11,15},17);
    }
    public int[] twoSum(int[] nums, int target) {
        int[] result={0,0};
        Map<Integer,Integer> allNumber=new HashMap<Integer,Integer>();
        Set<Integer> allNumbers=new HashSet<>();
        int otherElement=0,i=0;
        for(i = 0; i < nums.length; i++)
        {
            otherElement = target-nums[i];
            if(allNumber.containsKey(otherElement))
            {
                result[0] = allNumber.get(otherElement);
                result[1] = i;
                break;
            }
            else allNumber.put(nums[i],i);
        }
        return result;
    }
}
