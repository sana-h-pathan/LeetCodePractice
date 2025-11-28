class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(candidates,target, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] candidates, int target, int idx, ArrayList<Integer> path, List<List<Integer>> result){
        //base case
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0 || idx==candidates.length)
            return;

        //not choose
        backtrack(candidates, target, idx+1, path, result);
        //choose
        path.add(candidates[idx]);
        backtrack(candidates, target-candidates[idx], idx, path, result);
        path.remove(path.size()-1);

    }
}