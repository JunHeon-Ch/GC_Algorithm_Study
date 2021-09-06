import java.util.*;

public class 가장먼노드 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        ArrayList<ArrayList<Integer>> node = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            node.add(new ArrayList<>());
        }

        for (int[] k : edge) {
            node.get(k[0]).add(k[1]);
            node.get(k[1]).add(k[0]);
        }


        Integer[] dist = new Integer[n + 1];
        Arrays.fill(dist, 0);
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int vertex = q.remove();
            for (int nextNode : node.get(vertex)) {
                if (visited[nextNode]) continue;
                visited[nextNode] = true;
                q.add(nextNode);
                dist[nextNode] = dist[vertex] + 1;
            }
        }

        Arrays.sort(dist, Collections.reverseOrder());
        int max = dist[0];
        int cnt = 1;
        for (int i = 1; i < dist.length; i++) {
            if (max != dist[i]) break;
            cnt++;
        }
        System.out.println(cnt);

    }

}

