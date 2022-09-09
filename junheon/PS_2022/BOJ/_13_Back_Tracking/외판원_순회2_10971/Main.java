package PS_2022.BOJ._13_Back_Tracking.외판원_순회2_10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/10971
 * 알고리즘: 완전탐색
 * 시간복잡도: O(n^n), n=10(도시의 수)
 -> 왜 시간초과가 안 나는지 모르겠음
 */

public class Main {

    static int n;
    static int[][] board;
    static boolean[] visit;
    static int[] seq;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visit = new boolean[n];
        seq = new int[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0);
        System.out.println(ans);
    }

    static void solve(int index) {
        if(index == n) {
            if(board[seq[n - 1]][seq[0]] == 0) return;
            int res = 0;
            for(int i = 1; i < n; i++) {
                res += board[seq[i - 1]][seq[i]];
            }
            ans = Math.min(ans, res + board[seq[n - 1]][seq[0]]);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(visit[i]) continue;
            if(index > 0 && board[seq[index - 1]][i] == 0) continue;
            visit[i] = true;
            seq[index] = i;
            solve(index + 1);
            visit[i] = false;
        }
    }
}
