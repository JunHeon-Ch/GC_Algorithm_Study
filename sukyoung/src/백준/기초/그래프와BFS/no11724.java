package 기초.그래프와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class no11724 {
    public static int n;
    public static int m;
    public static int start;
    public static boolean[] visit;
    public static ArrayList<Integer>[] graph;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        for(int i=1; i<n+1; i++)
            Collections.sort(graph[i]);

        visit = new boolean[n+1];
        cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(!visit[i]) { // 방문한 적 없는 노드라면 dfs.
                DFS(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static void DFS(int node){
        if(visit[node]) {
            return;
        }

        visit[node] = true;
        for(int y: graph[node]){
            if(!visit[y]) {
                DFS(y);
            }
        }
    }
}
