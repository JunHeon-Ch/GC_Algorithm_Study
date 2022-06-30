package PS_2022.Programmers.level2.짝지어_제거하기;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/12973
 * 알고리즘: 스택
 * 시간복잡도: O(n), n=1,000,000(문자열 길이)
 */
class Solution {
    public int solution(String s) {
        char[] str = s.toCharArray();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(int i = 0; i < str.length; i++) {
            stack1.push(str[i]);
        }

        while(!stack1.isEmpty()) {
            char c1 = stack1.pop();
            if(stack2.isEmpty()) stack2.push(c1);
            else {
                char c2 = stack2.pop();
                if(c1 != c2) {
                    stack2.push(c2);
                    stack2.push(c1);
                }
            }
        }
        if(stack2.isEmpty()) return 1;
        else return 0;
    }
}