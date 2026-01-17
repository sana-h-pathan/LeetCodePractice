class SnakeGame {
    LinkedList<int[]> snake;
    boolean[][] visited;
    int m;
    int n;
    int[][] foodList;
    int[] snakeHead;
    int idx;

    public SnakeGame(int width, int height, int[][] food) {
        this.m = width;
        this.n = height;
        this.snake = new LinkedList<>();
        this.visited = new boolean[n][m];
        this.foodList = food;
        this.snakeHead = new int[]{0,0};
        this.snake.addLast(snakeHead);
        this.idx=0;
    }
    
    public int move(String direction) {
        int r = snakeHead[0];
        int c = snakeHead[1];
        if(direction.equals("R")){
            c++;
        } else if(direction.equals("D")){
            r++;
        } else if(direction.equals("L")){
            c--;
        } else {
            r--;
        }
        if(r< 0 || c<0 || r==n || c==m){
            return -1;
        }
        if(visited[r][c]){
            return -1;
        }
        if(idx<foodList.length && r==foodList[idx][0]&& c==foodList[idx][1]){
            int[] newHead = new int[]{r,c};
            visited[r][c]=true;
            snake.add(newHead);
            idx++;
            snakeHead = newHead;
            return snake.size()-1;
        }
        int[] newHead = new int[]{r,c};
        snake.addLast(newHead);
        visited[r][c]=true;
        snake.removeFirst();
        int[] toRemove = snake.getFirst();
        visited[toRemove[0]][toRemove[1]]=false;
        snakeHead = newHead;
        return snake.size()-1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */