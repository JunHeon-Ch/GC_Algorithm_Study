package 푼문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 색종이붙이기 {
    static int[][] map;
    static int ans = Integer.MAX_VALUE;
    static int[] cnt = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        map = new int[10][10];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.fill(cnt, 5);
        dfs(0, 0, 0);
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);


    }

    static void dfs(int x, int y, int count) {
        if (x == 10 && y == 0) {
            ans = Math.min(ans, count);
            return;
        }

        if (count > ans) {
            return;
        }
        if (y > 9) {
            dfs(x + 1, 0, count);
            return;
        }
        if (map[x][y] == 1) {
            for (int i = 5; i >= 1; i--) {
                if (cnt[i] > 0 && isValid(x, y, i)) {
                    attach(x, y, i, 0);
                    cnt[i]--;
                    dfs(x, y + 1, count + 1);
                    cnt[i]++;
                    attach(x, y, i, 1);
                }
            }
        } else {
            dfs(x, y + 1, count);
        }

    }
    static void attach(int x, int y, int size, int v) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = v;
            }
        }
    }

    static boolean isValid(int x, int y, int cnt) {

        for (int i = x; i < x + cnt; i++) {
            for (int j = y; j < y + cnt; j++) {
                if (i >= 10 || j >= 10 || map[i][j] != 1) return false;
            }
        }
        return true;

    }

}
