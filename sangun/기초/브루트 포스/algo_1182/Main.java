package algo_1182;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for (int i = 1; i < (1 << n); i++) {
            int sum = 0;
            for (int k = 0; k < n; k++) {
                if ((i & (1 << k)) != 0) {
                    sum += num[k];
                }
            }
            if (sum == s) {
                ans++;
            }
        }
        bw.write(ans+"\n");
        bw.close();

    }
}

