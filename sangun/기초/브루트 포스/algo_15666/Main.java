package algo_15666;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static int[] cnt;
    static int[] arr;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        num = new int[10];
        arr = new int[n];
        cnt = new int[10001];
        cnt[10000] = -n - 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]]++;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    arr[i] = 10000;
                }
            }
        }
        Arrays.sort(arr);

        go(0, n, m,0);
        bw.flush();
        bw.close();


    }

    static void go(int index, int n, int m,int s) throws IOException {
        if (index == m) {
            for (int k : num) {
                if (k != 0) bw.write(k + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = s; i < n; i++) {
            if (cnt[arr[i]] > -n) {
                num[index] = arr[i];
                cnt[arr[i]]--;
                go(index + 1, n, m,i);
                cnt[arr[i]]++;
            }
        }
    }
}
