package practice.medium;

import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for(int i = 0; i < length; i++) {
            //transpose
            for (int j = i; j < length; j++) {
                //swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            //revrse row
            int start = 0;
            int end = length - 1;
            while (start < end) {
                //swap
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
            System.out.println("done");
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage=new RotateImage();
        rotateImage.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});

    }
}
