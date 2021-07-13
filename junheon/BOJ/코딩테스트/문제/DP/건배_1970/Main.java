package BOJ.코딩테스트.문제.DP.건배_1970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] brand;
    static int[][] d;
    static boolean[][] c;

    public static int solve(int s, int e) {
        if(s >= e) return 1;
        if(c[s][e]) return d[s][e];
        c[s][e] = true;
        for(int k = s + 1; k <= e; k++) {
            if(brand[s] == brand[k]) {
                int res = solve(s + 1, k - 1) + solve(k + 1, e);
                d[s][e] = Math.max(d[s][e], res);
            }
        }
        return d[s][e];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        brand = new int[n];
        for(int i = 0; i < n; i++) {
            brand[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        d = new int[n][n];
        c = new boolean[n][n];
        System.out.println(solve(0, n - 1));
    }
}
