class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0;
        int totalGas = 0;
        for(int i=0;i<gas.length;i++){
            totalCost+=cost[i];
            totalGas+=gas[i];
        }
        if(totalCost>totalGas){
            return -1;
        }
        int idx = 0;
        int totalValue = 0;
        for(int i=0;i<gas.length;i++){
            totalValue+=gas[i]-cost[i];
            if(totalValue<0){
                idx= i+1;
                totalValue=0;
            }
        }
        return idx;
    }
}