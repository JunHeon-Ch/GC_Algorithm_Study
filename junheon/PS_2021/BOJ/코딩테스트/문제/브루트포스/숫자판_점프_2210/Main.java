package PS_2021.BOJ.코딩테스트.문제.브루트포스.숫자판_점프_2210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] board = new int[5][5];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[] num = new int[6];
    static List<String> visit = new ArrayList<>();

    public static void solve(int index, int x, int y) {
        if (index == 6) {
            String res = new String();
            for (int i = 0; i < 6; i++) {
                res += num[i];
            }
            if (!visit.contains(res)) visit.add(res);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            num[index] = board[nx][ny];
            solve(index + 1, nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                num[0] = board[i][j];
                solve(1, i, j);
            }
        }
        System.out.println(visit.size());
    }
}
