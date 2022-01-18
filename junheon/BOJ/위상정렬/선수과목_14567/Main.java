package BOJ.위상정렬.선수과목_14567;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/14567
 * 알고리즘: 위상정렬
 * 시간복잡도: O(V+E), V=1,000(과목의 수 N), E=500,000(선수 조건의 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] dag = new List[n];
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            dag[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            dag[u].add(v);
            inDegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[n];
        int res = 1;
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
                ans[i] = res;
            }
        }
        res++;
        int cnt = queue.size();
        while(cnt < n) {
            Queue<Integer> tmpQ = new LinkedList<>();
            while(!queue.isEmpty()) {
                int u = queue.poll();
                for(int v : dag[u]) {
                    if(--inDegree[v] == 0) {
                        tmpQ.add(v);
                        ans[v] = res;
                    }
                }
            }
            queue.addAll(tmpQ);
            cnt += tmpQ.size();
            res++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
    }
}
