class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), new HashSet<>());
        return result;
    }
    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, HashSet<Integer> set){
        if(set.size()==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            temp.add(nums[i]);
            backtrack(nums, result, temp, set);
            set.remove(nums[i]);
            temp.remove(temp.size()-1);
        }
    }
}