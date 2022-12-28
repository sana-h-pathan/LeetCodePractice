package practice.medium;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        for(int i = 0; i < gas.length; i++)
            tank += gas[i] - cost[i];
        if(tank < 0)
            return - 1;
        int start = 0;
        int accumulate = 0;
        for(int i = 0; i < gas.length; i++){
            int curGain = gas[i] - cost[i];
            if(accumulate + curGain < 0){
                start = i + 1;
                accumulate = 0;
            }
            else accumulate += curGain;
        }
        return start;
    }

    public static void main(String[] args) {
        GasStation gasStation=new GasStation();
        gasStation.canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2});
    }
}
