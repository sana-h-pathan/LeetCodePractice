class Solution {
    public int findMaxLength(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // sum 0 seen before start

        int sum=0;
        int maxLength=0;
        int i=0;

        while(i<n){
            if(nums[i]==0){
                sum += -1;
            }else{
                sum += 1;
            }

            if(map.containsKey(sum)){
                maxLength = Math.max(maxLength, i - map.get(sum));
            }else{
                map.put(sum, i); // store first occurrence only
            }
            i++;
        }
        return maxLength;
    }
}
