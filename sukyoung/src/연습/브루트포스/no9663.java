package 연습.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no9663 {
    public static int n, cnt;
    public static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n];

        queens(0);
        System.out.println(cnt);
    }
    public static void queens(int depth){
        if(depth == n){
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[depth] = i;

            if (Possibility(depth)) {
                queens(depth + 1);
            }
        }
    }
    public static boolean Possibility(int col){
        for (int i = 0; i < col; i++) {
            if (board[col] == board[i]) {
                return false;
            }
            else if (Math.abs(col - i) == Math.abs(board[col] - board[i])) {
                return false;
            }
        }
        return true;
    }
}
