/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int low = 0;
        int high = reader.length()-1;

        while(low < high) {
            int mid = low + (high-low)/2;
            // initialize your result
            int result = -1;
            // If number of elements are odd, then we need to include "mid" in left and right subarray, otherwise we'll miss out correct answer.
            // Also in case number of elements are odd (high-low) would be even. Eg., low = 0, high = 2. Number of elements ? = 3. 
            if((high-low) % 2 == 0) 
                result = reader.compareSub(low, mid, mid, high);
            else
                result = reader.compareSub(low, mid, mid+1, high);
                
            if(result > 0 ) high = mid;
            else if(result < 0) low = mid + 1;
            else return mid;  // We have found one larger element here
        }

        return low;
    }
}