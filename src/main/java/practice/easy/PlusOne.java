package practice.easy;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int i=digits.length-1;
        while (i>=0){
            if(digits[i]==9){
                digits[i--]=0;
            }
            else {
                digits[i]++;
                return digits;
            }
        }
        int[] array = new int[digits.length+1];
        array[0] = 1;
        return array;
    }
    public static void main(String[] args) {
        PlusOne plusOne=new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{1,2,3,9})));
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{9,9})));
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{4,9,9})));
    }
}
