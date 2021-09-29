package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no1726 {
    public static boolean[][][] visit;
    public static robot start, finish;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] factory = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                factory[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[m+1][n+1][5];
        st = new StringTokenizer(br.readLine());
        start = new robot(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                0);

        st = new StringTokenizer(br.readLine());
        finish = new robot(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                0);

        bfs(m,n,factory);

    }
    public static void bfs(int m, int n, int[][] factory){
        Queue<robot> queue = new LinkedList<>();
        visit[start.x][start.y][start.dir] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            robot current = queue.poll();
            int current_x = current.x;
            int current_y = current.y;
            int current_dir = current.dir;
            int current_cnt = current.count;

            if(current_x == finish.x && current_y == finish.y && current_dir == finish.dir){
                System.out.println(current_cnt);
                return;
            }

            for(int i=1; i<=3; i++){
                int next_x = current_x + (dx[current_dir-1] * i);
                int next_y = current_y + (dy[current_dir-1] * i);

                if(next_x <= 0 || next_y <= 0 || next_x > m || next_y > n)
                    continue;
                if(factory[next_x][next_y] == 0){
                    if(!visit[next_x][next_y][current_dir]){
                        visit[next_x][next_y][current_dir] = true;
                        queue.add(new robot(next_x, next_y, current_dir, current_cnt+1));
                    }
                }
                else
                    break;
            }
            for(int i=1; i<=4; i++){
                if (current_dir != i && !visit[current_x][current_y][i]) {
                    int turn = 1;
                    if (current_dir == 1) {
                        if (i == 2) {
                            turn++;
                        }
                    } else if (current_dir == 2) {
                        if (i == 1) {
                            turn++;
                        }
                    } else if (current_dir == 3) {
                        if (i == 4) {
                            turn++;
                        }
                    } else {
                        if (i == 3) {
                            turn++;
                        }
                    }

                    visit[current_x][current_y][i] = true;
                    queue.add(new robot(current_x, current_y, i, current_cnt + turn));
                }
            }
        }

    }
    static class robot{
        int x;
        int y;
        int dir;
        int count;
        robot(int x, int y, int dir, int count){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }
    }
}
