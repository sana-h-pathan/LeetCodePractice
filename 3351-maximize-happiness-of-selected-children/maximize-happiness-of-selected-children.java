class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int count=0;
        long sum=0;
        Arrays.sort(happiness);
        int n=happiness.length-1;
        while(count<k){
            if(happiness[n]-count>0){
                sum+=happiness[n]-count;
            }
            else
                break;
            n--;
            count++;
        }
        return sum;
    }
}