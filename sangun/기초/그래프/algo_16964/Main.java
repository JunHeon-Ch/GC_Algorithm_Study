package algo_16964;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] num;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        num = new ArrayList[n];
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
        for (int i = 0; i < n; i++) {
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
        dfs(check, 0);
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

    static void dfs(boolean[] check, int x) {
        if (check[x]) return;
        check[x] = true;
        arr.add(x);
        for (int k : num[x]) {
            if (check[k]) continue;
            dfs(check, k);
        }
    }
}
