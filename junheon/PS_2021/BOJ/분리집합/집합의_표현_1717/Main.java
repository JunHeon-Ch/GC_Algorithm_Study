package PS_2021.BOJ.분리집합.집합의_표현_1717;

import java.io.*;
import java.util.StringTokenizer;


/*
https://www.acmicpc.net/problem/1717
 * 알고리즘: union find
 * 시간복잡도: O(m), m=100,000(연산의 수)
 * 일반 union find는 O(n*m, n=노드의 개수, m=연산 횟수)의 시간복잡도를 가진다.
 * 하지만 최상위 부모 노드가 누구인지만 알면 되기 때문에 find 함수의 시간복잡도가 상수가 된다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parent = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            int fromParent = find(parent, from);
            int toParent = find(parent, to);
            if(op == 0) { // union
                parent[toParent] = fromParent;
            } else if(op == 1) { // union인지 확인
                if(fromParent == toParent) bw.write("YES\n");
                else bw.write("NO\n");
            }
        }
        bw.flush();
    }

    public static int find(int[] parent, int me) {
        if(parent[me] == me) return me;
        return parent[me] = find(parent, parent[me]);
    }
}
