package algo_2667;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] h = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                h[i][j] = str.charAt(j) - '0';
            }
        }
        int ans = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (h[i][j] == 1) {
                    dfs(h, n, i, j);
                    ans++;
                    result.add(cnt);
                    cnt = 0;
                }
            }
        }
        result.sort(Comparator.naturalOrder());
        bw.write(ans + "\n");
        for (int k : result) bw.write(k + "\n");
        bw.close();

    }

    static void dfs(int[][] arr, int n, int x, int y) {
        if (arr[x][y] == 0) return;
        cnt++;
        arr[x][y] = 0;

        if (x + 1 < n) dfs(arr, n, x + 1, y);
        if (y + 1 < n) dfs(arr, n, x, y + 1);
        if (x - 1 >= 0) dfs(arr, n, x - 1, y);
        if (y - 1 >= 0) dfs(arr, n, x, y - 1);


    }
}


