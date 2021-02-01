package algo_1260;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] vertex;
    static boolean[] valid;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        vertex = new ArrayList[n + 1];
        valid = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            vertex[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            vertex[front].add(end);
            vertex[end].add(front);
        }
        for (int i = 1; i <= n; i++)
            vertex[i].sort(Comparator.naturalOrder());
        dfs(v);
        Arrays.fill(valid, false);
        bw.write("\n");
        bfs(v);
        bw.close();


    }

    public static void dfs(int start) throws IOException {
        valid[start] = true;
        bw.write(start + " ");
        for (int k : vertex[start]) {
            if (valid[k] == false) dfs(k);
        }
    }

    static void bfs(int start) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        valid[start] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            bw.write(x + " ");
            for (int k : vertex[x]) {
                if (!valid[k]) {
                    q.offer(k);
                    valid[k] = true;
                }
            }
        }
        bw.write("\n");

    }

}

