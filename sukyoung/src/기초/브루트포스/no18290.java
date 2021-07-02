package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no18290 {
    public static int N;
    public static int M;
    public static int K;
    public static int[][] board;
    public static boolean[][] visit;
    public static StringBuilder sb = new StringBuilder();

    public static int sum_of_max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[N][M];

        sum_of_max = Integer.MIN_VALUE;
        DFS(0, 0, 0, 0);
        sb.append(sum_of_max);
        System.out.print(sb);
    }
    public static void DFS(int x, int y, int depth, int sum){
        if(K == depth) {
            sum_of_max = Math.max(sum, sum_of_max);
            return;
        }
        for(int i=0; i<N; i++){
            for(int j =0; j<M; j++){
                if(isValid(i, j)){
                    visit[i][j] = true;
                    DFS(i, j, depth+1, sum+board[i][j]);
                    visit[i][j] = false;
                }
            }
        }
    }
    public static boolean isValid(int x, int y){

        int[] direction_x = {-1,0,1,0};
        int[] direction_y = {0,-1,0,1};

        if(visit[x][y]){
            return false;
        }
        else {
            for (int i = 0; i < 4; i++) {
                int current_x = x + direction_x[i];
                int current_y = y + direction_y[i];

                if (current_x >= 0 && current_x < N && current_y >= 0 && current_y < M) {
                    if (visit[current_x][current_y]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
