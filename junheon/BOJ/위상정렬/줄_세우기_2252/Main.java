package BOJ.위상정렬.줄_세우기_2252;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/2252
 * 알고리즘: 위상정렬
 * 시간복잡도: O(V+E), V=32,000(학생 수), E=100,000(키 비교 힛수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] dag = new List[n];
        int[] inDegree = new int[n];
        for(int i = 0; i < n; i++) {
            dag[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            dag[u].add(v);
            inDegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) queue.add(i);
        }
        if(n == 1) {
            System.out.println("1");
            return;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(!queue.isEmpty()) {
            int u = queue.poll();
            bw.write((u + 1) + " ");
            for(int v : dag[u]) {
                if(--inDegree[v] == 0) queue.add(v);
            }
        }
        bw.flush();
    }
}
