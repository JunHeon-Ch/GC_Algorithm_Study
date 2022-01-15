package 백준.시뮬레이션.인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, l, r;
    public static int[][] world;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static boolean[][] visit;
    public static ArrayList<node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        world = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                world[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(movingDay());
    }
    public static int movingDay(){
        int result = 0;

        while(true){
            boolean isMove = false;
            visit = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visit[i][j]) {
                        int sum = bfs(i, j);
                        if(list.size() > 1) {
                            move(sum);
                            isMove = true;
                        }
                    }
                }
            }
            if(!isMove)
                return result;
            result++;
        }
    }
    public static int bfs(int x, int y){
        Queue<node> queue = new LinkedList<>();
        list = new ArrayList<>();

        queue.add(new node(x, y));
        list.add(new node(x, y));
        visit[x][y] = true;

        int sum = world[x][y];
        while(!queue.isEmpty()){
            node now = queue.poll();

            for(int i=0; i<4; i++){
                int next_x = now.x + dx[i];
                int next_y = now.y + dy[i];

                if(next_x < 0 || next_y < 0 || next_x >= n || next_y >= n)
                    continue;
                if(visit[next_x][next_y])
                    continue;

                int diff = Math.abs(world[now.x][now.y] - world[next_x][next_y]);
                if(l <= diff && diff <= r) {
                    queue.offer(new node(next_x, next_y));
                    list.add(new node(next_x, next_y));
                    sum += world[next_x][next_y];
                    visit[next_x][next_y] = true;
                }
            }
        }
        return sum;
    }

    public static void move(int sum) {
        int avg = sum / list.size();
        for(node n : list) {
            world[n.x][n.y] = avg;
        }
    }

    public static class node {
        int x, y;
        public node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
