package leetcode.array.easy;

public class No_717_Bit {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        int i = 0;
        for (; i < len - 1; i++) {
            if (bits[i] == 1) {
                i++;
            }
        }
        if ( i == len - 1 ) {
            return true;
        }else{
            return false;
        }
    }
}
