package PS_2022.BOJ._08_Implementation.배열_돌리기_17276;

import java.io.*;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/17276
 * 알고리즘: 구현
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int rot = Integer.parseInt(st.nextToken()) / 45;
            int[][] arr = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int m, prev, tmp;
            if (rot > 0) {
                while (rot-- > 0) {
                    int r = 1, c = n;
                    while (r < c) {
                        m = (r + c) / 2;
                        tmp = arr[r][m];
                        arr[r][m] = arr[r][r];
                        prev = tmp;

                        tmp = arr[r][c];
                        arr[r][c] = prev;
                        prev = tmp;

                        tmp = arr[m][c];
                        arr[m][c] = prev;
                        prev = tmp;

                        tmp = arr[c][c];
                        arr[c][c] = prev;
                        prev = tmp;

                        tmp = arr[c][m];
                        arr[c][m] = prev;
                        prev = tmp;

                        tmp = arr[c][r];
                        arr[c][r] = prev;
                        prev = tmp;

                        tmp = arr[m][r];
                        arr[m][r] = prev;
                        prev = tmp;

                        arr[r][r] = prev;
                        r++;
                        c--;
                    }
                }
            } else {
                while (rot++ < 0) {
                    int r = 1, c = n;
                    while (r < c) {
                        m = (r + c) / 2;

                        tmp = arr[m][r];
                        arr[m][r] = arr[r][r];
                        prev = tmp;

                        tmp = arr[c][r];
                        arr[c][r] = prev;
                        prev = tmp;

                        tmp = arr[c][m];
                        arr[c][m] = prev;
                        prev = tmp;

                        tmp = arr[c][c];
                        arr[c][c] = prev;
                        prev = tmp;

                        tmp = arr[m][c];
                        arr[m][c] = prev;
                        prev = tmp;

                        tmp = arr[r][c];
                        arr[r][c] = prev;
                        prev = tmp;

                        tmp = arr[r][m];
                        arr[r][m] = prev;
                        prev = tmp;

                        arr[r][r] = prev;

                        r++;
                        c--;
                    }
                }
            }

            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    bw.write(arr[i][j] + " ");
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
