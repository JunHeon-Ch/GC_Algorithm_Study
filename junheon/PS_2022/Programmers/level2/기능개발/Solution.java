package PS_2022.Programmers.level2.기능개발;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/42586
 * 알고리즘: 구현
 * 시간복잡도: O(n), n=100(작업의 개수)
 */
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        int[] res = new int[len];
        res[0] = (int)Math.ceil((double)(100 - progresses[0]) / speeds[0]);
        for(int i = 1; i < len; i++) {
            res[i] = Math.max(res[i - 1], (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]));
        }

        List<Integer> ans = new ArrayList<>();
        int prev = res[0];
        int cnt = 1;
        for(int i = 1; i < len; i++) {
            if(res[i] == prev) cnt++;
            else {
                ans.add(cnt);
                prev = res[i];
                cnt = 1;
            }
        }
        ans.add(cnt);
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
