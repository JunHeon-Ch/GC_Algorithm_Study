package algo_15990;
import java.io.*;

// dp 변수를 int 변수로 하면 틀림
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];

        int max = 3;
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
            if (num[i] > max) {
                max = num[i];
            }
        }

        double[][] dp = new double[max + 1][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][3] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;

        int div = 1000000009;
        for (int i = 4; i <= max; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3])%div;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3])%div;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2])%div;
        }
        for (int i : num) {
            bw.write(String.format("%.0f\n",(dp[i][1] + dp[i][2] + dp[i][3])%div));
        }
        bw.flush();
        bw.close();
    }
}

