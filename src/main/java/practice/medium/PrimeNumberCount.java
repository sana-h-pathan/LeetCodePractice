package practice.medium;

import java.util.Arrays;

public class PrimeNumberCount {
    public int countPrimes(int n) {
        boolean[] dp = new boolean[n];
        Arrays.fill(dp, true);
        int count = 0;
        for(int  i = 2; i < n; i++){
            if(dp[i]){
                count++;
                for(int j = 2; j*i < n; j++){
                    dp[i*j] = false;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PrimeNumberCount primeNumberCount=new PrimeNumberCount();
        System.out.println(primeNumberCount.countPrimes(16));
    }
}
