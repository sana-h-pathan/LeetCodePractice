class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        int n=nums1.length;
        long[] diff=new long[n];
        for(int i=0;i<n;i++){
            diff[i]=nums1[i]-nums2[i];
        }
        Arrays.sort(diff);
        long result=0;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (diff[l] + diff[r] > 0) {
                result += r - l;
                r--;
            } else 
                l++;
        }
        return result;
    }
}