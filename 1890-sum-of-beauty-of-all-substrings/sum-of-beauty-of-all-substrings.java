class Solution {
    public int beautySum(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> freq = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
                int max = findMax(freq);
                int min = findMin(freq);
                ans += max - min;
            }
        }
        return ans;
    }

    private int findMax(HashMap<Character, Integer> freq) {
        int max = Integer.MIN_VALUE;
        for (int count : freq.values()) {
            max = Math.max(max, count);
        }
        return max;
    }

    private int findMin(HashMap<Character, Integer> freq) {
        int min = Integer.MAX_VALUE;
        for (int count : freq.values()) {
            if (count > 0) {
                min = Math.min(min, count);
            }
        }
        return min;
    }
}