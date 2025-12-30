class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, result, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] candidates, int target, int idx, List<List<Integer>> result, List<Integer> temp){
        if(target<0){
            return;
        }
        if(target==0){
            result.add(new ArrayList<>(temp));
        }
        Integer prev=null;
        for(int i=idx;i<candidates.length;i++){
            if(prev!=null && prev==candidates[i]){
                continue;
            }
            temp.add(candidates[i]);
            backtrack(candidates, target-candidates[i], i+1, result, temp);
            temp.remove(temp.size()-1);
            prev=candidates[i];
        }
    }
}