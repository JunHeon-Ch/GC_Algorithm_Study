package algo_1991;

import java.io.*;

public class Main {
    static class Node {
        int left, right;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static Node[] num = new Node[50];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int a = str[0].charAt(0) - 'A';
            int b = str[1].charAt(0) - 'A';
            int c = str[2].charAt(0) - 'A';
            num[a] = new Node(b, c);
        }
        preorder(0);
        bw.write("\n");
        inorder(0);
        bw.write("\n");
        postorder(0);
        bw.write("\n");
        bw.close();
    }

    static void preorder(int x) throws IOException {
        if (x < 0) return;
        bw.write((char) (x + 'A'));
        preorder(num[x].left);
        preorder(num[x].right);
    }

    static void inorder(int x) throws IOException {
        if (x < 0) return;
        inorder(num[x].left);
        bw.write((char) (x + 'A'));
        inorder(num[x].right);
    }

    static void postorder(int x) throws IOException {
        if (x < 0) return;
        postorder(num[x].left);
        postorder(num[x].right);
        bw.write((char) (x + 'A') + "");
    }
}
