package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14889 {
    public static int N;
    public static int[][] able;
    public static boolean[] visit;

    public static int min_availability;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        able = new int[N][N];
        visit = new boolean[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
                able[i][j] = Integer.parseInt(st.nextToken());
        }
        min_availability = Integer.MAX_VALUE;
        DFS(0,0);
        System.out.print(min_availability);

    }
    public static void DFS(int start, int depth){
        if(depth == N/2){
            calc_avaliability();
        }

        for(int i=start; i<N; i++){
            if(!visit[i]){
                visit[i] = true;
                DFS(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
    public static void calc_avaliability(){
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                // i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스
                if (visit[i] == true && visit[j] == true) {
                    team_start += able[i][j];
                    team_start += able[j][i];
                }
                // i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스
                else if (visit[i] == false && visit[j] == false) {
                    team_link += able[i][j];
                    team_link += able[j][i];
                }
            }
        }

        int diff = Math.abs(team_link - team_start);
        if (diff == 0) {
            System.out.println(diff);
            System.exit(0);
        }

        min_availability = Math.min(min_availability, diff);
    }
}
