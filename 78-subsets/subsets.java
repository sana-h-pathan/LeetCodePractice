class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] nums, int idx, List<Integer> currPath, List<List<Integer>> result ){
        //base condition
        if(idx==nums.length){
            result.add(new ArrayList<>(currPath));
            return;
        }
        //not choose
        backtrack(nums, idx+1, currPath, result);
        //choose
        currPath.add(nums[idx]);
        //recurse
        backtrack(nums, idx+1, currPath, result);
        //backtrack
        currPath.remove(currPath.size()-1);
    }
}