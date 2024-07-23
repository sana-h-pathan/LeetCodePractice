class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        HashMap<Integer, Integer> ballMap = new HashMap<>();
        HashMap<Integer, Integer> colorMap = new HashMap<>();
        int idx=0;
        for(int[] q: queries){
            int ball = q[0];
            int color = q[1];
            if(colorMap.containsKey(ball)) {
                int ballColor=colorMap.get(ball);
                ballMap.put(ballColor, ballMap.get(ballColor)-1);
                if(ballMap.get(ballColor)==0) 
                    ballMap.remove(ballColor);
            }
            colorMap.put(ball, color);
            ballMap.put(color, ballMap.getOrDefault(color, 0)+1);
            
            result[idx++] = ballMap.size();
        }
        return result;
    }
}