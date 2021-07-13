package algo_2250;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int left, right;
        int depth, order;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static int order = 0;
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001];
        tree = new Node[10001];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a] = new Node(b, c);
            if (b != -1) cnt[b]++;
            if (c != -1) cnt[c]++;
        }
        int root = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) root = i;
        }
        int[] left = new int[10001];
        int[] right = new int[10001];

        inorder(root, 1);
        int maxdepth = 0;
        for (int i = 1; i <= n; i++) {
            int order = tree[i].order;
            int depth = tree[i].depth;
            if (left[depth] == 0) left[depth] = order;
            else left[depth] = Math.min(left[depth], order);
            right[depth] = Math.max(right[depth], order);
            maxdepth = Math.max(maxdepth, depth);
        }
        int ans = 0;
        int ans_depth = 0;
        for (int i = 1; i <= maxdepth; i++) {
            int temp = right[i] - left[i] + 1;
            if (ans < temp) {
                ans = temp;
                ans_depth = i;
            }
        }
        bw.write(ans_depth + " " + ans + "\n");
        bw.close();


    }

    // depth++ 하면 답이 달라짐 이유가?
    static void inorder(int x, int depth) {
        if (x == -1) return;
        inorder(tree[x].left, depth + 1);
        tree[x].order = ++order;
        tree[x].depth = depth;
        inorder(tree[x].right, depth + 1);
    }
}
