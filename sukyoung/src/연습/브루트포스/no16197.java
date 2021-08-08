package 연습.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no16197 {
    public static int n,m, x1, y1, x2, y2;
    public static int count = Integer.MAX_VALUE;
    public static char[][] arr;
    public static boolean[][] visit;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean flag = false;
    public static boolean isOK = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'o'){
                        if(flag){
                            y2 = i;
                            x2 = j;
                        }
                        else{
                            y1 = i;
                            x1 = j;
                            flag = true;
                        }
                }
            }
        }
        dfs(y1, x1, y2, x2,0);

        if(count == Integer.MAX_VALUE) {	// 절대 떨어뜨리지 못하는 경우
            System.out.println(-1);
        }
        else {
            System.out.println(count);
        }
    }
    public static void dfs(int y1, int x1, int y2, int x2, int checkCnt){
        if(checkCnt >= count || checkCnt >= 10)
            return;

        for(int i=0; i<4; i++){
            int fall = 0;
            int next_x1 = x1 + dx[i];
            int next_y1 = y1 + dy[i];
            int next_x2 = x2 + dx[i];
            int next_y2 = y2 + dy[i];

            if(next_x1 < 0 || next_x1 >= m || next_y1 < 0 || next_y1 >= n) {
                fall++;
            }
            if(next_x2 < 0 || next_x2 >= m || next_y2 < 0 || next_y2 >= n) {
                fall++;
            }
            if(fall == 2)
                continue;
            if(fall == 1) {
                count = Math.min(count, checkCnt + 1);
                return;
            }

            if(arr[next_y1][next_x1] == '#') { // 벽이면
                next_x1 = x1;
                next_y1 = y1;
            }
            if(arr[next_y2][next_x2] == '#') { // 벽이면
                next_x2 = x2;
                next_y2 = y2;
            }

            dfs(next_y1, next_x1, next_y2, next_x2, checkCnt + 1);

        }
    }
}
