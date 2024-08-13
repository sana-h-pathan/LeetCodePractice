class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,result,new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums, int target, int idx, List<List<Integer>> finalList,List<Integer> subList){
        if(target<0 )
            return;
        if(target==0){
            finalList.add(new ArrayList<>(subList));
            return;
        }
        
        int prev=-1;
        for(int i=idx;i<nums.length;i++){
            if(nums[i]==prev)
                continue;
            if(nums[i]>target)
                continue;
            subList.add(nums[i]);
            backtrack(nums, target-nums[i], i+1, finalList, subList);
            subList.remove(subList.size()-1);
            prev=nums[i];
        }
    }
}
