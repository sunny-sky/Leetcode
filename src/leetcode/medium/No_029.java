package leetcode.medium;

public class No_029 {
    public int divide(int dividend, int divisor) {
        // 特殊情况
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 统一化为负数计算
        if (dividend > 0 && divisor > 0) {
            return divideHelper(-dividend, -divisor);
        } else if (dividend > 0) {
            return -divideHelper(-dividend, divisor);
        }
        else if(divisor > 0) {
            return -divideHelper(dividend, -divisor);
        }
        else {
            return divideHelper(dividend, divisor);
        }
    }

    private int divideHelper(int dividend, int divisor) {
        int result = 0;
        int currentDivisor = divisor;
        while (true) {
            // 两数均化为负数，故大于时推出循环
            if (dividend > divisor) {
                break;
            }
            int temp = 1;
            // 确定结果的最高位数
            while (dividend <= currentDivisor << 1 && currentDivisor << 1 < 0) {
                temp = temp << 1;
                currentDivisor = currentDivisor << 1;
            }
            // 减去最高位对应的dividend中得值
            dividend -= currentDivisor;
            result += temp;
            currentDivisor = divisor;
        }
        return result;
    }

    public int divide1(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        // 溢出
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int count;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            count = -1;
            while ((divisor > 0 && dividend >= 0) || (dividend <= 0 && divisor < 0)) {
                count++;
                dividend -= divisor;
            }
        } else {
            count = 1;
            while ((dividend >= 0 && divisor < 0) || (dividend <= 0 && divisor > 0)) {
                count--;
                dividend += divisor;
            }
        }
        return count;
    }
}
