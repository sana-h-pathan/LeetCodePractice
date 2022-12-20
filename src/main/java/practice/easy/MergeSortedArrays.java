package practice.easy;

import java.util.Arrays;

public class MergeSortedArrays {
    public void merge(int[] marr, int m, int[] narr, int n) {
        for (int i = 0; i < n; i++) {
            marr[i + m] = narr[i];
        }
        Arrays.sort(marr);

    }
    public void merge1(int[] marr, int m, int[] narr, int n){
        for (int i = m + n - 1; i >= 0; i--) {
            if (m == 0)                             
                marr[i] = narr[--n];
            else if (n == 0)                        
                marr[i] = marr[--m];
            else if (marr[m - 1] > narr[n - 1])   
                marr[i] = marr[--m];
            else                                    
                marr[i] = narr[--n];
        }
    }
        public static void main(String[] args) {
        MergeSortedArrays mergeSortedArrays=new MergeSortedArrays();
        mergeSortedArrays.merge1(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);

    }
}
