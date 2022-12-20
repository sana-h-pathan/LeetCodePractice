package practice.easy;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int[] number=new int[nums.length+1];
        for(int num:nums){
            number[num]=number[num]+1;
        }
        for(int i=0;i<number.length;i++){
            if(number[i]==0)
                return i;
        }
        return 0;
    }

        public static void main(String[] args) {
        MissingNumber missingNumber=new MissingNumber();
            System.out.println(missingNumber.missingNumber(new int[]{0,1,3}));
    }
}
