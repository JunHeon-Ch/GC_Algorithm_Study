package PS_2021.BOJ.분리집합.여행_가자_1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/1976
 * 알고리즘: union find
 * 시간복잡도: O(n^2), n=200(도시의 수)
 * find: O(1)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] parent = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                int flag = Integer.parseInt(st.nextToken());
                if(j <= i || flag == 0) continue;
                // union
                int fromParent = find(parent, i);
                int toParent = find(parent, j);
                parent[toParent] = fromParent;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int me = Integer.parseInt(st.nextToken());
        int prev = find(parent, me);
        for(int i = 1; i < m; i++) {
            me = Integer.parseInt(st.nextToken());
            int p = find(parent, me);
            if(p != prev) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static int find(int[] parent, int me) {
        if(parent[me] == me) return me;
        return parent[me] = find(parent, parent[me]);
    }
}
