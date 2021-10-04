package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] friendList = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            friendList[node1][node2] = 1;
            friendList[node2][node1] = 1;
        }

        int friend = 0;
        boolean[] visit = new boolean[n+1];
        for(int i=2; i<n+1; i++){
            if(friendList[1][i] == 1){
                if(!visit[i]){
                    friend++;
                    visit[i] = true;
                }
                for(int j=2; j<n+1; j++){
                    if(friendList[i][j] == 1 && !visit[j]){
                        friend++;
                        visit[j] = true;
                    }
                }
            }
        }
        System.out.print(friend);
    }
}
