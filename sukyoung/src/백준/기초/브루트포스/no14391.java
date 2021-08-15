package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14391 {
    public static int N;
    public static int M;
    public static int[][] paper;
    public static boolean[][] visit;
    public static int max_value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                paper[i][j] = str.charAt(j) - '0';
            }
        }
        max_value = Integer.MIN_VALUE;
        DFS(0,0);
        System.out.println(max_value);
    }
    public static void DFS(int row, int col){
        if(row >= N){
            sum();
            return;
        }
        if(col >= M){
            DFS(row+1, 0);
            return;
        }
        visit[row][col] = true;
        DFS(row, col+1);

        visit[row][col] = false;
        DFS(row, col+1);
    }
    public static void sum(){
        int ret = 0;
        int temp = 0;

        // 가로 숫자 계산
        for (int i = 0; i < N; i++) {
            temp = 0;
            for (int j = 0; j < M; j++) {
                // 가로 덧셈 -> true인 경우
                if (visit[i][j]) {
                    temp *= 10; // 자릿수 이동 ex) 1 -> 10
                    temp += paper[i][j]; // ex) 10 -> 13
                } else {
                    ret += temp;
                    temp = 0; // temp 변수 초기화
                }
            }

            ret += temp;
        }

        // 세로 숫자 계산
        for (int i = 0; i < M; i++) {
            temp = 0;
            for (int j = 0; j < N; j++) {
                // 세로 덧셈 -> false인 경우
                if (!visit[j][i]) {
                    temp *= 10; // 자릿수 이동 ex) 1 -> 10
                    temp += paper[j][i]; // ex) 10 -> 13
                } else {
                    ret += temp;
                    temp = 0; // temp 변수 초기화
                }
            }
            ret += temp;
        }
        max_value = Math.max(max_value, ret);
    }
}
