package 프로그래머스.level3.네트워크;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/43162
 * 알고리즘: 인접리스트 BFS
 * 시간복잡도: O(n^2) n: 200
 */

class Solution {
    public int solution(int n, int[][] computers) {
        // 인접리스트 생성
        List<Integer>[] net = new List[n];
        for(int i = 0; i < n; i++) {
            net[i] = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                if(i == j || computers[i][j] == 0) continue;
                net[i].add(j);
            }
        }
        // 방문 여부 확인
        boolean[] visit = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(visit[i]) continue;
            bfs(i, n, net, visit);
            answer++;
        }
        return answer;
    }

    public void bfs(int s, int n, List<Integer>[] net, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = true;
        while(!q.isEmpty()) {
            int c = q.poll();
            for(int i : net[c]) {
                if(vis[i]) continue;
                vis[i] = true;
                q.add(i);
            }
        }
    }
}

