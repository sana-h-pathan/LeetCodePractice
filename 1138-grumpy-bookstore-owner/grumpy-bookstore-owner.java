class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int i=0;
        int j=0;
        int maxIdx = 0;
        int custCnt=0;
        int maxCust=0;
        int cust=0;
         while(j<customers.length){
           
            if(grumpy[j]==1){
                custCnt+=customers[j];
            } else{
                cust+=customers[j];
            }
            if(j-i+1==X){
                if(custCnt>maxCust){
                    maxIdx=i;
                    maxCust=custCnt;
                }
                if(grumpy[i]==1)
                    custCnt-=customers[i];
                i++;
            }
            j++;
        }
        return cust+maxCust;
    }
}