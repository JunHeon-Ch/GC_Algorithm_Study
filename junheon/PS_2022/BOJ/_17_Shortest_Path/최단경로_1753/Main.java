package PS_2022.BOJ._17_Shortest_Path.최단경로_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://github.com/tony9402/baekjoon/tree/main/shortest_path
 * 알고리즘: 다익스트라
 * 시간복잡도: O(ElogE), E=300,000(간선의 개수)
 */

public class Main {

    static class Node {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        List<Node>[] list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(k, 0));
        dist[k] = 0;
        while (!q.isEmpty()) {
            Node v = q.poll();
            if (dist[v.idx] < v.cost) continue;
            for (Node next : list[v.idx]) {
                if (dist[next.idx] > dist[v.idx] + next.cost) {
                    dist[next.idx] = dist[v.idx] + next.cost;
                    q.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }
        System.out.println(sb.toString());
    }
}
