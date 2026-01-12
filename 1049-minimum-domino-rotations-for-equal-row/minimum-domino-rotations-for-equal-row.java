class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = helper(tops, bottoms, tops[0]);
        if(result==-1 && tops[0]!=bottoms[0]){
            result = helper(tops, bottoms, bottoms[0]);
        }
        return result;
    }
    private int helper(int[] tops, int[] bottoms, int target){
        int aRot=0;
        int bRot=0;
        for(int i=0;i<tops.length;i++){
            if(tops[i]!= target && bottoms[i]!=target){
                return -1;
            }
            if(tops[i]!=target){
                aRot++;
            }
            if(bottoms[i]!=target){
                bRot++;
            }
        }
        return Math.min(aRot, bRot);
    }
}