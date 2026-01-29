class Solution {
    public int minOperations(int n) {
        long x=n;
        int counter=0;

        while(x!=0){
            if(x%2==0){
                x = x/2;
            } else {
                if(x==1){
                    counter++;
                    break;
                }
                if(x%4==1){
                    x=x-1;
                } else {
                    x=x+1;
                }
                counter++;
            }
        }
        return counter;
    }
}