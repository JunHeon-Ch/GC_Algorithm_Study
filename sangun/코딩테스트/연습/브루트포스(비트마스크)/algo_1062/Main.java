package algo_1062;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit = new boolean[26];
    static boolean[][] word;
    static int n, k;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visit['a' - 'a'] = true;
        visit['n' - 'a'] = true;
        visit['t' - 'a'] = true;
        visit['i' - 'a'] = true;
        visit['c' - 'a'] = true;

        word = new boolean[n][26];
        for (int i = 0; i < n; i++) {
            // 앞뒤를 자르면 시간이 거의 10배 가량 단축됨
            char[] temp = br.readLine().replaceAll("anta|tica", "").toCharArray();
            for (int j = 0; j < temp.length; j++) {
                word[i][temp[j] - 'a'] = true;
            }
        }
        dfs(0, 0);
        bw.write(max + "\n");
        bw.close();

    }

    static void dfs(int index, int depth) {
        if (depth == k-5) {
            int ans = 0;
            for (int i = 0; i < n; i++) {
                boolean check = true;
                for (int j = 0; j < 26; j++) {
                    if (word[i][j] && !visit[j]) {
                        check = false;
                        break;
                    }
                }
                if (check) ans++;
            }
            max = Math.max(ans, max);
            return;
        }
        for (int i = index; i < 26; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            dfs(i + 1, depth + 1);
            visit[i] = false;
        }
    }
}
