// d(i, j): d(i-1, j-1) + 1 if(xi == yi)
// d(i, j): max(d(i-1, j), d(i, j-1)) if(xi != yi)

package PS_2021.BOJ.코딩테스트.연습.DP.LCS2_9252;

import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void printLCS(int[][] d, String s1, String s2, int i, int j) throws IOException {
        if(i == 0 || j == 0) return;
        if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
            printLCS(d, s1, s2, i - 1, j - 1);
            bw.write(s1.charAt(i - 1));
        }
        else {
            if(d[i - 1][j] >= d[i][j - 1]) printLCS(d, s1, s2, i - 1, j);
            else printLCS(d, s1, s2, i, j - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        int l1 = s1.length();
        int l2 = s2.length();

        int[][] d = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1] + 1;
                } else {
                    d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
                }
            }
        }
        bw.write(d[l1][l2] + "\n");
        if(d[l1][l2] != 0) printLCS(d, s1, s2, l1, l2);
        bw.flush();
        bw.close();
        br.close();
    }
}
