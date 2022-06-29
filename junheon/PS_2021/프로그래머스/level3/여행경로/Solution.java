package PS_2021.프로그래머스.level3.여행경로;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/43164
 * 주어진 항공권을 모두 사용해야 한다는 조건을 기억하야 함
 * 알고리즘: DFS
 * 시간복잡도: O(n^2), n=10,000(공항의 수)
 */

class Solution {

    boolean[] visit;
    String[] ans;

    public String[] solution(String[][] tickets) {
        int n = tickets.length;
        // 알파벳순 소팅
        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[0].equals(o2[0])) return o1[1].compareTo(o2[1]);
            return o1[0].compareTo(o2[0]);
        });
        ans = new String[n + 1];
        visit = new boolean[n];
        ans[0] = "ICN";
        solve(1, n, tickets, "ICN");
        return ans;
    }

    // DFS
    public boolean solve(int idx, int n, String[][] tickets, String now) {
        // 모든 도시를 방문한 경우 -> 끝
        if(idx == n + 1) return true;
        for(int i = 0; i < n; i++) {
            if(!visit[i] && now.equals(tickets[i][0])) {
                ans[idx] = tickets[i][1];
                visit[i] = true;
                if(solve(idx + 1, n, tickets, tickets[i][1])) return true;
                visit[i] = false;
            }
        }
        // 모든 도시를 방문하지 못한 경우
        return false;
    }
}