// 1 -> A 출력 / 2 -> Ctrl-A / 3 -> Ctrl-C / 4 -> Ctrl-V

// D(N): n번째에서 A가 출력되는 최댓값
// 점화식 -> D[i] = MAX(j * d[i - j - 1]) (j = 1 ~ i - 1)
// j -> 4를 j번 한 것 / 4는 2, 3이 선행됨

// 1~6까지는 최대값이 i
// 1 -> 1
// 2 -> 11
// 3 -> 111
// 4 -> 1111
// 5 -> 11111
// 6 -> 111234

package BOJ.코딩테스트.연습.DP.크리보드_11058;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] d = new long[101];

        for(int i = 1; i <= 6; i++) {
            d[i] = i;
        }
        for(int i = 7; i <= n; i++) {
            for(int j = 1; j <= i - 3; j++) {
                d[i] = Math.max(d[i], j * d[i - j - 1]);
            }
        }
        bw.write(d[n] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
