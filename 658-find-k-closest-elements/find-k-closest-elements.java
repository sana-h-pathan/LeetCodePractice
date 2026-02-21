class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0;
        int high = n - k; // last possible window start

        while (low<high) {
            int mid = low + (high - low) / 2;

            // window is [mid .. mid+k-1], compare edges: arr[mid] vs arr[mid+k]
            int leftGap = x - arr[mid];
            int rightGap = arr[mid + k] - x;

            // if left edge is farther than the element just outside right edge, shift right
            if (leftGap > rightGap) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}