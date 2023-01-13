package practice.easy;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if(image[sr][sc] == color)
                return image;
            fill(image, sr, sc, color, image[sr][sc]);
            return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int cur) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length)
            return;
        if(cur != image[sr][sc])
            return;
        image[sr][sc] = color;
        fill(image, sr-1, sc, color, cur);
        fill(image, sr+1, sc, color, cur);
        fill(image, sr, sc-1, color, cur);
        fill(image, sr, sc+1, color, cur);
    }

    public static void main(String[] args) {
        FloodFill floodFill=new FloodFill();
        floodFill.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}},0,0,2);
    }
}
