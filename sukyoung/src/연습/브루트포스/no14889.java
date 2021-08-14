package 연습.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14889 {
    public static int n, min;
    public static int[][] arr;
    public static boolean[] visit; //사람을 나타내니까 2차원일 필요 엑
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr = new int[n][n];
        visit = new boolean[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        dfs(0,0);
        System.out.println(min);

    }
    public static void dfs(int depth, int start){
        if(depth == n/2){
           calc_avaliability();
        }

        for(int i = start; i<n; i++){
            if(visit[i])
                continue;
            visit[i] = true;
            dfs(depth + 1, i+1);
            visit[i] = false;
        }

    }
    public static void calc_avaliability(){
        int start_team = 0;
        int link_team = 0;

        for(int i=0; i<n-1; i++){
            for(int j=i; j<n; j++){
                if (visit[i] == true && visit[j] == true) {
                    start_team += arr[i][j];
                    start_team += arr[j][i];
                }
                else if (visit[i] == false && visit[j] == false) {
                    link_team += arr[i][j];
                    link_team += arr[j][i];
                }
            }
        }
        int diff = Math.abs(link_team - start_team);
        if (diff == 0) {
            System.out.println(diff);
            System.exit(0);
        }

        min = Math.min(min, diff);
    }
}
