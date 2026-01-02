class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int k = 0;
        for (int n : nums2) {
            int cnt = map.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                map.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}