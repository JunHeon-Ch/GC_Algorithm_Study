package 연습.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1062 {
    public static int n, k, ans;
    public static boolean[] alphabet = new boolean[26];
    public static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new String[n];
        for(int i=0; i<n; i++){
            String str = br.readLine().replaceAll("anta|tica", "");
            arr[i] = str;
        }
        alphabet['a' - 'a'] = true;
        alphabet['n' - 'a'] = true;
        alphabet['t' - 'a'] = true;
        alphabet['i' - 'a'] = true;
        alphabet['c' - 'a'] = true;

        ans = 0;
        dfs(0, 0);
        System.out.println(ans);

    }
    public static void dfs(int start, int alpha_cnt){
        if (alpha_cnt == k - 5) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                boolean flag = true;

                for (int j = 0; j < arr[i].length(); j++) {
                    /* 배우지않은 알파벳이 있는 경우 */
                    if (!alphabet[arr[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    temp++;
                }
            }
            ans = Math.max(temp, ans);
            return;
        }


        for(int i=start; i<26; i++){
            if(!alphabet[i]){
                alphabet[i] = true;
                dfs(i, alpha_cnt + 1);
                alphabet[i] = false;
            }
        }
    }
}
