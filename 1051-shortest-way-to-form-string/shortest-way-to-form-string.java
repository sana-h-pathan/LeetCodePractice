class Solution {
    public int shortestWay(String source, String target) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int sl = source.length();
        int tl = target.length();
        for(int i=0;i<sl;i++){
            char ch = source.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, new ArrayList<>());
            }
            map.get(ch).add(i);
        }
        int sp =0;
        int tp =0;
        int count=1;
        while(tp<tl){
            char ch = target.charAt(tp);
            if(!map.containsKey(ch)){
                return -1;
            }
            List<Integer> idxList = map.get(ch);
            int k = Collections.binarySearch(idxList, sp);
            if(k<0){
                k = -k-1;
            }
            if(k==idxList.size()){
                count++;
                sp =0;
            } else {
                sp = idxList.get(k);
                sp++;
                tp++;
            }
        }
        return count;
    }
}