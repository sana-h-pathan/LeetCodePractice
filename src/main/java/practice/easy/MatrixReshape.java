package practice.easy;

public class MatrixReshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] result=new int[r][c];
        int originalRows=mat.length;
        int originalColumns=mat[0].length;
        if(r*c!=originalRows*originalColumns)
            return mat;
        int newRow=0;
        int newColumn=0;
        for(int i=0;i<originalRows;i++){
            for(int j=0;j<originalColumns;j++){
                result[newRow][newColumn]=mat[i][j];
                newColumn++;
                if(newColumn == c)
                {
                    newColumn = 0;
                    newRow++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MatrixReshape matrixReshape=new MatrixReshape();
        matrixReshape.matrixReshape(new int[][]{{1,2},{3,4}},2,2);
    }
}
