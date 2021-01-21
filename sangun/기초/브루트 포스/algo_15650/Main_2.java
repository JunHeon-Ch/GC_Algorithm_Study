package algo_15650;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2 {
    static int[] num = new int[10];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        go(1, 0, n, m);

        bw.flush();
        bw.close();
    }

    static void go(int index, int selected, int n, int m) throws IOException {
        if (selected == m) {
            for (int k : num) {
                if (k != 0) bw.write(k + " ");
            }
            bw.write("\n");
            return;
        }
        if (index > n) return;
        num[selected] = index;
        go(index + 1, selected + 1, n, m);
        num[selected] = 0;
        go(index + 1, selected, n, m);
    }
}
