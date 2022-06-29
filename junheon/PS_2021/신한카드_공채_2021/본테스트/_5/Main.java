package PS_2021.신한카드_공채_2021.본테스트._5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] scores = new int[3][n];
        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int idx, origin;
            if(scores[0][i] == scores[1][i] && scores[1][i] == scores[2][i] && scores[0][i] == scores[2][i]) {
                ans[i] = scores[0][i];
                continue;
            }
            if (scores[0][i] == scores[1][i]) {
                origin = scores[0][i];
                idx = 2;
            } else if (scores[1][i] == scores[2][i]) {
                origin = scores[1][i];
                idx = 0;
            } else if (scores[0][i] == scores[2][i]) {
                origin = scores[0][i];
                idx = 1;
            } else continue;

            int prev = scores[idx][i];
            scores[idx][i] = origin;
            int j = i - 1;
            while (j >= 0 && scores[idx][j] != origin) {
                int temp = scores[idx][j];
                scores[idx][j] = prev;
                prev = temp;
                j--;
            }
            if(j >= 0) scores[idx][j] = prev;
            ans[i] = origin;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < ans.length; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
