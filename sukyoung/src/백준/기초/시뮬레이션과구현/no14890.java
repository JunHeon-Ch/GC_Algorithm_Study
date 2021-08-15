package 기초.시뮬레이션과구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14890 {
    public static int n;
    public static int l;
    public static int[][] map;
    public static int cnt = 0;
    public static boolean slope = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++) {
            if(checkRow(i)) // 행
                cnt++;

            if(checkCol(i)) // 열
                cnt++;
        }

        System.out.println(cnt);

    }
    public static boolean checkRow(int x){
        int[] height = new int[n];
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++)
            height[i] = map[x][i];

        for(int i=0; i<n-1; i++){
            if(height[i] == height[i+1])
                continue;

            //내려갈ㄱ때
            else if(height[i]-height[i+1] == 1) {
                for(int j=i+1; j<=i+l; j++) {
                    if(j>=n || height[i+1]!=height[j] || visited[j]) return false;
                    visited[j] = true;
                }
            }
            // 올라갈
            else if(height[i]-height[i+1] == -1) {
                for(int j=i; j>i-l; j--) {
                    if(j<0 || height[i]!=height[j] || visited[j]) return false;
                    visited[j] = true;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
    public static boolean checkCol(int x){
        int[] height = new int[n];
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++)
            height[i] = map[i][x];

        for(int i=0; i<n-1; i++){
            if(height[i] == height[i+1])
                continue;

                //내려갈ㄱ때
            else if(height[i]-height[i+1] == 1) {
                for(int j=i+1; j<=i+l; j++) {
                    if(j>=n || height[i+1]!=height[j] || visited[j]) return false;
                    visited[j] = true;
                }
            }
            // 올라갈
            else if(height[i]-height[i+1] == -1) {
                for(int j=i; j>i-l; j--) {
                    if(j<0 || height[i]!=height[j] || visited[j]) return false;
                    visited[j] = true;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
}
