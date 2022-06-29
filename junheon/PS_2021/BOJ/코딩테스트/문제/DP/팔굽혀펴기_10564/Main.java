// Bottom-up
// D(n, m) = n번 푸쉬업으로 m의 점수를 얻을 수 있는지

package PS_2021.BOJ.코딩테스트.문제.DP.팔굽혀펴기_10564;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] score;
    static boolean[][] d;

    public static void solve(int i, int j) {
        if(i > n) return;
        if(d[i][j]) return;
        d[i][j] = true;
        for(int k = 0; k < m; k++) {
            solve(i + j + score[k], j + score[k]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while(t > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            score = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++) {
                score[i] = Integer.parseInt(st.nextToken());
            }

            d = new boolean[n + 1][n + 1];
            solve(0, 0);
            int ans = -1;
            for(int i = n; i >= 0; i--) {
                if(d[n][i]) {
                    ans = i;
                    break;
                }
            }
            bw.write(ans + "\n");
            t--;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
