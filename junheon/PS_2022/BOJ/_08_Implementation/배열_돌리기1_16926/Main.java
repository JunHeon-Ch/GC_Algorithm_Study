package PS_2022.BOJ._08_Implementation.배열_돌리기1_16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/16926
 * 알고리즘: 구현
 * 시간복잡도: O(n*m), n=300(행), m=300(열)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (r-- > 0) {
            int r1 = 1;
            int c1 = 1;
            int r2 = n;
            int c2 = m;
            while ((r1 < r2) && (c1 < c2)) {
                int prev = arr[r1][c1];
                for(int i = r1 + 1; i <= r2; i++) {
                    int tmp = arr[i][c1];
                    arr[i][c1] = prev;
                    prev = tmp;
                }
                for(int j = c1 + 1; j <= c2; j++) {
                    int tmp = arr[r2][j];
                    arr[r2][j] = prev;
                    prev = tmp;
                }
                for(int i = r2 - 1; i >= r1; i--) {
                    int tmp = arr[i][c2];
                    arr[i][c2] = prev;
                    prev = tmp;
                }
                for(int j = c2 - 1; j >= c1; j--) {
                    int tmp = arr[r1][j];
                    arr[r1][j] = prev;
                    prev = tmp;
                }
                r1++;
                c1++;
                r2--;
                c2--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
