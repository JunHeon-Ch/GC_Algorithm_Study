package algo_2178;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        bfs(map, 0, 0, n, m);

        bw.write(map[n - 1][m - 1] + "\n");
        bw.close();

    }

    static void bfs(int[][] map, int x, int y, int n, int m) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(x);
        qy.add(y);
        while (!(qx.isEmpty() && qy.isEmpty())) {
            int x1 = qx.poll();
            int y1 = qy.poll();
            for (int i = 0; i < 4; i++) { // 오른쪽 아래 왼쪽 위 돌아가며 탐색
                int x2 = x1 + dx[i];// 0,1,0,-1
                int y2 = y1 + dy[i]; // 1,0,-1,0
                if (x2 >= 0 && y2 >= 0 && x2 < n && y2 < m) {
                    if (map[x2][y2] == 1) { // 미방문
                        qx.add(x2);
                        qy.add(y2);
                        map[x2][y2] = map[x1][y1] + 1;
                    }
                }

            }

        }
    }
}