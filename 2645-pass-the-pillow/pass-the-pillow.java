class Solution {
    public int passThePillow(int n, int time) {
        if (time < n) 
            return time + 1; 
        int cycles = time / (n - 1);
        int remainingTime = time % (n - 1);
        if (cycles % 2 == 0) {
            return remainingTime + 1;
        } else {
            return n - remainingTime;
        }
    }
}