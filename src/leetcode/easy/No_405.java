package leetcode.easy;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 19:27 2018/12/10
 */
public class No_405 {
    /**
     * @param num int
     * @return java.lang.String
     * @Description 手动实现10进制转化为16进制
     * @Auther Liang
     * @date 19:27 2018/12/10
     */
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.insert(0, map[(num & 15)]);
            num = (num >>> 4);
        }
        return sb.toString();
    }
}
