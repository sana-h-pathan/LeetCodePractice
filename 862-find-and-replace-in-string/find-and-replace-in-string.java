class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<indices.length;i++){
            int idx = indices[i];
            String src = sources[i];
            if(s.startsWith(src, idx)){
                map.put(idx, i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();){
            if(!map.containsKey(i)){
                sb.append(s.charAt(i));
                i++;
            } else {
                int idx = map.get(i);
                String source = sources[idx];
                String target = targets[idx];
                sb.append(target);
                i+=source.length();
            }
        }
        return sb.toString();
    }
}