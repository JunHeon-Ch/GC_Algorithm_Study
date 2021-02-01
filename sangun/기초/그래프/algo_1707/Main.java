package algo_1707;

import java.io.*;
import java.util.*;

public class Main {
    static boolean ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] vertex = new ArrayList[v + 1];
            int[] color = new int[v + 1];
            for (int j = 0; j <= v; j++) {
                vertex[j] = new ArrayList<>();
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                vertex[a].add(b);
                vertex[b].add(a);
            }
            ans = true;
            for (int j = 1; j <= v; j++) {
                if (color[j] == 0) // 정점 i 방문 X인 상태라면,
                    dfs(vertex, color, j, 1);
            }

            for (int j = 1; j <= v; j++) {
                for (int q : vertex[j]) {
                    if (color[j] == color[q]) {
                        ans = false;
                    }
                }
            }
            if (ans) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.close();
    }

    static void dfs(ArrayList<Integer>[] arr, int[] color, int start, int c) {
        color[start] = c;
        for (int k : arr[start]) {
            if (color[k] == 0) {
                dfs(arr, color, k, 3 - c);
            }
        }
    }


}

