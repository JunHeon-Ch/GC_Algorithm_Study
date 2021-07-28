package 기초.그래프와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class no13913 {
    public static int n;
    public static int k;
    public static int[] walk = new int[100001];
    public static int[] parent = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(walk[k]-1);
        Stack<Integer> s = new Stack<>();
        int idx = k;
        while (idx != n) {
            s.push(idx);
            idx = parent[idx];
        }
        s.push(idx);

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        walk[n] = 1;

        while(!queue.isEmpty()){
            int now = queue.poll();

            if (now + 1 <= 100000 && walk[now + 1] == 0) {
                walk[now + 1] = walk[now] + 1;
                parent[now + 1] = now;
                queue.add(now + 1);
            }
            if (now - 1 >= 0 && walk[now - 1] == 0) {
                walk[now - 1] = walk[now] + 1;
                parent[now - 1] = now;
                queue.add(now - 1);
            }
            if (now * 2 <= 100000 && walk[now * 2] == 0) {
                walk[now * 2] = walk[now] + 1;
                parent[now * 2] = now;
                queue.add(now * 2);
            }

            if (walk[k] != 0) {
                return;
            }
        }
    }
}
