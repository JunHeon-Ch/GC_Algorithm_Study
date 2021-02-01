package algo_1167;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int node;
        int weight;

        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

    }

    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    static int[] dist;
    static ArrayList<Node>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        for (int i = 0; i < n + 1; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) break;
                int c = Integer.parseInt(st.nextToken());
                tree[a].add(new Node(b, c));
            }
        }
        bfs(1);
        int start = 1;
        for (int i = 2; i <= n; i++) {
            if (dist[i] > dist[start]) {
                start = i;
            }
        }
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        bfs(start);
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }
        bw.write(max + "\n");
        bw.close();
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < tree[x].size(); i++) {
                if (!visited[tree[x].get(i).node]) {
                    dist[tree[x].get(i).node] = dist[x] + tree[x].get(i).weight;
                    q.offer(tree[x].get(i).node);
                    visited[tree[x].get(i).node] = true;
                }
            }
        }
    }


}
