package practice.medium;

import java.util.Arrays;

public class ProductOfArray {
    public int[] productExceptSelf1(int[] nums) {
        int[] result= new int[nums.length];
        int value=1;
        for(int num:nums){
            if(num!=0)
                value=value*num;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
                result[i]=value/nums[i];
            else
                result[i]=value;
        }
        return result;
    }
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArray productOfArray=new ProductOfArray();
        System.out.println(Arrays.toString(productOfArray.productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(productOfArray.productExceptSelf(new int[]{-1,1,0,-3,3})));
    }

}
