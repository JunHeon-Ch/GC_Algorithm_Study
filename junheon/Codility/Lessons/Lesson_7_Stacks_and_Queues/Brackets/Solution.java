package Codility.Lessons.Lesson_7_Stacks_and_Queues.Brackets;

import java.util.*;

class Solution {
    public int solution(String S) {
        if(S.length() == 0) return 1;
        if(S.length() % 2 == 1) return 0;

        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return 0;
                char top = stack.pop();
                if(c == ')') {
                    if(top != '(') return 0;
                } else if(c == '}') {
                    if(top != '{') return 0;
                } else if(c == ']') {
                    if(top != '[') return 0;
                }
            }
        }
        if(stack.isEmpty()) return 1;
        else return 0;
    }
}
