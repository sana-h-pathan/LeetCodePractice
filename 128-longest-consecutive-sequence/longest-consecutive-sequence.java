class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxLen = 0;
        for(int num: nums){
            set.add(num);
        }
        int count = 0;
        for(int num: set){
            if(!set.contains(num-1)){
                count = 0;
                while(set.contains(num)){
                    count++;
                    num++;
                }
            }
            maxLen = Math.max(count, maxLen);
        }
        return maxLen;
    }
}