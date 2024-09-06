public class Solution {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int roll : rolls) {
            sum = sum + roll;
        }
        int remainingSum = mean * (n + rolls.length) - sum;
        if (remainingSum > 6 * n || remainingSum < n) {
            return new int[0];
        }
        int distributeMean = remainingSum / n;
        int mod = remainingSum % n;
        int[] result = new int[n];
        Arrays.fill(result, distributeMean);
        for (int i = 0; i < mod; i++) {
            result[i]++;
        }
        return result;
    }
}