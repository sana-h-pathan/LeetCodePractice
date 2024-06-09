public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int pSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); 

        for (int num : nums) {
            pSum += num;
            int val = pSum % k;
            if (val < 0) 
                val += k;            
            if (map.containsKey(val)) {
                count += map.get(val);
                map.put(val, map.get(val) + 1);
            } else 
                map.put(val, 1);
        }
        
        return count;
    }
}