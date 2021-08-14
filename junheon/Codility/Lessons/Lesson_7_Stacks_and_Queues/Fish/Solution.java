package Codility.Lessons.Lesson_7_Stacks_and_Queues.Fish;

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) stack.push(i);
            else {
                int winner = i;
                while (!stack.isEmpty() && B[stack.peek()] == 1) {
                    int prev = stack.pop();
                    if (A[prev] < A[i]) winner = i;
                    else {
                        winner = prev;
                        break;
                    }
                    stack.push(winner);
                }
            }
        }
        return stack.size();
    }
}

