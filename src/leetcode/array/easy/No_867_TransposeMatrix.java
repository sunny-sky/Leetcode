package leetcode.array.easy;

public class No_867_TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int row = A.length;
        int col = A[0].length;

        if (row == 1 && col == 1) {
            return A;
        }

        int[][] B = new int[col][row];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}
