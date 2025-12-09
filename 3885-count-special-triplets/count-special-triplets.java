class Solution {
    public int specialTriplets(int[] nums) {
        int mod = 1_000_000_007;
        int result = 0;
        Map<Integer, Integer> c1 = new HashMap<>();
        Map<Integer, Integer> c2 = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                result = (result + c2.getOrDefault(num / 2, 0)) % mod;
            }
            c2.put(num, (c2.getOrDefault(num, 0) + c1.getOrDefault(num * 2, 0)) % mod);
            c1.put(num, c1.getOrDefault(num, 0) + 1);
        }
        return result;
    }
}


