package leetcode.medium;

public class No_006 {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();  // 转为数组
        int len = s.length();
        // numRows个String数组
        StringBuffer[] sb = new StringBuffer[numRows];
        // 初始化
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }

        int i = 0;
        // 遍历c，来回扫描存入sb对应行
        while (i < len) {
            // 对应从上到下遍历，idx为sb内行，c[i++]为当前字符
            for (int idx = 0; idx < numRows && i < len; idx++) {
                sb[idx].append(c[i++]);
            }
            // 从左到右遍历
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
                sb[idx].append(c[i++]);
            }
        }
        return String.join("", sb);
//        // 按行复制
//        for (int idx = 1; idx < sb.length; idx++) {
//            sb[0].append(sb[idx]);
//        }
//        return sb[0].toString();
    }
}
