package 기초.그래프와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class no13023 {
    public static int n;
    public static int m;
    public static ArrayList<Integer>[] graph;
    public static boolean[] visit;
    public static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        for(int i=0; i < n; i++)
            Collections.sort(graph[i]);

        visit = new boolean[n+1];
        flag = false;
        for(int i = 0; i < n; i++) {
            DFS(i, 1);
            if (flag) {
                break;
            }
        }

        if(flag)
            System.out.println(1);
        else
            System.out.println(0);

    }
    public static void DFS(int node, int depth){
        if(depth == 5) {
            flag = true;
            return;
        }

        visit[node] = true;
        for(int y: graph[node]){
            if(!visit[y]) {
                DFS(y, depth+1);
            }
            if(flag)
                return;
        }
        visit[node] = false;
    }
}
