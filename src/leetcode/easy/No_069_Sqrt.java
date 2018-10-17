package leetcode.easy;

public class No_069_Sqrt {
    public int mySqrt(int x) {
        if (x < 4 && x >= 1)
            return 1;
        if (x == 0)
            return 0;
        int head = 2, rear = x / 2, mid = (head + rear) / 2;
        while (head <= mid) {
            if (mid  < x / mid) {
                head = mid + 1;
                mid = (head + rear) / 2;
            } else if (mid > x / mid) {
                rear = mid - 1;
                mid = (head + rear) / 2;
            } else
                return mid;
        }
        return rear;
    }

    public int mySqrt1(int x) {
        if (x == 0)
            return 0;
        double d = (double) x;
        double result = d / 2;
        while (true) {
            double Xn = (result + d / result) / 2;
            if (Math.abs(result - Xn) < 0.01)
                return (int)Xn;
            result = Xn;
        }
    }
}
