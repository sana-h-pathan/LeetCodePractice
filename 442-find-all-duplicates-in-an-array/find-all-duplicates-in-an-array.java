class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result=new ArrayList<>();
        for (int num : nums) {
            if (nums[Math.abs(num)-1] < 0) { // seen before
                result.add(Math.abs(num));
            }
            nums[Math.abs(num)-1] *= -1;
        }
        return result;
    }
}