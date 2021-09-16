package 푼문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
    static int cnt;
    static int[] visited;

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n = 3;

        visited = new int[n];
        cnt = 1;

        ArrayList<ArrayList<Integer>> node = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            node.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1)
                    node.get(i).add(j);
            }
        }

        System.out.println(node);

        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) continue;
            System.out.println("asd");
            System.out.println(Arrays.toString(visited));
            bfs(node, i);
            cnt++;

        }

        System.out.println(cnt-1);
    }

    static void bfs(ArrayList<ArrayList<Integer>> node, int c) {
        Queue<Integer> q = new LinkedList<>();
        q.add(c);
        visited[c] = cnt;

        while (!q.isEmpty()) {
            int p = q.remove();

            for (int k : node.get(p)) {
                if (visited[k] != 0) continue;
                visited[k] = cnt;
                q.add(k);
            }
        }

    }
}
