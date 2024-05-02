class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int result=-1;
        for(int num : nums){
            if(set.contains(num*-1))
                result=Math.max(Math.abs(num),result);
            set.add(num);
        }
        return result;
    }
}