package algo_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] table = new int[n][3];
        int min;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    if (table[i][j] + table[i - 1][1] <= table[i][j] + table[i - 1][2]) {
                        table[i][j] = table[i][j] + table[i - 1][1];
                    } else {
                        table[i][j] = table[i][j] + table[i - 1][2];
                    }
                } else if (j == 1) {
                    if (table[i][j] + table[i - 1][0] <= table[i][j] + table[i - 1][2]) {
                        table[i][j] = table[i][j] + table[i - 1][0];
                    } else {
                        table[i][j] = table[i][j] + table[i - 1][2];
                    }
                } else {
                    if (table[i][j] + table[i - 1][0] <= table[i][j] + table[i - 1][1]) {
                        table[i][j] = table[i][j] + table[i - 1][0];
                    } else {
                        table[i][j] = table[i][j] + table[i - 1][1];
                    }
                }
            }
        }
        min = table[n - 1][0];
        for (int j = 1; j < 3; j++) {
            if (table[n - 1][j] < min) {
                min = table[n - 1][j];
            }
        }
        System.out.println(min);
    }
}

