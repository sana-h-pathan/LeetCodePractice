class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, target, result, new ArrayList<>());
        return result;
    }
    private void helper1(int[] candidates, int idx, int target, List<List<Integer>> result, List<Integer> temp){
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(target<0 || idx==candidates.length){
            return;
        }
        helper(candidates, idx+1, target, result, temp);
        temp.add(candidates[idx]);
        helper(candidates, idx, target-candidates[idx], result, temp);
        temp.remove(temp.size()-1);
    }

    private void helper(int[] candidates, int idx, int target, List<List<Integer>> result, List<Integer> temp){
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            temp.add(candidates[i]);
            helper(candidates, i, target-candidates[i], result, temp);
            temp.remove(temp.size()-1);
        }
    }
}