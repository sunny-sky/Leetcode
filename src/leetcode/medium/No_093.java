package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class No_093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> solutions = new ArrayList<>();
        restoreIp(s, solutions, 0, "", 0);
        return solutions;
    }

    private void restoreIp(String ip, List<String> solutions,
                           int idx, String restored, int count) {
        // 组数大于4退出，因IP最多三段
        if (count > 4) {
            return;
        }
        // 组数等于4，且ip被完全遍历，则储存结果到结果集
        if (count == 4 && idx == ip.length()) {
            solutions.add(restored);
        }
        // i 1 2 3
        for (int i = 1; i < 4; i++) {
            if (idx + i > ip.length()) {
                break;
            }
            String s = ip.substring(idx, idx + i);
            // 排除以0开头的2或3位IP段或大于256的IP段
            if ((s.startsWith("0") && s.length() > 1) ||
                    (i == 3 && Integer.parseInt(s) >= 256)) {
                continue;
            }
            // 确认本段且添加下一段，可能结果为2.2.5.2 段数为4但长度不够，再进入循环导致count大于4
            // 淘汰该分支
            restoreIp(ip, solutions, idx + i, restored + s +
                    (count == 3 ? "" : "."), count + 1);
        }
    }
}
