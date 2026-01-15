class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0; i<indices.length; i++){
            int idx = indices[i];
            String src = sources[i];
                if (s.startsWith(src, idx)){
                    map.put(indices[i],i);
            }
        }  
        StringBuilder sb=new StringBuilder();
        for (int i=0; i<s.length();){
            if (!map.containsKey(i)){
                sb.append(s.charAt(i));
                i++;
            } else { //replace chars
                int index = map.get(i);
                String source = sources[index];
                String target = targets[index];
                sb.append(target); // Replace with target
                i += source.length(); // Skip over the source string
            }
        }
        return sb.toString();
    }
}