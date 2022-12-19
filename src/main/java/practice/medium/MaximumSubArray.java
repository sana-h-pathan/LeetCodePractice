package practice.medium;

public class MaximumSubArray {
    public int maxSubArray(int[] problem) {
        int currentSumArray=problem[0];
        int maximumSumArray=problem[0];
        for (int i=1;i<problem.length;i++) {
            int number = problem[i];
            currentSumArray=Integer.max(number,currentSumArray+number);
            maximumSumArray=Integer.max(currentSumArray,maximumSumArray);
        }

        return maximumSumArray;
    }

    public static void main(String[] args) {
        MaximumSubArray maximumSubArray=new MaximumSubArray();
        System.out.println(maximumSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
