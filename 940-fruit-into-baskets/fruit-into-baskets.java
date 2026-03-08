class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0;
        int r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        while(r<fruits.length){
            int rType = fruits[r];
            map.put(rType, map.getOrDefault(rType, 0)+1);
            if(map.size()>2){
                int lType = fruits[l];
                map.put(lType, map.getOrDefault(lType, 0)-1);
                map.remove(lType, 0);
                l++;
            }
            maxLength = Math.max(r-l+1, maxLength);
            r++;
        }
        return maxLength;
    }
}