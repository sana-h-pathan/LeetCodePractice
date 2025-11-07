class Solution {
//TC=O(n)
//SC=O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i]);
            if(nums[idx-1]>0)
                nums[idx-1]*=-1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                missingNumbers.add(i+1);
            }else{
                nums[i]*=-1;
            }
        }
        return missingNumbers;
    }
}