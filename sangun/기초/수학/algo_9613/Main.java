package algo_9613;


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[k];

            for (int j = 0; j < k; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            double result = 0;
            for (int j = 0; j < k; j++) {
                for (int z = j + 1; z < k; z++) {
                    result += GCD(arr[j], arr[z]);
                }
            }
            bw.write(String.format("%.0f\n", result));
        }
        bw.flush();
        bw.close();

    }

    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
}
