package 기초.시뮬레이션과구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14503 {
    public static int n,m,x,y;
    public static int[][] map;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(x, y, direction);
        System.out.println(cnt);
    }
    public static void clean(int current_x, int current_y, int direction){

        if(map[current_x][current_y] == 0){
            map[current_x][current_y] = 2;
            cnt++;
        }

        boolean canClean = false;
        int originDirection = direction;
        for(int i=0; i<4; i++){
            int next_direction = (direction + 3) % 4;
            int next_x = current_x + dx[next_direction];
            int next_y = current_y + dy[next_direction];

            if(next_x > 0 && next_y > 0 && next_x < n && next_y < m ){
                if(map[next_x][next_y] == 0){
                    clean(next_x, next_y, next_direction);
                    canClean = true;
                    break;
                }
            }
            direction = (direction + 3) % 4;
        }

        if(!canClean){
            int next_direction = (direction + 2) % 4;
            int next_x = current_x + dx[next_direction];
            int next_y = current_y + dy[next_direction];

            if (next_x > 0 && next_y > 0 && next_x < n && next_y < m) {
                if (map[next_x][next_y] != 1) {
                    clean(next_x, next_y, originDirection);
                }
            }
        }
    }
}
