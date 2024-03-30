class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String> set=new HashSet<>();
        HashMap<Character, int[]> map=new HashMap<>();
        map.put('N',new int[]{0,1});
        map.put('E',new int[]{1,0});
        map.put('S',new int[]{0,-1});
        map.put('W',new int[]{-1,0});
        int x=0;
        int y=0;
        set.add(x+","+y);
        for(char c: path.toCharArray()){
            int[] curr=map.get(c);
            x=x+curr[0];
            y=y+curr[1];
            String newCurr=x+","+y;
            if(set.contains(newCurr)){
                return true;            
            }
            set.add(newCurr);
        }
        return false;
    }
}