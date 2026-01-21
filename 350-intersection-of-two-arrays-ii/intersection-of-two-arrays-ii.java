class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer> result = new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num)){
                result.add(num);
                map.put(num, map.getOrDefault(num, 0)-1);
                map.remove(num, 0);
            }
        }
        int[] re = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            re[i] = result.get(i);
        }
        return re;
    }
}