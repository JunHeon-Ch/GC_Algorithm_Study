package algo_15989;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int[] num = new int[t];
        int max = -1;
        for (int i = 0; i < t; i++) {
            num[i] = Integer.parseInt(br.readLine());
            if (max < num[i]) {
                max = num[i];
            }
        }
        int[] d = new int[max + 1];
        d[0] = 1;
        for (int j = 1; j < 4; j++) {
            for (int k = 1; k <= max; k++) {
                if (k - j >= 0) {
                    d[k] += d[k - j];
                }
            }
        }

        for (int i = 0; i < t; i++) {

            bw.write(d[num[i]] + "\n");
        }

        bw.close();

    }

}
