package practice.hard;

public class MedianOfSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i1=0, i2=0;
        int n1 = nums1.length;
        int n2  = nums2.length;
        int n = n1+n2;
        int[] res = new int[n];
        for(int i =0; i< n; i++) {
            if(i2 >= n2) {
                res[i] = nums1[i1++];
            } else if(i1 >= n1) {
                res[i] = nums2[i2++];
            } else if (nums1[i1] <= nums2[i2]) {
                res[i] = nums1[i1++];
            } else if (nums2[i2] <= nums1[i1]) {
                res[i] = nums2[i2++];
            }
        }
        if (res.length%2 == 1) {
            return res[res.length/2];
        }
        return (double)(res[res.length/2] + res[(res.length/2)-1]) / 2L;
    }

    public static void main(String[] args) {
        MedianOfSortedArray medianOfSortedArray=new MedianOfSortedArray();
        System.out.println(medianOfSortedArray.findMedianSortedArrays(new int[]{1,3},new int[]{2,4}));
        System.out.println(medianOfSortedArray.findMedianSortedArrays(new int[]{1,3,5,6},new int[]{2,4}));
    }
}
