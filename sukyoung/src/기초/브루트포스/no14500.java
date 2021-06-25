package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14500 {
    public static int[][] board;
    public static int N;
    public static int M;
    public static boolean[][] visited;
    public static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];

        max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                DFS(i, j, 0, 0);
                Except(i,j);
            }
        }
        System.out.println(max);
    }
    public static void DFS(int x, int y, int depth, int sum){
        int[] direction_x = {-1,0,1,0};
        int[] direction_y = {0,-1,0,1};

        if(depth == 4){
            max = Math.max(sum, max);
            return;
        }

        for(int i=0; i<4; i++){
            int nextX = x + direction_x[i];
            int nextY = y + direction_y[i];

            if(nextX<0 || nextY<0 || nextX>=N || nextY>=M)
                continue;
            if(visited[nextX][nextY])
                continue;

            visited[nextX][nextY] = true;
            DFS(nextX, nextY, depth+1, sum + board[nextX][nextY]);
            visited[nextX][nextY] = false; //원상복구를 해줘야하니까?!
        }

    }

    public static void Except(int x, int y){
        int wing = 4;
        int min = Integer.MAX_VALUE;
        int sum = board[x][y];
        int[] direction_x = {-1,0,1,0};
        int[] direction_y = {0,-1,0,1};

        for(int i=0; i<4; i++){
            int nextX = x + direction_x[i];
            int nextY = y + direction_y[i];

            if(wing <= 2)
                return;
            if(nextX<0 || nextY<0 || nextX >=N || nextY >=M){
                wing --;
                continue;
            }
            min = Math.min(min, board[nextX][nextY]);
            sum = sum + board[nextX][nextY];
        }
        if(wing == 4)
            sum = sum - min;

        max = Math.max(max,sum);
    }
}
