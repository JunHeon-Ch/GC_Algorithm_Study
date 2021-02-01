package algo_1697;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] dx = {-1, 1, 0};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        bfs(n, k);
        bw.write(cnt + "\n");
        bw.close();
    }

    static void bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int t = 0; t < size; t++) {
                int x = q.poll();
                int x1;
                if (x == k) return;
                for (int i = 0; i < 3; i++) {
                    if (dx[i] == 0) x1 = x * 2;
                    else x1 = x + dx[i];
                    if (x1 > 100000) continue;
                    if (x1 < 0) continue;
                    if (visited[x1]) continue;
                    q.offer(x1);
                    visited[x1] = true;
                }
            }
            cnt++;
        }
    }
}

