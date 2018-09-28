package leetcode.string.easy;

public class No_551_StudentAttendanceRecordI {
    public boolean checkRecord(String s) {

        if (s.indexOf("A") != s.lastIndexOf("A"))
            return false;
        if (s.contains("LLL"))
            return false;
        return true;

    }

    public boolean checkRecord2(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }

    public boolean checkRecord3(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && s.indexOf("LLL") == -1;
    }
}
