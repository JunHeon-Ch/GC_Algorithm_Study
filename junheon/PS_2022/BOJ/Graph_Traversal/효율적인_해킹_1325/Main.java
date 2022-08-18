package PS_2022.BOJ.Graph_Traversal.효율적인_해킹_1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/1325
 * 알고리즘: BFS
 * 시간복잡도: O(nm), n=100,000, m=1,000,000
 */

public class Main {

    static List<Integer>[] list;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
        }

        ans = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            bfs(i, n);
        }
        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, ans[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            if(max == ans[i]) sb.append(i + " ");
        }
        System.out.println(sb.toString());
    }

    static void bfs(int start, int n) {
        boolean[] visit = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        visit[start] = true;
        q.add(start);
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : list[now]) {
                if(visit[next]) continue;
                q.add(next);
                visit[next] = true;
                ans[next]++;
            }
        }
    }
}