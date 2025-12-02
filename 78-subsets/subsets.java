class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(nums, result, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums,  List<List<Integer>> result, int idx, List<Integer> currPath){
        //base case
        if(idx==nums.length){
            result.add(new ArrayList<>(currPath));
            return;
        }
        //not choose
        backtrack(nums, result, idx+1, currPath);
        //choose
        currPath.add(nums[idx]);
        backtrack(nums, result, idx+1, currPath);
        currPath.remove(currPath.size()-1);
    }
}