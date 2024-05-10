class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int num: matchsticks)
            sum+=num;
        if(sum%4!=0)
            return false;
        int side=sum/4;
        int[] square=new int[4];
        Arrays.sort(matchsticks);
        return backtrack(matchsticks,square,side,matchsticks.length-1);
    }
    private boolean backtrack(int[] matchsticks, int[] square, int side, int idx){
        if(idx<0){
            if(square[0]==side && square[1]==side && square[2]==side && square[3]==side)
                return true;
            return false;
        }
        
        for(int i=0;i<4;i++){
            if(matchsticks[idx]+square[i]<=side){
                square[i]+=matchsticks[idx];
                if(backtrack(matchsticks, square, side, idx-1))
                    return true;
                square[i]-=matchsticks[idx];
            }
        }
        return false;
    }
}