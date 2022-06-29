package PS_2021.프로그래머스.level3._110_옮기기;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/77886
 * 알고리즘: 스택
 * 시간복잡도: O(nm), n=1,000,000(s 배열의 길이), m=1,000,000(s의 각 원소의 길이)
 */

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for(int i = 0; i < s.length; i++) {
            String str = s[i];
            Stack<Character> stack = new Stack<>();
            int cnt = 0; // "110"이 나오는 개수

            // stack에 계속 집어 넣으면서 "110"이 되면 pop & cnt++
            for(char c : str.toCharArray()) {
                if(c == '0') {
                    if(stack.size() < 2) {
                        stack.push(c);
                        continue;
                    }
                    char c1 = stack.pop();
                    char c2 = stack.pop();
                    if(c1 == '1' && c2 == '1') {
                        cnt++;
                        continue;
                    }
                    else {
                        stack.push(c2);
                        stack.push(c1);
                    }
                }
                stack.push(c);
            }

            // 가장 뒤에 나타나는 0의 위치를 찾는다.
            // 110보다 큰 값은 111밖에 없다. 따라서 0이 나왔다는건 110이 스택 내에 없기 때문에 0 뒤에 붙이는게 가장 작은 값이다.
            int idx = stack.size();
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) {
                if(!flag) {
                    if(stack.peek() == '1') idx--;
                    else flag = true;
                }
                sb.insert(0, stack.pop());
            }
            while(cnt > 0) {
                sb.insert(idx, "110");
                cnt--;
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}