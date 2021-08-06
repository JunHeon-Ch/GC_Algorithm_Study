package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 세친구 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int ans = Integer.MAX_VALUE;
        boolean[][] map = new boolean[n][n];
        int[] cnt = new int[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a - 1][b - 1] = true;
            map[b - 1][a - 1] = true;
            cnt[a - 1]++;
            cnt[b - 1]++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (map[i][j]) {
                    for (int k = j + 1; k < n; k++) {
                        if (map[i][k] && map[j][k]) {
                            ans = Math.min(ans, cnt[i] + cnt[j] + cnt[k] - 6);
                        }
                    }
                }
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

    }


}
