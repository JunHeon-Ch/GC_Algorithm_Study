package 프로그래머스.level3.가장_먼_노드;

import java.util.*;

class Solution1 {
    public int solution(int n, int[][] edge) {
        LinkedList<Integer>[] edges = new LinkedList[n + 1];
        for(int i = 1; i <= n; i++) {
            edges[i] = new LinkedList<>();
        }
        for(int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            edges[u].add(v);
            edges[v].add(u);
        }

        int[] d = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()) {
            int s = q.poll();
            for(int nn : edges[s]) {
                if(d[nn] != 0) continue;
                d[nn] = d[s] + 1;
                q.offer(nn);
            }
        }

        int max = 0;
        int ans = 0;
        for(int i = 2; i <= n; i++) {
            if(d[i] == 0) continue;
            if(max == d[i]) ans++;
            else if(max < d[i]) {
                ans = 1;
                max = d[i];
            }
        }
        return ans;
    }
}