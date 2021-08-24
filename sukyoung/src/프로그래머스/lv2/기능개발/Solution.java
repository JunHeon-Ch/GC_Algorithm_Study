package 프로그래머스.lv2.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = progresses.length - 1; i >= 0; i--){
            int time = (int) Math.ceil((double)(100 - progresses[i])/speeds[i]);
            stack.add(time);
        }

        List<Integer> ans = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            int cnt = 1;
            int top = stack.pop();

            while (!stack.isEmpty() && stack.peek() <= top) {
                cnt++;
                stack.pop();
            }

            ans.add(cnt);
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
