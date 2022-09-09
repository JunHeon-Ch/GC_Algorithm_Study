package PS_2022.BOJ._17_Shortest_Path.특정_거리의_도시_찾기_18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/18352
 * 알고리즘: BFS
 * 시간복잡도: O(V+E), V=300,000(도시의 개수), E=1,000,000(도로의 개수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
        }

        boolean v[] = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        v[x] = true;
        int cnt = 0;
        Queue<Integer> ans = new PriorityQueue<>();
        while(!q.isEmpty()) {
            int size = q.size();
            cnt++;
            while(size-- > 0) {
                int now = q.poll();
                for(int next : list[now]) {
                    if(v[next]) continue;
                    q.add(next);
                    v[next] = true;
                }
            }
            if(cnt == k) {
                while(!q.isEmpty()) ans.add(q.poll());
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(ans.size() == 0) sb.append(-1);
        else {
            while(!ans.isEmpty()) sb.append(ans.poll() + "\n");
        }
        System.out.println(sb.toString());
    }
}
