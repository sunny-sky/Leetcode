package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

public class No_119_PascalTriangle2 {
    public static List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<>();

        if (rowIndex <= 0)
            return result;

        for (int i = 0; i < rowIndex+1; i++) {
            result.add(0,1);
            System.out.println("i:"+i+"result:"+result);
            for (int j = 1; j < result.size() - 1; j++) {
                //System.out.println(result.size());
                result.set(j,result.get(j) + result.get(j+1));
                //System.out.println("i:"+i+"result:"+result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getRow2(1));
    }
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i<rowIndex+1;i++) {
            res.add(1);
            for(int j=i-1;j>0;j--) {
                res.set(j, res.get(j-1)+res.get(j));
            }
        }
        return res;
    }
}
