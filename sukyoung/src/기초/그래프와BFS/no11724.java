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
        start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 1; i < n + 1; i++) {
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
        DFS(start);
        System.out.println();

        visit = new boolean[n+1];
        BFS(start);
        System.out.println();
    }
    public static void DFS(int node){
        if(visit[node]) {
            return;
        }

        visit[node] = true;
        System.out.print(node + " ");
        for(int y: graph[node]){
            if(!visit[y])
                DFS(y);
        }

    }
    public static void BFS(int node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");
            for (int y : graph[x]) {
                if (!visit[y]) {
                    visit[y] = true;
                    queue.add(y);
                }
            }
        }
    }
}
