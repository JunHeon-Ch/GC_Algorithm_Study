package algo_14501;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int max = 0;
    static int[][] work;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        work = new int[n + 1][2];

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            work[i][0] = Integer.parseInt(st.nextToken());
            work[i][1] = Integer.parseInt(st.nextToken());
        }

        go(1, n, 0);
        bw.write(max + "\n");
        bw.close();
    }

    static void go(int index, int n, int ans) {
        // 항이 넘어갈때
        if (index > n + 1) {
            max = Math.max(ans, max);
            return;
        }
        // 맨 마지막항이 1일일때
        if (index == n) {
            int k = work[index][0];
            if (k == 1) ans += work[index][1];
            max = Math.max(ans, max);
            return;
        }
        int k = work[index][0];
        // 다음항이 마지막날에 끝날때
        if (index + k == n + 1) {
            go(index + 1, n, ans);
            ans += work[index][1];
            max = Math.max(ans, max);
            return;
        }
        // 이번항을 추가하고 다음항으로 넘어가지못할때
        if (index + k > n + 1) {
            max = Math.max(ans, max);
            go(index + 1, n, ans);
            return;
        }

        go(index + k, n, ans + work[index][1]);
        go(index + 1, n, ans);
    }
}