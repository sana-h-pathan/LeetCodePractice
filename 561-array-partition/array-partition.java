class Solution {
    public int arrayPairSum1(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i+=2){
            System.out.println(nums[i]);
            sum= sum+nums[i];
        }
        return sum;
    }
    public int arrayPairSum2(int[] nums) {
        int min=nums[0];
        int max=nums[0];
        int sum=0;
        HashMap<Integer, Integer> numberFreq=new HashMap<>();
        for(int num: nums){
            min=Integer.min(min,num);
            max=Integer.max(max,num);
            numberFreq.put(num,numberFreq.getOrDefault(num,0)+1);
        }
        int j=0;
        int i=min;
        while(i>=min && i<=max){
            if(numberFreq.containsKey(i)){
                if(j%2==0)
                    sum+=i;
                numberFreq.put(i,numberFreq.get(i)-1);
                numberFreq.remove(i,0);
                j++;
            }
            else//(!numberFreq.containsKey(i))
                i++;
        }
        return sum;
    }

    public int arrayPairSum(int[] nums) {
        int min=nums[0];
        int max=nums[0];
        HashMap<Integer, Integer> numFreq=new HashMap<>();
        int sum=0;
        for(int num: nums){
            min=Math.min(min, num);
            max=Math.max(max, num);
            numFreq.put(num,numFreq.getOrDefault(num,0)+1);
        }
        int i=min;
        int j=0;
        while(i>=min && i<=max){
            if(numFreq.containsKey(i)){
                if(j%2==0){
                    sum+=i;
                }
                numFreq.put(i,numFreq.getOrDefault(i,0)-1);
                numFreq.remove(i,0);
                j++;
            }
            if(!numFreq.containsKey(i))
                i++;
        }
        return sum;
    }
}