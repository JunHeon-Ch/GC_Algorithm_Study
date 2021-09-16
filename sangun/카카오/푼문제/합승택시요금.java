package 푼문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 합승택시요금 {

    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        ArrayList<Pair>[] edge = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < fares.length; i++) {
            int f = fares[i][0];
            int e = fares[i][1];
            int dist = fares[i][2];

            edge[f].add(new Pair(e, dist));
            edge[e].add(new Pair(f, dist));

        }

        int[] d1 = new int[n + 1];
        int[] d2 = new int[n + 1];
        int[] d = new int[n + 1];
        Arrays.fill(d1, Integer.MAX_VALUE);
        Arrays.fill(d2, Integer.MAX_VALUE);
        Arrays.fill(d, Integer.MAX_VALUE);

        dijkstra(a, d1, edge);
        System.out.println(Arrays.toString(d1));
        dijkstra(b, d2, edge);
        System.out.println(Arrays.toString(d2));
        dijkstra(s, d, edge);
        System.out.println(Arrays.toString(d));

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, d1[i] + d2[i] + d[i]);
        }
        System.out.println(answer);

    }

    static void dijkstra(int start, int[] d, ArrayList<Pair>[] edge) {
        d[start] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int v = p.v;
            int dist = p.d;

            if (d[v] < dist) continue;
            for (int i = 0; i < edge[v].size(); i++) {
                int next = edge[v].get(i).v;
                int nextDist = edge[v].get(i).d + dist;

                if (nextDist < d[next]) {
                    d[next] = nextDist;
                    pq.add(new Pair(next, nextDist));
                }
            }

        }
    }

    static class Pair implements Comparable<Pair> {
        int v, d;

        public Pair(int v, int d) {
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Pair o) {
            return this.d - o.d;
        }
    }

    static void floydWarshall(int n, int[][] edges) {
        int[][] d = edges.clone();

        // k = 거처가는 노드
        for (int k = 0; k < n; k++) {
            // i = 출발 노드
            for (int i = 0; i < n; i++) {
                // j = 도착 노드
                for (int j = 0; j < n; j++) {
                    if (d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
    }
}
