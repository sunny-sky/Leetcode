package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class No_225_ImplementStackusingQueues {
    class MyStack {
        private Queue<Integer> queue;


        /** Initialize your data structure here. */
        public MyStack() {
            this.queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.offer(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.offer(queue.poll());
            }
            int res = queue.poll();
            return res;
        }

        /** Get the top element. */
        public int top() {
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.offer(queue.poll());
            }
            int res = queue.peek();
            queue.offer(queue.poll());
            return res;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            if (queue.peek() == null)
                return true;
            return false;
        }
    }
}
