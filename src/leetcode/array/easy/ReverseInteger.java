package leetcode.array.easy;



public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        int y ;
        for(; x != 0;){
            y = x % 10;
            result = result*10+y;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args){
        ReverseInteger ri = new ReverseInteger();
        int x = -123456;
        int z = ri.reverse(x);
        System.out.println(z);
    }
}
