class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0 || k<=0){
            return new int[0];
        }
        int n=nums.length;
        if(k==1){
            return nums;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[n-k+1];
        int l=0;
        int r=0;
        while(r<n){
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[r]){
                dq.pollLast();
            }
            dq.addLast(r);
            if(r-l+1==k){
                result[l]=nums[dq.peekFirst()];
                if(!dq.isEmpty() && dq.peekFirst()==l){
                    dq.pollFirst();
                }
                l++;
            }
            r++;
        }
        return result;
    }
}