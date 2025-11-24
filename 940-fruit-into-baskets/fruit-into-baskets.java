class Solution {
    public int totalFruit(int[] fruits) {
        int l=0;
        int r=0;
        int maxLength=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        while(r<fruits.length){
            int rFruitType=fruits[r];
            map.put(rFruitType, map.getOrDefault(rFruitType,0)+1);
            while(map.size()>2){
                int lFruitType=fruits[l];
                map.put(lFruitType, map.getOrDefault(lFruitType,0)-1);
                if(map.get(lFruitType)==0)
                    map.remove(lFruitType);
                l++;
            }
            maxLength=Math.max(maxLength, r-l+1);
            r++;
        }
        return maxLength;
    }
}