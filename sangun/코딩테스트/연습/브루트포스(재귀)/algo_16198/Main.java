package algo_16198;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> num = new ArrayList<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            num.add(temp);
        }
        dfs(0);
        bw.write(max + "\n");
        bw.close();

    }

    static void dfs(int sum) {
        if (num.size() == 2) {
            max = Math.max(sum, max);
            return;
        }
        for (int i = 1; i < num.size() - 1; i++) {
            int temp = num.get(i);
            num.remove(i);
            dfs(sum + num.get(i - 1) * num.get(i));
            num.add(i, temp);
        }
    }
}
