class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int result[] = new int[n];
        int idx=0;
        for(int num: nums){
            if (num % 2 == 0) {
                result[idx++] = -1;
            } else {
                result[idx++] = num - ((num + 1) & (-num - 1)) / 2;
            }
        }
        return result;
    }
}