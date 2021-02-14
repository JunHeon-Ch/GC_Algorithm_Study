package algo_14225;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // visit 배열을 사용하지않고 ans를 통해 더하면 답이 틀림
        // 이 for문 다시 한번 강의가 필요함 ㅜ
        boolean[] visit = new boolean[2000001];
        for (int i = 1; i < (1 << n); i++) {
            int sum = 0;
            for (int k = 0; k < n; k++) {
                if ((i & (1 << k)) > 0) {
                    sum += num[k];
                }
            }
            visit[sum] = true;
        }

        for (int i = 1; i <= 2000001; i++) {
            if (!visit[i]) {
                bw.write(i + "\n");
                bw.close();
                break;
            }
        }

    }
}
