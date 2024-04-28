class Solution {
    HashMap<Character,List<Integer>> map;
    int n;
    int memo[][];
    public int findRotateSteps(String ring, String key) {
       map = new HashMap();
       
       
       n = ring.length();
       memo = new int[key.length()+1][n+1];
       int k=0;
       for(char c:ring.toCharArray())
       { 
            if(!map.containsKey(c))
                map.put(c, new LinkedList());
            map.get(c).add(k++);
        }
        return backtrack(ring, key, 0,0);
    }
    int backtrack( String ring, String key, int i, int curr )
    {
        if(i == key.length())
            return 0;
        char c = key.charAt(i);
        int ans = Integer.MAX_VALUE;
        if(memo[i][curr]!=0) return memo[i][curr];
        for(int index: map.get(c))
        {
            
            int charge = Math.min(
                (n-1-Math.max(index,curr)) + (Math.min(index,curr)-0+1),
                Math.abs(curr-index));
            ans  = Math.min(ans, charge+backtrack(ring,key,i+1,index)+1);
        }
        memo[i][curr] =ans;
        return ans;
    }
}