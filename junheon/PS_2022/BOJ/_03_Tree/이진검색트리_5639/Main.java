package PS_2022.BOJ._03_Tree.이진검색트리_5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/5639
 * 시간복잡도: O(nlogn), n=10,000(노드 수)
 */

public class Main {

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));

        while(true) {
            String input = br.readLine();
            if(input == null || input.equals("")) break;

            int val = Integer.parseInt(input);
            addNode(root, val);
        }
        postOrder(root);
    }

    static void addNode(Node node, int val) {
        if(node.val < val) {
            if(node.right == null) {
                node.right = new Node(val);
                return;
            }
            else addNode(node.right, val);
        } else {
            if(node.left == null) {
                node.left = new Node(val);
                return;
            }
            addNode(node.left, val);
        }
    }

    static void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }
}
