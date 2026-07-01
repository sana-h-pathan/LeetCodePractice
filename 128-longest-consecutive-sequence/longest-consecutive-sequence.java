class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int count =0;
        int maxLength=0;
        for(int num: set){
            if(!set.contains(num-1)){
                count=0;
                while(set.contains(num)){
                    num++;
                    count++;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
    }
}