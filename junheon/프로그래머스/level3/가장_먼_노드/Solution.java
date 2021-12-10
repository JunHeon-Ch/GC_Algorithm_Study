package 프로그래머스.level3.가장_먼_노드;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/49189
 * 알고리즘: BFS
 * 시간복잡도: O(V*E) V: 2만, E: 5만 -> 10억
 */

class Solution {
    public int solution(int n, int[][] edge) {
        // 인접리스트
        List<Integer>[] adjList = new List[n];
        for(int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int i = 0; i < edge.length; i++) {
            adjList[edge[i][0] - 1].add(edge[i][1] - 1);
            adjList[edge[i][1] - 1].add(edge[i][0] - 1);
        }

        // 최단 거리 저장
        int[] d = new int[n];
        Arrays.fill(d, -1);
        // BFS
        Queue<Integer> q = new LinkedList<>();
        d[0] = 0;
        q.add(0);
        int max = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : adjList[now]) {
                if(d[next] != -1) continue;
                q.add(next);
                d[next] = d[now] + 1;
                max = Math.max(max, d[next]);
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(d[i] == max) ans++;
        }
        return ans;
    }
}