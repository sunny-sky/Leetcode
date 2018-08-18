package leetcode.array.easy;


import java.util.ArrayList;
import java.util.List;


public class No_118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // First base case
        if (numRows == 0) {
            return triangle;
        }

        // Second base case
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // The first row element is always [1]
            row.add(1);

            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }
        return triangle;
    }

    public List<List<Integer>> generate2(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i ) {
                    list.add(1);
                }
                else {
                    int a = result.get(i-1).get(j-1);
                    int b = result.get(i-1).get(j);
                    list.add(a+b);
                }
            }
            result.add(list);
        }
        return result;
    }

}
