package algo_3085;

import java.io.*;

public class Main {
    static char[][] s = new char[50][50];
    static int n;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            s[i] = br.readLine().toCharArray();
        }

        // no swap
        max = count();
        int cnt;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (s[i][j] != s[i][j + 1]) {
                    char temp = s[i][j];
                    s[i][j] = s[i][j + 1];
                    s[i][j + 1] = temp;
                    cnt = count();
                    if (cnt > max) max = cnt;
                    temp = s[i][j];
                    s[i][j] = s[i][j + 1];
                    s[i][j + 1] = temp;
                }
                if (s[j][i] != s[j + 1][i]) {
                    char temp = s[j][i];
                    s[j][i] = s[j + 1][i];
                    s[j + 1][i] = temp;
                    cnt = count();
                    if (cnt > max) max = cnt;
                    temp = s[j][i];
                    s[j][i] = s[j + 1][i];
                    s[j + 1][i] = temp;
                }

            }
        }
        bw.write((max + 1) + "\n");
        bw.flush();
        bw.close();
    }

    public static int count() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt=0;
            for (int j = 0; j < n - 1; j++) {
                if (s[i][j] == s[i][j + 1]) {
                    cnt++;
                } else {
                    if (max < cnt) max = cnt;
                    cnt = 0;
                }
            }
            if (max < cnt) max = cnt;
        }

        cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt=0;
            for (int j = 0; j < n - 1; j++) {
                if (s[j][i] == s[j + 1][i]) {
                    cnt++;
                } else {
                    if (max < cnt) max = cnt;
                    cnt = 0;
                }
            }
            if (max < cnt) max = cnt;
        }

        return max;
    }
}
