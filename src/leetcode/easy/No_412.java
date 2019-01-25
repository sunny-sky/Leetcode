package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Liang
 * @Description: 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * @Date: Created in 0:19 2019/1/21
 */
public class No_412 {
    /**
     * @Description 一个程序，输出从 1 到 n 数字的字符串表示。
     * @Auther Liang
     * @date 0:20 2019/1/21
     * @param n int
     * @return java.util.List<java.lang.String>
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        int tag3, tag5;
        final int div3 = 3, div5 = 5;
        for (int i = 0; i < n; i++) {
            tag3 = (i + 1) % div3;
            tag5 = (i + 1) % div5;
            if (tag3 != 0 && tag5 != 0) {
                res.add(Integer.toString(i + 1));
            } else if (tag3 == 0 && tag5 != 0) {
                res.add("Fizz");
            } else if (tag3 != 0) {
                res.add("Buzz");
            } else {
                res.add("FizzBuzz");
            }
        }
        return res;
    }
}
