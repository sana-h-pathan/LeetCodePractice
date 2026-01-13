class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean f1=false;
        boolean f2=false;
        boolean f3=false;
        for(int[] t: triplets){
            if(t[0]<=target[0] && t[1]<=target[1] && t[2]<=target[2]){
                if(t[0]==target[0]){
                    f1=true;
                }
                if(t[1]==target[1]){
                    f2=true;
                }
                if(t[2]==target[2]){
                    f3=true;
                }
            }
        }
        return f1&&f2&&f3;
    }
}