package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no5427 {
    public static Queue<building> fire;
    public static boolean[][] visit;
    public static char[][] map;
    public static int w, h;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        while(test_case > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];

            int x = 0, y = 0;
            fire = new LinkedList<>();
            for(int i=0; i<h; i++){
                String str = br.readLine();
                for(int j=0; j<w; j++){
                    map[i][j] = str.charAt(j);
                    if(str.charAt(j) == '@'){
                        x = i;
                        y = j;
                    }
                    else if(str.charAt(j) == '*')
                        fire.add(new building(i, j));

                }
            }

            visit = new boolean[h][w];
            bfs(x, y);

            test_case--;
        }
        System.out.print(sb);
    }
    public static void bfs(int x, int y){
        Queue<building> queue = new LinkedList<>();
        queue.add(new building(-1, -1));
        queue.add(new building(x, y));
        visit[x][y] = true;

        int time = -1;
        while(!queue.isEmpty()){
            building current = queue.poll();

            if(current.x == -1 && current.y == -1){
                burn();
                if(!queue.isEmpty())
                    queue.offer(current);
                time++;
                continue;
            }
            for(int i=0; i<4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= h || ny >= w || nx < 0 || ny < 0) {
                    sb.append(time+1 + "\n");
                    return;
                }
                if(map[nx][ny] == '.' && !visit[nx][ny]) {
                    queue.offer(new building(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }
        sb.append("IMPOSSIBLE\n");
    }
    public static void burn(){
        int size = fire.size();
        for(int s=0; s< size; s++){
            building now = fire.poll();

            for(int i=0; i<4; i++){
                int next_x = now.x + dx[i];
                int next_y = now.y + dy[i];

                if(next_x >= 0 && next_y >= 0 && next_x < h && next_y < w && (map[next_x][next_y] == '.' || map[next_x][next_y] == '@')) {
                    fire.offer(new building(next_x, next_y));
                    map[next_x][next_y] = '*';
                }
            }
        }
    }
}

class building {
    int x;
    int y;
    building(int x, int y){
        this.x = x;
        this.y = y;
    }
}
