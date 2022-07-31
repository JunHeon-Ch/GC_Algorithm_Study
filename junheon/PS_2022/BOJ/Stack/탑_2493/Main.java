package PS_2022.BOJ.Stack.탑_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2493
 * 알고리즘: 스택
 * 시간복잡도: O(n), n=500,000(탑의 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Node> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek().height <= h) stack.pop();
            if(stack.isEmpty()) sb.append("0 ");
            else sb.append(stack.peek().idx + " ");
            stack.push(new Node(i + 1, h));
        }
        System.out.println(sb.toString());
    }
}

class Node {
    int idx, height;

    public Node(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}
