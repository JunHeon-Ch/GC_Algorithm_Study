package PS_2022.BOJ._03_Tree.단절점과_단절선_14675;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/14675
 * 알고리즘: 트리
 * 시간복잡도: O(n), n=100,000(정점 개수)
 */

public class Main {

    static class Node {
        int val;
        List<Integer> adj;

        public Node(int val) {
            this.val = val;
            adj = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Node[] tree = new Node[n + 1];
        for(int i = 1; i <= n; i++) {
            tree[i] = new Node(i);
        }
        for(int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].adj.add(v);
            tree[v].adj.add(u);
        }

        int q = Integer.parseInt(br.readLine());
        while(q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(t == 1) {
                if(tree[k].adj.size() == 1) bw.write("no\n");
                else bw.write("yes\n");
            } else if(t == 2) bw.write("yes\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
