package 백준.연습.그래프와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no16929 {
    public static int first_x, first_y, n, m;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] visit;
    public static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visit = new boolean[n][m];

                first_x = i;
                first_y = j;
                visit[first_x][first_y] = true;
                if(dfs(i,j,1)){
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");

    }
    public static boolean dfs(int x, int y, int depth){

        for(int i=0; i<4; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(next_x < 0 || next_y < 0 || next_x >= n || next_y >= m)
                continue;

            if(map[x][y] == map[next_x][next_y]){
                if(!visit[next_x][next_y]) {
                    visit[next_x][next_y] = true;
                    if(dfs(next_x, next_y, depth+1))
                        return true;
                }
                else{
                    if(depth >= 4 && first_x == next_x && first_y == next_y)
                        return true;
                }

            }
        }

        return false;
    }
}
