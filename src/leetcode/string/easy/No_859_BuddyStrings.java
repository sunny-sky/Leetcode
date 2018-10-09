package leetcode.string.easy;

public class No_859_BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();

        if (lenA != lenB)
            return false;

        if (!A.equals(B)) {
            int count = 0, point1 = -1, point2 = lenA;
            for (int i = 0; i < lenA; i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    count++;
                    if (count > 2)
                        return false;
                    if (count == 1)
                        point1 = i;
                    if (count == 2)
                        point2 = i;
                }
            }
            if (A.charAt(point1) == B.charAt(point2) && A.charAt(point2) == B.charAt(point1))
                return true;
            return false;
        } else {
            for (int i = 0; i < lenA; ++i) {
                if (A.indexOf(A.charAt(i)) != A.lastIndexOf(A.charAt(i)))
                    return true;
            }
            return false;
        }
    }
}
