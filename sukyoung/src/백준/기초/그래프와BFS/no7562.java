package 기초.그래프와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no7562 {
    public static int[] dx = {-2, -1, -2, -1, 2, 1, 2, 1};
    public static int[] dy = {1, 2, -1, -2, 1, 2, -1, -2};
    public static int[][] board;
    public static boolean[][] visit;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int time = Integer.parseInt(br.readLine());

        for(int t=0; t<time; t++){
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            visit = new boolean[n][n];

            st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int dest_x = Integer.parseInt(st.nextToken());
            int dest_y = Integer.parseInt(st.nextToken());

            bfs(start_x, start_y, dest_x, dest_y);
        }
    }
    public static void bfs(int x, int y, int dest_x, int dest_y){

        Queue<chess> queue = new LinkedList<chess>();
        queue.add(new chess(x,y));

        visit[x][y] = true;

        while (!queue.isEmpty()){
            chess dot = queue.poll();
            if(dot.x == dest_x && dot.y == dest_y){
                System.out.println(board[dot.x][dot.y]);
                return;
            }

            for(int i=0; i<8; i++){
                int nextX = dot.x + dx[i];
                int nextY = dot.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
                    continue;
                }
                if(visit[nextX][nextY])
                    continue;

                visit[nextX][nextY] = true;
                board[nextX][nextY] = board[dot.x][dot.y] + 1;
                queue.add(new chess(nextX, nextY));

            }
        }
    }
}
class chess{
    int x;
    int y;
    chess(int x, int y){
        this.x = x;
        this.y = y;
    }
}