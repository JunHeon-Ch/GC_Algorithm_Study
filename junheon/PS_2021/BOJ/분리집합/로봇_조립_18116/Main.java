package PS_2021.BOJ.분리집합.로봇_조립_18116;

import java.io.*;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/18116
 * 알고리즘: union find
 * 시간복잡도: O(n), n=1,000,000(지시 횟수)
 */

public class Main {

    static int[] parent = new int[1000001];
    static int[] cnt = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        init();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            char op = st.nextToken().charAt(0);
            if(op == 'I') {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                union(from, to);
            } else if(op == 'Q') {
                int cur = Integer.parseInt(st.nextToken());
                int p = find(cur);
                bw.write(cnt[p] + "\n");
            }
        }
        bw.flush();
    }

    public static void init() {
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
            cnt[i] = 1;
        }
    }

    public static int find(int me) {
        if(parent[me] == me) return me;
        return parent[me] = find(parent[me]);
    }

    public  static void union(int from, int to) {
        int fromParent = find(from);
        int toParent = find(to);
        if(fromParent == toParent) return;
        parent[toParent] = fromParent;
        cnt[fromParent] += cnt[toParent];
    }
}
