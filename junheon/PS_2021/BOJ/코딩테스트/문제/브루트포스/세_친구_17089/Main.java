package PS_2021.BOJ.코딩테스트.문제.브루트포스.세_친구_17089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[][] relation;
    static int[] fNum, friend;
    static int ans = -1;

    public static void solve(int index, int prev, int n) {
        if (index == 3) {
            if (relation[friend[1]][friend[2]]) {
                int res = -6;
                for (int i = 0; i < 3; i++) {
                    res += fNum[friend[i]];
                }
                if (ans == -1 || ans > res) ans = res;
            }
            return;
        }
        for (int i = prev + 1; i <= N; i++) {
            if (relation[n][i]) {
                friend[index] = i;
                solve(index + 1, i, n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        relation = new boolean[N + 1][N + 1];
        fNum = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            relation[u][v] = relation[v][u] = true;
            fNum[u]++;
            fNum[v]++;
        }

        friend = new int[3];
        for (int i = 1; i <= N; i++) {
            if (fNum[i] > 1) {
                friend[0] = i;
                solve(1, i, i);
            }
        }
        System.out.println(ans);
    }
}