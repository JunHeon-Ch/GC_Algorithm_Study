package 푼문제;

import java.util.Arrays;
import java.util.Collections;

public class 등굣길 {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        int[][] map = new int[n + 1][m + 1];
        for (int[] p : puddles) {
            map[p[1]][p[0]] = -1;
        }

        int div = 1000000007;
        map[1][1] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (map[i][j] == -1) continue;

                if (map[i - 1][j] != -1)
                    map[i][j] += (map[i - 1][j] % div);
                if (map[i][j - 1] != -1) {
                    map[i][j] += (map[i][j - 1] % div);
                }
                map[i][j] %= div;
            }
        }

        System.out.println(Arrays.toString(map[n]));
        System.out.println(map[n][m]);
    }

}
