class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int high=0;
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
            high=Integer.max(num,high);
        }
        
        return Arrays.stream(nums).boxed()
			.sorted((a,b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
			.mapToInt(n -> n)
			.toArray();
    }
}