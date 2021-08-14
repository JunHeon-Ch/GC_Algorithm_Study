package 기초.그래프와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no7576 {
    public static int[][] farm;
    public static int n;
    public static int m;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        farm = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }

    public static void bfs(){

        Queue<tomato> q = new LinkedList<tomato>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(farm[i][j] == 1)
                    q.add(new tomato(i,j));
            }
        }

        while(!q.isEmpty()){
            tomato d = q.poll();

            for(int i=0; i<4; i++){
                int nextX = d.x + dx[i];
                int nextY = d.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }
                if(farm[nextX][nextY] != 0){
                    continue;
                }
                farm[nextX][nextY] = farm[d.x][d.y] + 1;
                q.add(new tomato(nextX, nextY));

            }
        }
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(farm[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, farm[i][j]);
            }
        }
        System.out.println(max -1);
    }
}

class tomato {
    int x;
    int y;
    tomato(int x, int y){
        this.x = x;
        this.y = y;
    }
}
