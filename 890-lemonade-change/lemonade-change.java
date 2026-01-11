class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveD = 0;
        int tenD = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                fiveD++;
            } else if(bills[i]==10){
                tenD++;
                if(fiveD>0){
                    fiveD--;
                } else {
                    return false;
                }
            } else {
                if(tenD>0 && fiveD>0){
                    tenD--;
                    fiveD--;
                } else {
                    if(fiveD>=3){
                        fiveD-=3;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}