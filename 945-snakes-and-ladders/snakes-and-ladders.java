class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int[] flattenArr=new int[n*n];
        boolean dir=true;
        int idx=0;
        int r=n-1;
        int c=0;
        while(idx<n*n){
            if (board[r][c] == -1) {
                flattenArr[idx] = -1;
            } else {
                flattenArr[idx] = board[r][c] - 1;
            }
            idx++;
            if(dir){
                c++;
                if(c==n){
                    c--;
                    r--;
                    dir=false;
                }
            }
            else{
                c--;
                if(c==-1){
                    c++;
                    r--;
                    dir=true;
                }
            }
        }
        HashSet<Integer> visited=new HashSet<>();
        Queue<Integer> bfsQueue=new LinkedList<>();
        bfsQueue.add(0);
        int steps=0;
        while(!bfsQueue.isEmpty()){
            int size=bfsQueue.size();
            for(int i=0;i<size;i++){
                int curr=bfsQueue.poll();
                if(curr==n*n-1)
                    return steps;
                for(int v=1;v<7;v++){
                    int nc=curr+v;
                    if(nc<n*n){
                        if(flattenArr[nc]==-1){
                            if(!visited.contains(nc)){
                                bfsQueue.add(nc);
                                visited.add(nc);
                            }
                        }
                        else{
                            if(!visited.contains(flattenArr[nc])){
                                bfsQueue.add(flattenArr[nc]);
                                visited.add(flattenArr[nc]);
                            }
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
        
    }
}