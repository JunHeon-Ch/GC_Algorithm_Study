package PS_2022.BOJ._03_Tree.트리인가_6416;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/6416
 * 알고리즘: 트리
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> vertex = new HashMap<>();
        int edge = 0;
        int idx = 1;
        while (true) {
            String input = br.readLine();
            if (input.startsWith("-1")) break;

            boolean flag = false;
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                if (u == 0) {
                    flag = true;
                    break;
                }
                vertex.put(u, vertex.getOrDefault(u, 0));
                vertex.put(v, vertex.getOrDefault(v, 0) + 1);
                edge++;
            }

            if (flag) {
                int root = 0;
                boolean correct = true;
                for (int val : vertex.keySet()) {
                    if (vertex.get(val) == 0) root++;
                    else if (vertex.get(val) > 1) correct = false;
                }

                if (vertex.size() == 0) bw.write("Case " + idx + " is a tree.\n");
                else if (root == 1 && correct && vertex.size() - 1 == edge) bw.write("Case " + idx + " is a tree.\n");
                else bw.write("Case " + idx + " is not a tree.\n");

                edge = 0;
                vertex.clear();
                idx++;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
