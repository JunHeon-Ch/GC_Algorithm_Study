package BOJ.위상정렬.ACM_Craft_1005;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/1005
 * 알고리즘: 위상정렬 DP
 * 시간복잡도: O(V+E), V=1,000(건물의 개수 N), E=100,000(건물 간의 건설순서 규칙의 총 개수 K)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] dur = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                dur[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer>[] dag = new List[n];
            int[] inDegree = new int[n];
            for (int i = 0; i < n; i++) {
                dag[i] = new ArrayList<>();
            }
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                dag[u].add(v);
                inDegree[v]++;
            }
            int w = Integer.parseInt(br.readLine()) - 1;

            Queue<Integer> queue = new LinkedList<>();
            int[] d = new int[n];
            for (int i = 0; i < n; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                    d[i] = dur[i];
                }
            }
            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (int v : dag[u]) {
                    d[v] = Math.max(d[v], d[u] + dur[v]);
                    if (--inDegree[v] == 0) queue.add(v);
                }
            }
            bw.write(d[w] + "\n");
        }
        bw.flush();
    }
}
