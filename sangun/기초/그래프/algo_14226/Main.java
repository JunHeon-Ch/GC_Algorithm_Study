package algo_14226;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Node {
        int s;
        int c;

        Node(int s, int c) {
            this.s = s;
            this.c = c;
        }
    }

    static int[][] visited;
    static Queue<Node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        visited = new int[1001][1001];
        for (int[] k : visited) Arrays.fill(k, -1);
        q = new LinkedList<>();

        visited[1][0] = 0;
        q.offer(new Node(1, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            int s = now.s;
            int c = now.c;
            if (visited[s][s] == -1) {
                visited[s][s] = visited[s][c] + 1;
                q.offer(new Node(s, s));
            }
            if (s + c <= n && visited[s + c][c] == -1) {
                visited[s + c][c] = visited[s][c] + 1;
                q.offer(new Node(s + c, c));
            }
            if (s - 1 >= 0 && visited[s - 1][c] == -1) {
                visited[s - 1][c] = visited[s][c] + 1;
                q.offer(new Node(s - 1, c));
            }

        }
        int ans = -1;
        for (int i = 0; i <= n; i++) {
            if (visited[n][i] != -1) {
                if (ans == -1 || ans > visited[n][i]) {
                    ans = visited[n][i];
                }
            }
        }
        bw.write(ans + "\n");
        bw.close();

    }

}