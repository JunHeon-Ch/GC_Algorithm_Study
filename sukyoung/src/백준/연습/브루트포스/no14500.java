package 연습.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14500 {
    public static int n,m, max;
    public static int[][] arr;
    public static boolean[][] visit;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[n][m];
        max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                DFS(i, j, 0, 0);
                Except(i,j);
            }
        }
        System.out.println(max);

    }
    public static void DFS(int x, int y, int depth, int sum){
        if(depth == 4){
            max = Math.max(sum, max);
            return;
        }
        for(int i=0; i<4; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(next_x < 0 || next_y < 0 || next_x >= n || next_y >= m)
                continue;
            if(visit[next_x][next_y])
                continue;

            visit[next_x][next_y] = true;
            DFS(next_x, next_y, depth+1, sum + arr[next_x][next_y]);
            visit[next_x][next_y] = false;
        }
    }

    public static void Except(int x, int y){
        int wing = 4;
        int min = Integer.MAX_VALUE;
        int sum = arr[x][y];

        for(int i=0; i<4; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(wing <= 2)
                return;

            if(next_x < 0 || next_y < 0 || next_x >= n || next_y >= m){
                wing--;
                continue;
            }

            min = Math.min(min, arr[next_x][next_y]);
            sum = sum + arr[next_x][next_y];
        }
        if(wing == 4)
            sum = sum - min;

        max = Math.max(max,sum);
    }
}
