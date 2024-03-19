class Solution {
    int[][] directions; // Directions array to store possible movement directions
    int rows; // Number of rows in the maze
    int cols; // Number of columns in the maze
    
    public boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
        this.directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}}; // Right, Down, Left, Up
        this.rows = maze.length;
        this.cols = maze[0].length;
        
        // If start and destination are the same, return true
        if(start[0] == destination[0] && start[1] == destination[1])
            return true;
        
        Queue<int[]> bfsQueue = new LinkedList<>(); // Queue for BFS traversal
        bfsQueue.add(start);
        maze[start[0]][start[1]] = 2; // Mark start as visited
        
        // Perform BFS traversal
        while (!bfsQueue.isEmpty()){
            int[] current = bfsQueue.poll();
            for(int[] dir: directions){
                int cr = current[0]; // Current row
                int cc = current[1]; // Current column
                // Move until hitting a wall or border
                while(cr >= 0 && cc >= 0 && cr < rows && cc < cols && maze[cr][cc] != 1){
                    cr += dir[0];
                    cc += dir[1];
                }
                // Step back to the valid position
                cr -= dir[0];
                cc -= dir[1];
                
                // If the cell is not visited, mark it visited and add to the queue
                if(maze[cr][cc] != 2){
                    if(cr == destination[0] && cc == destination[1])
                        return true;
                    bfsQueue.add(new int[]{cr, cc});
                    maze[cr][cc] = 2; // Mark as visited
                }
            }
        }
        return false; // If destination is not reached
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}}; // Right, Down, Left, Up
        this.rows = maze.length;
        this.cols = maze[0].length;
        
        // If start and destination are the same, return true
        if(start[0] == destination[0] && start[1] == destination[1])
            return true;
        
        maze[start[0]][start[1]] = 2; // Mark start as visited
        return dfs(maze, start[0], start[1], destination); // Perform DFS
    }

    private boolean dfs(int[][] maze, int i, int j, int[] destination){
        // If current position is the destination, return true
        if(i == destination[0] && j == destination[1])
            return true;
        
        // Explore in all directions
        for(int[] dir: directions){
            int cr = i; // Current row
            int cc = j; // Current column
            // Move until hitting a wall or border
            while(cr >= 0 && cc >= 0 && cr < rows && cc < cols && maze[cr][cc] != 1){
                cr += dir[0];
                cc += dir[1];
            }
            // Step back to the valid position
            cr -= dir[0];
            cc -= dir[1];
            
            // If the cell is not visited, mark it visited and recursively explore
            if(maze[cr][cc] != 2){
                maze[cr][cc] = 2; // Mark as visited
                if(dfs(maze, cr, cc, destination))
                    return true;
            }
        }
        return false; // If destination is not reachable
    }
}