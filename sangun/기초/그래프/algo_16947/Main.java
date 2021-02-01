package algo_16947;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] check;
    static ArrayList<Integer>[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        num = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) num[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            num[a].add(b);
            num[b].add(a);
        }
        check = new int[n + 1];
        go(1, -1);

        for (int k:check) System.out.println(k);

        int[] dist = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (check[i] == 2) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int k : num[x]) {
                if (check[k] == 2) continue;
                check[k] = 2;
                dist[k] = dist[x] + 1;
                q.offer(k);
            }
        }
        for (int i = 1; i <= n; i++) {
            bw.write(dist[i] + " ");
        }
        bw.write("\n");
        bw.close();

    }

    static int go(int x, int p) {
        if (check[x] == 1) return x;
        check[x] = 1;
        for (int y : num[x]) {
            if (y == p) continue;
            int res = go(y, x);
            if (res == -2) return -2;
            if (res >= 0) {
                check[x] = 2;
                if (x == res) return -2;
                else return res;
            }
        }
        return -1;
    }
}
