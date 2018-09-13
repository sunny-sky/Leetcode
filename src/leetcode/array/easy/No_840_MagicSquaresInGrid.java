package leetcode.array.easy;

public class No_840_MagicSquaresInGrid {
    public static int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        if (row < 3)
            return 0;
        int col = grid[0].length;
        if (col < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < col - 2; ++i) {
            for (int j = 0; j < row - 2; ++j) {
                if (isMagic(grid,j,i)){
                    count++;
                }
            }
        }
        return count;

    }
    public static boolean isMagic(int[][] grid,int row,int col){
        System.out.println("row="+row+";col="+col);
        for (int i = 0;i < 3;++i) {
            for (int j = 0; j < 3;++j) {
                if (grid[row+i][col+j]>9 || grid[row+i][col+j]<1){
                    return false;
                }
            }
        }
        int sum = grid[row][col] + grid[row+1][col+1] + grid[row + 2][col+2];
        if ((grid[row][col+2] + grid[row+1][col+1] + grid[row+2][col]) != sum ){
            return false;
        }
        for (int i = 0; i < 3; ++i) {
            if (sum != (grid[row+i][col] + grid[row+i][col+1] + grid[row+i][col+2]))
                return false;
        }
        for (int j = 0; j < 3; ++j) {
            if (sum != (grid[row][col+j] + grid[row+1][col+j] + grid[row+2][col+j]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] temp = new int[][]{{10,3,5},{1,6,11},{7,9,2}};
        int ans = numMagicSquaresInside(temp);
        System.out.println(ans);

    }


}