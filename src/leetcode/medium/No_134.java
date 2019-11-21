package leetcode.medium;

public class No_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 遍历数组，有满足条件解则返回
        for (int i = 0; i < gas.length; i++) {
            if (helper(gas, cost, i) != -1) {
                return helper(gas, cost, i);
            }
        }
        return -1;
    }

    // 从某起点是否能环绕一周
    private int helper(int[] gas, int[] cost, int start) {
        int gasNum = 0;  //剩余油量
        int len = gas.length;
        // 遍历，若能环绕则返回start，不能则中断返回-1
        for (int i = 0; i < len; i++) {
            if (gasNum + gas[(start + i) % len] < cost[(start + i) % len]) {
                return -1;
            } else {
                gasNum = gasNum + gas[(start + i) % len] - cost[(start + i) % len];
            }
        }
        return start;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int len = gas.length;

        int total_tank = 0;
        int curr_tank = 0;
        int start_station = 0;
        for (int i = 0; i < len; i++) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            // 不能到达
            if (curr_tank < 0) {
                start_station = i + 1;
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? start_station : -1;
    }
}
