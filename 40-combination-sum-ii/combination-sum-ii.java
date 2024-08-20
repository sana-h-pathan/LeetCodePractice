class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates,target,0,result,new ArrayList<>());
        return result;
    }
    private void backTrack(int[] candidates, int target, int idx, List<List<Integer>> result,  List<Integer> temp){
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(target<0)
            return;
        int prev=-1;
        for(int i=idx;i<candidates.length;i++){
            if(candidates[i]==prev){
                continue;
            }
            if(candidates[i]>target)
                continue;
            temp.add(candidates[i]);
            backTrack(candidates, target-candidates[i], i+1, result, temp);
            temp.remove(temp.size()-1);
            prev=candidates[i];
        }

    }
}