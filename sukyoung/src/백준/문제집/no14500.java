package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14500 {
    public static boolean[][] visit;
    public static int n, m;
    public static int[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;
        visit = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dfs(0, i, j, 0);
                wing(i, j);
            }
        }

        System.out.println(max);

    }
    public static void dfs(int depth, int row, int col, int sum){
        if(depth == 4){
            max = Math.max(max, sum);
            return;
        }
        for(int i=0; i<4; i++){
            int next_row = row + dx[i];
            int next_col = col + dy[i];

            if(next_row < 0 || next_col < 0 || next_row >= n || next_col >= m)
                continue;
            if(visit[next_row][next_col])
                continue;

            visit[next_row][next_col] = true;
            dfs(depth + 1, next_row, next_col, sum + map[next_row][next_col]);
            visit[next_row][next_col] = false;
        }
    }
    public static void wing(int row, int col){
        int wing = 4;
        int min = Integer.MAX_VALUE;
        int sum = map[row][col];

        for(int i=0; i<4; i++){
            int next_row = row + dx[i];
            int next_col = col + dy[i];

            if(wing <= 2)
                return;
            if(next_row < 0 || next_col < 0 || next_row >= n || next_col >= m){
                wing--;
                continue;
            }

            min = Math.min(min, map[next_row][next_col]);
            sum = sum + map[next_row][next_col];
        }

        if(wing == 4){
            sum = sum - min;
        }
        max = Math.max(sum, max);
    }
}
