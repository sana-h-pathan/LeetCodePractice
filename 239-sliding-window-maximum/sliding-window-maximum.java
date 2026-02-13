class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0 || k<=0){
            return new int[0];
        }
        if(k==1){
            return nums;
        }
        int n = nums.length;
        int l=0;
        int r=0;
        int[] result = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        while(r<n){
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[r]){
                dq.pollLast();
            }
            dq.addLast(r);
            if(r-l+1==k){
                result[l] = nums[dq.peekFirst()];
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