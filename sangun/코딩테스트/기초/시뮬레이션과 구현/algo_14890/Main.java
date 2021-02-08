package algo_14890;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n;
    static int l;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (go(i, 0, 0)) {
                count++;
            }
            if (go(0, i, 1)) {
                count++;
            }
        }
        bw.write(count+"\n");
        bw.close();
    }

    static boolean go(int x, int y, int dir) {
        boolean[] visited = new boolean[n];
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            // row
            if (dir == 0) {
                height[i] = map[x][y + i];
            } else { // column
                height[i] = map[x + i][y];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (height[i] == height[i + 1]) {
                continue;
            }

            if (Math.abs(height[i] - height[i + 1]) > 1) {
                return false;
            }

            if (height[i] - 1 == height[i + 1]) {
                for (int j = i + 1; j <= i + l; j++) {
                    if (j >= n || visited[j] || height[j] != height[i + 1]) {
                        return false;
                    }
                    visited[j] = true;
                }
            } else if (height[i] + 1 == height[i + 1]) {
                for (int j = i; j > i - l; j--) {
                    if (j < 0 || visited[j] || height[j] != height[i]) {
                        return false;
                    }
                    visited[j] = true;
                }
            }

        }
        return true;
    }
}

