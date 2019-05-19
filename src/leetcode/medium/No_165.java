package leetcode.medium;

public class No_165 {
    public int compareVersion(String version1, String version2) {
        // 判空
        if (version1 == null || version1 == "" || version2 == null || version2 == "") {
            return 0;
        }
        // 分割字符串
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        // 比较
        int max_index = Math.max(ver1.length, ver2.length);
        int min_index = Math.min(ver1.length, ver2.length);
        for (int i = 0; i < min_index; i++) {
             if (Integer.parseInt(ver1[i]) > Integer.parseInt(ver2[i])) {
                 return 1;
             } else if (Integer.parseInt(ver1[i]) < Integer.parseInt(ver2[i])) {
                 return -1;
             }
        }
        if (ver1.length > ver2.length) {
            for (int j = min_index; j < max_index; j++) {
                if (Integer.parseInt(ver1[j]) != 0) {
                    return 1;
                }
            }
        } else if (ver1.length < ver2.length) {
            for (int k = min_index; k < max_index; k++) {
                if (Integer.parseInt(ver2[k]) != 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
