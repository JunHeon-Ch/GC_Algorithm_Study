package 프로그래머스.lv2.짝지어제거하기;

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<Character>();

        char[] char_set = s.toCharArray();
        for(char c : char_set){
            if(!stack.isEmpty() && c == stack.peek()){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }

        if(stack.size() == 0) answer = 1;
        else answer = 0;

        return answer;
    }
}
