package 기초.그래프와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no1707 {
    public static ArrayList<ArrayList<Integer>> graph;
    public static int color[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n-- != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            color = new int[v];
            graph = new ArrayList<>();
            for (int j = 0; j < v; j++) { // 정점만큼 배열 어레이리스트 생성
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());

                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                graph.get(n1-1).add(n2-1);
                graph.get(n2-1).add(n1-1);
            }
            for (int j = 0; j < v; j++) {
                if (color[j] == 0) {
                    color[j] = 1;
                    bfs(v, j);
                }
            }
            System.out.println(check(v));
        }
    }
    public static void bfs(int V, int start) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        while (!q.isEmpty()) {
            int v = q.poll();
            int c = color[v];

            for (int i = 0; i < graph.get(v).size(); i++) {

                int v2 = graph.get(v).get(i);

                if (color[v2] == 0) {
                    if (c == 1)
                        color[v2] = -1;
                    else if (c == -1)
                        color[v2] = 1;

                    q.offer(v2);
                }
            }
        }
    }
    public static String check(int V) {

        for (int n = 0; n < V; n++) {
            for (int m = 0; m < graph.get(n).size(); m++) {
                if (color[n] == color[graph.get(n).get(m)]) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}
