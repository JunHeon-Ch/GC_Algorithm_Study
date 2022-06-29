package PS_2021.프로그래머스.level2.괄호_회전하기;

import java.util.Stack;

class Solution {
    public int solution(String s) {
        int n = s.length();
        if(n % 2 != 0) return 0;

        s += s.substring(0, n - 1);
        int answer = 0;
        for(int i = 0; i < n; i++) {
            String sub = s.substring(i, n + i);
            if(check(sub)) answer++;
        }
        return answer;
    }

    private boolean check(String s) {
        String open = "({[";
        String close = ")}]";
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(open.contains(c + "")) stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(open.indexOf(top + "") != close.indexOf(c + ""))
                    return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}