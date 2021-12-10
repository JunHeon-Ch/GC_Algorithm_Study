package 프로그래머스.level3.표_편집;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/81303
 * 알고리즘: 스택, 연결리스트, 구현
 * 시간복잡도: O(n*m), n=1,000,000(n), m=200,000(cmd)
 */

class Solution {
    public String solution(int n, int k, String[] command) {
        int[] prev = new int[n];
        int[] next = new int[n];
        char[] ans = new char[n];
        for(int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
            ans[i] = 'O';
        }
        next[n - 1] = -1;

        Stack<Node> stack = new Stack<>();
        for(String cmd : command) {
            StringTokenizer st = new StringTokenizer(cmd);
            String c = st.nextToken();
            if(c.equals("U")) {
                int x = Integer.parseInt(st.nextToken());
                while(x > 0) {
                    k = prev[k];
                    x--;
                }
            } else if(c.equals("D")) {
                int x = Integer.parseInt(st.nextToken());
                while(x > 0) {
                    k = next[k];
                    x--;
                }
            } else if(c.equals("C")) {
                stack.push(new Node(prev[k], k, next[k]));
                ans[k] = 'X';
                if(prev[k] != -1) next[prev[k]] = next[k];
                if(next[k] != -1) prev[next[k]] = prev[k];
                if(next[k] != -1) k = next[k];
                else k = prev[k];

            } else if(c.equals("Z")) {
                Node node = stack.pop();
                ans[node.cur] = 'O';
                if(node.prev != -1) next[node.prev] = node.cur;
                if(node.next != -1) prev[node.next] = node.cur;
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++) {
            answer.append(ans[i]);
        }
        return answer.toString();
    }
}

class Node {

    int prev, cur, next;

    public Node(int prev, int cur, int next) {
        this.prev = prev;
        this.cur = cur;
        this.next = next;
    }
}