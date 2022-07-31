package PS_2022.BOJ.Tree.트리_1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/1068
 * 알고리즘: 트리
 * 시간복잡도: O(n^2), n=50(노드 개수)
 */

public class Main {

    static class Node {

        List<Integer> child;
        boolean isDeleted;

        public Node() {
            child = new ArrayList<>();
            isDeleted = false;
        }
    }

    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new Node[n];
        for(int i = 0; i < n; i++) {
            tree[i] = new Node();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if(p == -1) continue;
            tree[p].child.add(i);
        }

        int idx = Integer.parseInt(br.readLine());
        solve(idx);

        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(!tree[i].isDeleted && tree[i].child.size() == 0) ans++;
            else if(tree[i].child.size() == 1 && tree[i].child.get(0) == idx) ans++;
        }
        System.out.println(ans);
    }

    static void solve(int idx) {
        for(int c : tree[idx].child) {
            solve(c);
        }
        tree[idx].child.clear();
        tree[idx].isDeleted = true;
    }
}
