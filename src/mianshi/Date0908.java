package mianshi;

import java.util.HashMap;
import java.util.Scanner;

public class Date0908 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        HashMap<Integer, String> record  = new HashMap<>();
        HashMap<String, Integer> res = new HashMap<>();
        int time = 0;
        Integer pointer = 0;  // pointer 追踪最小时间
        int n = 0; // 当前数据个数

        while (input.hasNext()) {
            String tempKey = input.next();
            int tempValue = input.nextInt();
            if (res.containsKey(tempKey)) {
                if (res.get(tempKey) < tempValue) {
                    res.put(tempKey, tempValue);
                }
            } else {
                if (n < N) {
                    res.put(tempKey, tempValue);
                    n++;
                    record.put(time++, tempKey);
                } else {
                    if (record.containsKey(pointer)) {
                        System.out.println(record.get(pointer) + " " + res.get(record.get(pointer)));
                        res.remove(record.get(pointer));
                        record.remove(pointer++);
                        res.put(tempKey, tempValue);
                        record.put(time++, tempKey);
                    } else {
                        pointer++;
                    }
                }
            }
        }


    }
}
