package algo_2003;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] num;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }


        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += num[j];
                if (sum == m) {
                    ans++;
                    break;
                }
                if (sum > m) {
                    break;
                }

            }
        }
        bw.write(ans + "\n");
        bw.close();
    }

}
