package leetcode.array.easy;

public class No_849_MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        if (len == 2) {
            return 1;
        }

        int i = 0, j = len - 1,counthead = 0, countrear = 0, count = 0, temp = 0;
        for (;seats[i] == 0; ++i) {
            counthead++;
        }
        for (;seats[j] == 0; --j) {
            countrear++;
        }
        for (; i < j; ++i) {
            if (seats[i] == 0)
                temp++;
            else
                temp = 0;
            count = Math.max(temp,count);
        }

        return Math.max(Math.max(counthead,countrear),(count+1)/2);
    }
}
