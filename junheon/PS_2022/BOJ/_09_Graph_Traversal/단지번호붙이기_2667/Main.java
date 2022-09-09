package PS_2022.BOJ._09_Graph_Traversal.단지번호붙이기_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/2667
 * 알고리즘: BFS
 * 시간복잡도: O(n^2), n=25(행,열)
 */

public class Main {

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static char[][] board;
    static int[][] complex;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        for(int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        complex = new int[n][n];
        int num = 0;
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(complex[i][j] != 0 || board[i][j] == '0') continue;
                answer.add(bfs(i, j, ++num));
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(num + "\n");
        for(int ans : answer) {
            sb.append(ans + "\n");
        }
        System.out.println(sb.toString());
    }

    static int bfs(int x, int y, int num) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y));
        complex[x][y] = num;
        int cnt = 1;
        while(!q.isEmpty()) {
            Pos now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(board[nx][ny] == '0' || complex[nx][ny] != 0) continue;
                q.add(new Pos(nx, ny));
                complex[nx][ny] = num;
                cnt++;
            }
        }
        return cnt;
    }
}
