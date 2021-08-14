package 기초.시뮬레이션과구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no16931 {
    public static int[][] cube;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        cube = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                cube[i][j] = Integer.parseInt(st.nextToken());
        }

        int ans = (n*m) * 2;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int cnt = cube[i][j] * 4;
                for(int d=0; d<4; d++){
                    int next_x = i + dx[d];
                    int next_y = j + dy[d];

                    if(next_x < 0 || next_x >= n || next_y < 0 || next_y >= m) continue;

                    if(cube[next_x][next_y] > cube[i][j]) {
                        cnt -= cube[i][j];
                    } else {
                        cnt -= cube[next_x][next_y];
                    }
                }
                ans += cnt;
            }
        }
        System.out.println(ans);
    }
}
