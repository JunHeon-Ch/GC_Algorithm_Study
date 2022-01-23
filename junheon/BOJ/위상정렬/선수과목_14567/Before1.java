package BOJ.위상정렬.선수과목_14567;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/14567
 * 알고리즘: 위상정렬
 * 시간복잡도:
 */

public class Before1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] dag = new boolean[n][n];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            dag[--u][--v] = true;
        }

        int cnt = 0, res = 1;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] ans = new int[n];
        while(cnt < n) {
            Stack<Integer> stack = new Stack<>();
            for(int j = 0; j < n; j++) {
                if(ans[j] > 0) continue;
                int i;
                for(i = 0; i < n; i++) {
                    if(dag[i][j]) break;
                }
                if(i == n) {
                    stack.push(j);
                }
            }
            cnt += stack.size();

            while(!stack.isEmpty()) {
                int i = stack.pop();
                ans[i] = res;
                for(int j = 0; j < n; j++) {
                    dag[i][j] = false;
                }
            }
            res++;
        }

        for(int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
    }
}
