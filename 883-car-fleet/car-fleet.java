class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int res = 0;
        double[] result = new double[target];
        for (int i = 0; i < position.length; i++)
            result[position[i]]= (double)(target - position[i]) / speed[i];
        double prev = 0.0;
        for (int i = target-1; i >=0 ; i--){
            double cur = result[i];
            if (cur > prev){
                prev = cur;
                res++;
            }
        }
        return res; 
    }
}