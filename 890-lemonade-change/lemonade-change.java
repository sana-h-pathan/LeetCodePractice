class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveDollar=0;
        int tenDollar=0;
        for(int bill: bills){
            if(bill==5){
                fiveDollar++;
            }
            else if(bill==10){
                if(fiveDollar>0){
                    fiveDollar--;
                    tenDollar++;
                }
                else
                    return false;

            }
            else{
                if(tenDollar>0 && fiveDollar>0){
                    tenDollar--;
                    fiveDollar--;
                }else if(fiveDollar>=3){
                    fiveDollar=fiveDollar-3;
                }
                else
                    return false;
            }
        }
        return true;
    }
}