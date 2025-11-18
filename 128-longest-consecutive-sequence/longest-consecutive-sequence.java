class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int currLen=0;
        int maxLen=0;
        for(int num: set){
            if(!set.contains(num-1)){
                int currNum=num;
                currLen++;
                while(set.contains(num+1)){
                    num++;
                    currLen++;
                }
            }
            maxLen=Integer.max(currLen, maxLen);
            currLen=0;
        }
        return maxLen;
    }
}