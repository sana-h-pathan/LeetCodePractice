class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int maxCount=0;
        for(int num: set){
            if(!set.contains(num-1)){
                int count=0;
                while(set.contains(num)){
                    num++;
                    count++;
                }
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
}