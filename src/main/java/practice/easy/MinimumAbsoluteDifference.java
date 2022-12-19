package practice.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i]<min){
                min=arr[i+1]-arr[i];
                result.clear();
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
            else if(arr[i+1]-arr[i]==min){
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifference mad=new MinimumAbsoluteDifference();
        System.out.println(mad.minimumAbsDifference(new int[]{1,3,6,10,15}));
        System.out.println(mad.minimumAbsDifference(new int[]{4,2,1,3}));

    }

}
