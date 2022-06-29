package PS_2021.BOJ.코딩테스트.문제.브루트포스.파이프_옮기기1_17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] house;
    static int ans = 0;

    public static void solve(int x, int y, int prev) {
        if (x >= N || y >= N || house[x][y] == 1) return;
        if (x == N - 1 && y == N - 1) {
            ans++;
            return;
        }
        if (prev == 1) { // 가로
            if(y + 1 < N && house[x][y + 1] == 0) solve(x, y + 1, 1);
            if(x + 1 < N && y + 1 < N && house[x + 1][y] == 0 && house[x][y + 1] == 0 && house[x + 1][y + 1] == 0)
                solve(x + 1, y + 1, 3);
        } else if (prev == 2) { // 세로
            if(x + 1 < N && house[x + 1][y] == 0) solve(x + 1, y, 2);
            if(x + 1 < N && y + 1 < N && house[x + 1][y] == 0 && house[x][y + 1] == 0 && house[x + 1][y + 1] == 0)
            solve(x + 1, y + 1, 3);
        } else if(prev == 3) {
            if(y + 1 < N && house[x][y + 1] == 0) solve(x, y + 1, 1);
            if(x + 1 < N && house[x + 1][y] == 0) solve(x + 1, y, 2);
            if(x + 1 < N && y + 1 < N && house[x + 1][y] == 0 && house[x][y + 1] == 0 && house[x + 1][y + 1] == 0)
            solve(x + 1, y + 1, 3);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        house = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 1, 1);
        System.out.println(ans);
    }
}
