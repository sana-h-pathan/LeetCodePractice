class Solution {
    public int numTilePossibilities(String tiles) {
        HashSet<String> count = new HashSet<>();
        int n=tiles.length();
        boolean[] visited=new boolean[n];
        backtrack(tiles, 0, count, visited, new StringBuilder());
        return count.size(); 
    }

    

    private void backtrack(String tiles, int idx, HashSet<String> set, boolean[] visited,StringBuilder sb){
        if(sb.length()>0)
            set.add(sb.toString());
        for(int i=idx;i<tiles.length();i++){
            if (!visited[i]){
                sb.append(tiles.charAt(i));
                visited[i]=true;
                backtrack(tiles, 0, set, visited, sb);
                visited[i]=false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}