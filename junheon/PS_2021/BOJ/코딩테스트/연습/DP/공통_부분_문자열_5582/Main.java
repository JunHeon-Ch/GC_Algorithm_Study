package PS_2021.BOJ.코딩테스트.연습.DP.공통_부분_문자열_5582;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        String s2 = br.readLine();
        int l1 = s1.length();
        int l2 = s2.length();

        int[][] d = new int[l1 + 1][l2 + 1];
        boolean[][] c = new boolean[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    c[i][j] = true;
                    if (i - 1 == 0 || j - 1 == 0 || c[i - 1][j - 1]) {
                        d[i][j] = d[i - 1][j - 1] + 1;
                    }
                    else {
                        d[i][j] = 1;
                    }
                }
                else {
                    d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
                    d[i][j] = Math.max(d[i][j], d[i - 1][j - 1]);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i <= l2; i++) {
            ans = Math.max(d[l1][i], ans);
        }
        for(int i = 0; i <= l1; i++) {
            ans = Math.max(d[i][l2], ans);
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
