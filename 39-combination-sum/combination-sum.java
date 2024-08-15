class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(candidates,0,target,result,new ArrayList<>());
        return result;
    }
    private void backtrack(int[] candidates, int idx, int target, List<List<Integer>> result, List<Integer> temp){
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(target<0)
            return;
        for(int i=idx;i<candidates.length;i++){
            temp.add(candidates[i]);
            backtrack(candidates, i, target-candidates[i], result, temp);
            temp.remove(temp.size()-1);
        }
    }
}