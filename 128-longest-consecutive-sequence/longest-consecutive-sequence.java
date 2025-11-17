class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int count=0;
        int maxLen=0;
        for(int num: set){
            if(!set.contains(num-1)){
                count=1;
                int curr=num+1;
                while(set.contains(curr)){
                    count++;
                    curr++;
                }
                maxLen=Integer.max(count,maxLen);
            }
        }
        return maxLen;
    }
}