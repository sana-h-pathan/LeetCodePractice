class Solution {
    public int minSteps(int n) {
        int result=0;
        int prime=2;
        while(n>1){
            while(n%prime==0){
                result+=prime;
                n=n/prime;
            }
            prime++;
        }
        return result;
    }
}