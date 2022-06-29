package PS_2021.BOJ.위상정렬.문제집_1766;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/1766
 * 알고리즘: 위상정렬 + 힙
 * 시간복잡도: O(V+E), V=32,000(문제 수), E=100,000(먼저 푸는 것이 좋은 문제에 대한 정보의 개수)
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
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            dag[u].add(v);
            inDegree[v]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) pq.add(i);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(!pq.isEmpty()) {
            int u = pq.poll();
            bw.write((u + 1) +  " ");
            for(int v : dag[u]) {
                if(--inDegree[v] == 0) pq.add(v);
            }
        }
        bw.flush();
    }
}
