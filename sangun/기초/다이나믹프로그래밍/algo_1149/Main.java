package algo_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.min;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i < n; i++) {
            arr[i][0] = min(arr[i - 1][1], arr[i - 1][2]) + arr[i][0];
            arr[i][1] = min(arr[i - 1][0], arr[i - 1][2]) + arr[i][1];
            arr[i][2] = min(arr[i - 1][0], arr[i - 1][1]) + arr[i][2];
        }

        int min = min(arr[n - 1][0], arr[n - 1][1]);
        min = min(min, arr[n - 1][2]);
        System.out.println(min);

    }
}

