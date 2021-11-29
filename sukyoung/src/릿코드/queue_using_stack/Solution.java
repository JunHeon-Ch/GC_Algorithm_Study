package 릿코드.queue_using_stack;

import java.util.*;
public class Solution {


    class MyQueue {

        Stack<Integer> stack1,stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.add(x);
        }

        public int pop() {
            if(stack2.isEmpty()){
                while (!stack1.isEmpty())
                    stack2.add(stack1.pop());
            }

            return stack2.pop();
        }

        public int peek() {
            if(stack2.isEmpty()){
                while (!stack1.isEmpty())
                    stack2.add(stack1.pop());
            }

            return stack2.peek();
        }

        public boolean empty() {
            if(stack1.isEmpty() && stack2.isEmpty())
                return true;
            else
                return false;
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
