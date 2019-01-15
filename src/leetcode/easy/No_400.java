package leetcode.easy;

import jdk.nashorn.internal.objects.NativeInt16Array;

/**
 * @Author: Liang
 * @Description: 第N个数字
 * @Date: Created in 15:36 2018/12/22
 */
public class No_400 {
    /**
     * @Description 第N个数字
     * @Auther Liang
     * @date 15:37 2018/12/22
     * @param n int
     * @return int
     */
    public int findNthDigit(int n) {
        // 一位数9个,长度9，两位数90个，长度180，三位数900个，长度2700；等比数列
        // 由前m项和与n的的关系，得出其在几位数区间
        if (n <= 9) {
            return n;
        }
        int q = 10;
        int a1 = 9;
        int m = 2;
        int s = 189;
        int sPre = 9;
        while (s < n) {
            m++;
            sPre = s;
            s += 9 * Math.pow(10, m - 1) * m;
        }
        m--;
        System.out.println("m:" + m);
        int count = n - sPre;
        System.out.println("count:" + count);
        int res = (int) Math.pow(10, m) + count / (m + 1) - 1;
        System.out.println("res:" + res);
        if (count % (m + 1) == 0) {
            return res % 10;
        } else {
            return (res + 1) / (int) Math.pow(10, m + 1 - (count % (m + 1))) % 10;
        }
    }
    /**
     * @Description 一种简单方法
     * @Auther Liang
     * @date 16:51 2018/12/22
     * @param n int
     * @return int
     */
    public int findNthDigit2(int n) {
        long len = 1; // 第n个位置所属数字长度
        long cnt = 9; // 该长度下数字个数，如：长度1，9个；长度2,90个...
        long start = 1; //该长度下起始数字
        // 查找结果所属数组长度
        while (n > len * cnt) {
            n -= len * cnt;
            ++len;
            cnt *= 10;
            start *= 10;
        }
        start += (n - 1) / len; // 确定第n个位置所属的数字
        String t = Long.toString(start);
        char[] t1 = t.toCharArray();
        return t1[(int) ((n - 1) % len)] - '0';
    }
}
