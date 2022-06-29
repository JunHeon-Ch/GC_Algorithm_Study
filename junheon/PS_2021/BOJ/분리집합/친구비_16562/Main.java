package PS_2021.BOJ.분리집합.친구비_16562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/16562
 * 알고리즘: union find
 * 시간복잡도: O(m), m=10,000(친구관계 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] parent = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int[] cost = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int fromParent = find(parent, from);
            int toParent = find(parent, to);
            // union: 적은 비용을 친구될 수 있는 애가 최상위 부모가 됨
            if(cost[fromParent] <= cost[toParent]) parent[toParent] = fromParent;
            else parent[fromParent] = toParent;
        }
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            int p = find(parent, i);
            if(set.contains(p)) continue;
            set.add(p);
            k -= cost[p];
            ans += cost[p];
            if(k < 0) {
                System.out.println("Oh no");
                return;
            }
        }
        System.out.println(ans);
    }

    public static int find(int[] parent, int me) {
        if(parent[me] == me) return me;
        return parent[me] = find(parent, parent[me]);
    }
}
