package leetcode.easy;

import java.util.Stack;

public class No_232_ImplementQueueusingStacks {
    class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;


        /** Initialize your data structure here. */
        public MyQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            } else {
                return stack2.pop();
            }
        }

        /** Get the front element. */
        public int peek() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.peek();
            } else {
                return stack2.peek();
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            if (stack2.empty() && stack1.empty())
                return true;
            return false;
        }
    }
}
