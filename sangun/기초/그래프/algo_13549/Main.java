package algo_13549;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] visited = new int[100001];
    static int cnt = 0;
    static int[] dx = {-1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        bfs(n, k);
        bw.write(visited[k] - 1 + "\n");
        bw.close();


    }

    static void bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int x = q.poll();
                int x1;
                if (x == k) return;
                for (int j = 0; j < 3; j++) {
                    if (j == 2) x1 = x * 2;
                    else x1 = x + dx[j];
                    if (x1 > 100000) continue;
                    if (x1 < 0) continue;
                    if (dx[j] == 0) {
                        if (visited[x1] == 0) {
                            visited[x1] = visited[x];
                            q.offer(x1);
                        } else if (visited[x1] > visited[x]) {
                            visited[x1] = visited[x];
                            q.offer(x1);
                        }
                    } else {
                        if (visited[x1] == 0) {
                            visited[x1] = visited[x] + 1;
                            q.offer(x1);
                        } else if (visited[x1] > visited[x] + 1) {
                            visited[x1] = visited[x] + 1;
                            q.offer(x1);
                        }
                    }
                }
            }
        }

    }
}
