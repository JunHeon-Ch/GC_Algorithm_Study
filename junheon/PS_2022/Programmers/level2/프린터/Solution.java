package PS_2022.Programmers.level2.프린터;

import java.util.*;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * 알고리즘: 큐
 * 시간복잡도: O(n), n=100(대기목록 수)
 */

class Solution {
    public int solution(int[] p, int l) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < p.length; i++) {
            q.add(p[i]);
        }
        int loc = l;
        int ans = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            boolean flag = false;
            for(int i : q) {
                if(cur < i) {
                    flag = true;
                    break;
                }
            }
            if(flag) q.add(cur);
            else {
                ans++;
                if(loc == 0) break;
            }
            if(loc == 0) loc = q.size() - 1;
            else loc--;
        }
        return ans;
    }
}