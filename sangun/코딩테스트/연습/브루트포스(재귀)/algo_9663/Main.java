package algo_9663;

import java.io.*;

public class Main {
    static int n;
    static int[] vx = new int[16];
    static int[] vy = new int[16];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dfs(0, i);
        }
        bw.write(ans + "\n");
        bw.close();
    }

    static int dfs(int x, int y) {
        for (int i = 0; i < x; i++) {
            if (x == vx[i]) return 0; // 가로
            if (y == vy[i]) return 0; // 세로
            if (Math.abs(x - vx[i]) == Math.abs(y - vy[i])) return 0; // 대각선
        }

        if (x == n - 1) {
            return 1;
        }

        // 퀸의 위치 저장
        vx[x] = x;
        vy[x] = y;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += dfs(x + 1, i);
        }
        return cnt;

    }
}
