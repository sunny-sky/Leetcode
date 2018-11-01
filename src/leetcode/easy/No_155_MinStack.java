package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class No_155_MinStack {
    class MinStack {
        private List<Integer> stack;
        private int head;
        private int minPoint;

        /** initialize your data structure here. */
        public MinStack() {
            this.stack = new ArrayList<>();
            this.head = 0;
            this.minPoint = -1;
        }

        public void push(int x) {
            stack.add(x);
            if (minPoint == -1 || stack.get(minPoint) > x)
                minPoint = head;
            head++;
        }

        public void pop() {
            if (head <= 0)
                System.out.println("栈以空");
            else {
                stack.remove(--head);
                minPoint = 0;
                for (int i = 1; i < stack.size(); i++) {
                    if (stack.get(minPoint) > stack.get(i)) {
                        minPoint = i;
                    }
                }
            }
        }

        public int top() {
            if (head == 0)
                throw new IllegalArgumentException("栈空");
            return stack.get(head - 1);
        }

        public int getMin() {
            if (minPoint == -1)
                throw new IllegalArgumentException("栈空");
            return stack.get(minPoint);
        }
    }
}
