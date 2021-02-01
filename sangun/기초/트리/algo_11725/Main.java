package algo_11725;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int parent = 0;

        Node(int parent) {
            this.parent = parent;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] tree = new ArrayList[n + 1];
        Node[] node = new Node[n + 1];
        for (int i = 0; i < n + 1; i++) tree[i] = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
            if (a == 1) {
                node[b] = new Node(a);
                q.offer(b);
            }
            if (b == 1) {
                node[a] = new Node(b);
                q.offer(a);
            }
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int k : tree[x]) {
                if (node[k] == null) {
                    node[k] = new Node(x);
                    q.offer(k);
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            bw.write(node[i].parent + "\n");
        }
        bw.close();

    }
}
