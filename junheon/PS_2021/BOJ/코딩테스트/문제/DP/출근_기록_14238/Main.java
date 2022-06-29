// Top-down
// D(s, a, b, c, bch, bbch) = 문자열의 길이가 s이고, 'A', 'B', 'C' 개수가 각각 a, b, c일 때,
// 'B' 다음에 'B'가 오는 경우, 'C' 다음과 다다음에 'C'가 오는 경우를 제외하고 가능한 수열이 있는지 여부
// d[s][a][b][c][bch][bbch] = (d[s - 1][a - 1][b][c][bch][bbch] || d[s - 1][a][b - 1][c][bch][bbch] || d[s - 1][a][b][c][bch][bbch])

package PS_2021.BOJ.코딩테스트.문제.DP.출근_기록_14238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean d[][][][][];
    static int S;
    static char[] ans;

    public static boolean solve(int s, int a, int b, int c, char before, char bbfore) {
        if (a == 0 && b == 0 && c == 0) return true;
        if (d[a][b][c][before - 'A'][bbfore - 'A']) return false;
        d[a][b][c][before - 'A'][bbfore - 'A'] = true;

        if (a > 0) {
            ans[s] = 'A';
            if (solve(s + 1, a - 1, b, c, 'A', before)) return true;
        }
        if (b > 0 && before != 'B') {
            ans[s] = 'B';
            if (solve(s + 1, a, b - 1, c, 'B', before)) return true;
        }
        if (c > 0 && before != 'C' && bbfore != 'C') {
            ans[s] = 'C';
            if (solve(s + 1, a, b, c - 1, 'C', before)) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        S = str.length();
        int A = 0, B = 0, C = 0;
        for (int i = 0; i < S; i++) {
            if (str.charAt(i) == 'A') A++;
            else if (str.charAt(i) == 'B') B++;
            else if (str.charAt(i) == 'C') C++;
        }
        d = new boolean[S + 1][S + 1][S + 1][4][4];
        ans = new char[S];
        if (solve(0, A, B, C, 'D', 'D')) System.out.println(ans);
        else System.out.println(-1);
    }
}
