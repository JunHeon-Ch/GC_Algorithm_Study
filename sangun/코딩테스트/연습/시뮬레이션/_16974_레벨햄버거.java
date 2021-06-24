import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16974_레벨햄버거 {
    static long[][] memo = new long[51][2];
    static long x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        x = Long.parseLong(st.nextToken());

        // 햄버거 재료수
        memo[0][0] = 1;
        // 패티수
        memo[0][1] = 1;

//        dp(50);

        // 햄버거 개수 구하기
        // 패티 개수 구하기
        for (int i = 1; i <= n; i++) {
            memo[i][0] = memo[i - 1][0] * 2 + 3;
            memo[i][1] = memo[i - 1][1] * 2 + 1;
        }

        System.out.println(solve(n, x));


    }

//    static long dp(int n) {
//        if (n < 1) return 0;
//        if (n == 1) return 5;
//        if (memo[n][0] != 0) return memo[n][0];
//        return memo[n][0] = dp(n - 1) * 2 + 3;
//    }

    static long solve(int n, long x) {
        if (n == 0) {
            if (x == 0) return 0;
            else if (x == 1) return 1;
        }

        if (x == 1)
            return 0; // 무조건 햄버거 번
        else if (x <= 1 + memo[n - 1][0]) // 전 햄버거 재료수의 번보다 작거나 같은 경우
            return solve(n - 1, x - 1);
        else if (x == 1 + memo[n - 1][0] + 1) // 전 햄버거 재료 수의 번 + 패티와 같을 경우
            return memo[n - 1][1] + 1;
        else if (x <= 1 + memo[n - 1][0] + 1 + memo[n - 1][0]) // 전 햄버거 재료 수 + 번 + 패티 +이전 햄버거 재료수 보다 작은 경우
            return 1 + memo[n - 1][1] + solve(n - 1, x - 1 - memo[n - 1][0] - 1);
        else // 전 햄버거 재료수 + 번 + 패티 + 이전 햄버거 재료수 +번 인 경우
            return 2 * memo[n - 1][1] + 1;

    }



}
