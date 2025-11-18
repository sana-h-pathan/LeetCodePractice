class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num: nums)
            set.add(num);

        int currLen=0;
        int maxLen=0;
        for(int key: set){
            if(!set.contains(key-1)){
                currLen++;
                int currNum=key+1;
                while(set.contains(currNum)){
                    currLen++;
                    currNum++;
                }
            }
            maxLen=Integer.max(currLen, maxLen);
            currLen=0;
        }
        return maxLen;
    }
}