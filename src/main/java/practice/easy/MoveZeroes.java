package practice.easy;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int leftMostZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > leftMostZeroIndex) {
                    nums[leftMostZeroIndex] = nums[i];
                    nums[i] = 0;
                }
                leftMostZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes=new MoveZeroes();
        moveZeroes.moveZeroes(new int[]{0,1,0,3,12});
    }
}
