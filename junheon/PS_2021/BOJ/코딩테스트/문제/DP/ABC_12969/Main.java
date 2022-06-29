// Top-down
// D(n, m, l, k) = 문자열의 길이가 n이고, 'A', 'B'의 갯수가 각각 m, l개일 때,
// S[i] < S[j]를 만족하는 (i, j)쌍의 갯수가 K인 문자열이 존재하는지 여부
// d[n][a][b][k] = (d[n - 1][a - 1][b][k] || d[n - 1][a][b - 1][k - a] || d[n - 1][a][b][k - a - b])

package PS_2021.BOJ.코딩테스트.문제.DP.ABC_12969;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][][][] d;
    static char[] s;
    static int N, K;

    public static boolean solve(int n, int a, int b, int k) {
        if(n == N) {
            if(k == K) return true;
            else return false;
        }
        if(d[n][a][b][k]) return false;
        d[n][a][b][k] = true;

        s[n] = 'A';
        if(solve(n + 1, a + 1, b, k)) return true;
        s[n] = 'B';
        if(solve(n + 1, a, b + 1, k + a)) return true;
        s[n] = 'C';
        if(solve(n + 1, a, b, k + a + b)) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        d = new boolean[N + 1][N + 1][N + 1][(N * (N - 1) / 2) + 1];
        s = new char[N];
        if(solve(0, 0, 0, 0)) System.out.println(new String(s));
        else System.out.println(-1);
    }
}
