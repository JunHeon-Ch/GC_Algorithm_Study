package PS_2022.BOJ._11_Simulation.드래곤_커브_15685;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/15685
 * 알고리즘: 시뮬레이션
 */

public class Main {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[101][101];
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            List<Point> list = new ArrayList<>();
            list.add(new Point(x, y));
            list.add(new Point(x + dx[d], y + dy[d]));
            while (k-- > 0) {
                int size = list.size();
                Point p = list.get(size - 1);
                for(int i = size - 2; i >= 0; i--) {
                    Point np = list.get(i);
                    list.add(new Point(np.y - p.y + p.x, -1 * (np.x - p.x) + p.y));
                }
            }
            for(Point p : list) {
                board[p.x][p.y] = true;
            }
        }

        int ans = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(board[i][j] && board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1]) ans++;
            }
        }
        System.out.println(ans);
    }
}
