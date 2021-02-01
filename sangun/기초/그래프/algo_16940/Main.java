package algo_16940;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] num = new ArrayList[n];
        for (int i = 0; i < n; i++) num[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            num[a].add(b);
            num[b].add(a);
        }

        int[] seq = new int[n];
        int[] ord = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            seq[i] = Integer.parseInt(st.nextToken()) - 1;
            ord[seq[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(num[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    if (ord[a] < ord[b]) {
                        return -1;
                    } else return 1;
                }
            });
        }
        boolean[] check = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        q.offer(0);
        check[0] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            arr.add(x);
            for (int y : num[x]) {
                if (!check[y]) {
                    q.add(y);
                    check[y] = true;
                }
            }
        }
        boolean ans = true;
        for (int i = 0; i < n; i++) {
            if (arr.get(i) != seq[i]) {
                ans = false;
                break;
            }
        }
        if (ans) bw.write(1 + "\n");
        else bw.write(0 + "\n");
        bw.close();
    }

}

