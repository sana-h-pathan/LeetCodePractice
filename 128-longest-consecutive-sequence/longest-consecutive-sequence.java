class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet=new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }
        int count=0;
        int max=0;
        for(int num: numSet){
            if(!numSet.contains(num-1)){
                count=1;
                int curr=num+1;
                while(numSet.contains(curr)){
                    count++;
                    curr++;
                }
                max=Integer.max(max,count);
            }
        }
        return max;
    }
}