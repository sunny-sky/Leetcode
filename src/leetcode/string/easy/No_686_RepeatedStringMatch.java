package leetcode.string.easy;

public class No_686_RepeatedStringMatch {

  // 550 ms,排名6%...
	public int repeatedStringMatch(String A, String B) {
		int lenA = A.length();
		int lenB = B.length();
		int t = lenB / lenA;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			sb.append(A);
		}
		
		for (int j = 0; j < 3; ++j) {
			if (sb.toString().contains(B)) {
				return t + j;
			}
			else
				sb.append(A);
		}
		return -1;
    }
    
    // 将 .contains()方法换为 .indexof() 方法，用时140 ms，排名87%
	public int repeatedStringMatch3(String A, String B) {
		int lenA = A.length();
		int lenB = B.length();
		int t = lenB / lenA;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			sb.append(A);
		}

		for (int j = 0; j < 3; ++j) {
			if (sb.toString().indexOf(B) != -1) {
				return t + j;
			}
			else
				sb.append(A);
		}
		return -1;
        }
	
	// 178ms 68%
	 public int repeatedStringMatch2(String A, String B) {

	    int count = 0;
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < B.length()) {
		sb.append(A);
		count++;
	    }
	    if(sb.toString().contains(B)) return count;
	    if(sb.append(A).toString().contains(B)) return ++count;
	    return -1;
	}
}
