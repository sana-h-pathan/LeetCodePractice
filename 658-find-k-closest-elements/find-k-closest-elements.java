class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        int low = 0;
        int high = nums.length-k;
        while(low<high){
            int mid = low+(high-low)/2;
            int leftGap = x-nums[mid];
            int rightGap = nums[mid+k]-x;
            if(rightGap<leftGap){
                low = mid+1;
            } else {
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=low;i<low+k;i++){
            result.add(nums[i]);
        }
        return result;
    }
}