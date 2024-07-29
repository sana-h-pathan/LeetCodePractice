class Solution {
    class Tupple{
        int[] cord;
        int dist;
        Tupple(int[] cord,int dist) {
            this.cord=cord;
            this.dist=dist;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] effort=new int[m][n];
        int[][] dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        PriorityQueue<Tupple> pq = new PriorityQueue<Tupple>((x,y) -> x.dist - y.dist);
        for(int[] row: effort){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        effort[0][0]=0;
        pq.add(new Tupple(new int[]{0,0},0));
        while(!pq.isEmpty()){
            Tupple curr=pq.poll();
            int[] currCord=curr.cord;
            int r=currCord[0];
            int c=currCord[1];
            int d=curr.dist;
            if(r==m-1&&c==n-1)
                return d;
            for(int[] dir: dirs){
                int nr=dir[0]+currCord[0];
                int nc=dir[1]+currCord[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    int newEffort = Math.max(Math.abs(heights[r][c]-heights[nr][nc]), d); 
                    if(newEffort < effort[nr][nc]) {
                        effort[nr][nc] = newEffort; 
                        pq.add(new Tupple(new int[]{nr,nc},effort[nr][nc])); 
                    }
                }
            }
        }
        return 0;
    }
}