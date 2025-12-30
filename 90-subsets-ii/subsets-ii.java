class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void backTrack(int[] nums, int idx, List<List<Integer>> result, List<Integer> temp){
        result.add(new ArrayList<>(temp));
        Integer prev = null;
        for(int i=idx;i<nums.length;i++){
            if(prev!=null && prev == nums[i]){
                continue;
            }
            temp.add(nums[i]);
            backTrack(nums, i+1, result, temp);
            temp.remove(temp.size()-1);
            prev = nums[i];
        }
    }
}