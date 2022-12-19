package practice.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List <List<Integer>> output= new ArrayList<>();
        output.add(new ArrayList<Integer>());
        output.get(0).add(1); //base case to add 1st row
        for (int i=1; i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = output.get(i-1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            // The last value element is always 1.
            row.add(1);
            output.add(row);
        }

        return output;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        pascalTriangle.generate(5);
    }
}
