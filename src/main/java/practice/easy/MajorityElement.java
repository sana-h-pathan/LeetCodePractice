package practice.easy;

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> numberCount=new HashMap<>();
        for(int num:nums){
            numberCount.put(num,numberCount.getOrDefault(num,0)+1);
            if (numberCount.get(num)>nums.length/2) {
                return num;
            }
        }
        return 0;

    }

        public static void main(String[] args) {
        MajorityElement majorityElement=new MajorityElement();
            System.out.println(majorityElement.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
