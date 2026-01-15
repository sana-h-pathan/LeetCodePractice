class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0; i<indices.length; i++){
                if (s.startsWith(sources[i],indices[i])){
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

                // Check if the source string matches the substring in s
                if (s.startsWith(source, i)) {
                    sb.append(target); // Replace with target
                    i += source.length(); // Skip over the source string
                } else {
                    sb.append(s.charAt(i)); // If it doesn't match, just append the current character
                    i++;
                }
            }
        }
        return sb.toString();
    }
}