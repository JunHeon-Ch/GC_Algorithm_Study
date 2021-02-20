package algo_2143;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int t, n, m;
    static long[] mrr, nrr;
    static ArrayList<Long> first = new ArrayList<>();
    static ArrayList<Long> second = new ArrayList<>();
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());

        n = Integer.parseInt(br.readLine());
        nrr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nrr[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        mrr = new long[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            mrr[i] = Integer.parseInt(st.nextToken());
        }


        go(n, nrr, first);
        go(m, mrr, second);

        Collections.sort(first);
        Collections.sort(second);

        int front = 0;
        int rear = second.size() - 1;
        while (front < first.size() && rear >= 0) {
            long f = first.get(front);
            long r = second.get(rear);

            if (f + r == t) {
                long fcnt = 0;
                while (front < first.size() && first.get(front) == f) {
                    fcnt++;
                    front++;
                }
                long rcnt = 0;
                while (rear >= 0 && second.get(rear) == r) {
                    rcnt++;
                    rear--;
                }
                ans += fcnt * rcnt;
            }
            if (f + r > t) rear--;
            if (f + r < t) front++;
        }

        bw.write(ans + "\n");
        bw.close();


    }

    static void go(int end, long[] arr, ArrayList<Long> list) {
        for (int i = 0; i < end; i++) {
            long sum = 0;
            for (int j = i; j < end; j++) {
                sum += arr[j];
                list.add(sum);
            }
        }
    }
}
