// Top-down
// D(n, m) = n번째부터 m번째까지 팰린드롬이 되기 위해 추가되는 수의 갯수
// d[i][j] = min(d[i + 1][j], d[i][j - 1]) if a[i] != a[j], 0 <= i <= j < n
// d[i][j] = d[i + 1][j - 1] if a[i] == a[j], 0 <= i <= j < n

package PS_2021.BOJ.코딩테스트.문제.DP.팰린드롬_만들기_1695;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] num;
    static int[][] d;

    public static int solve(int s, int e) {
        if(s >= e) return 0;
        if(d[s][e] != -1) return d[s][e];
        if(num[s] == num[e]) return d[s][e] = solve(s + 1, e - 1);
        else return d[s][e] = Math.min(solve(s + 1, e), solve(s, e - 1)) + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[n];
        d = new int[n][n];
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                d[i][j] = -1;
            }
        }
        int ans = solve(0, n - 1);
        System.out.println(ans);
    }
}
