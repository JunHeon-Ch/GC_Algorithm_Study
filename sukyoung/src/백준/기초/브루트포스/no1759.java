package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no1759 {
    public static int L;
    public static int C;
    public static String[] var;
    public static String[] ans;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        var = new String[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++)
            var[i] = st.nextToken();

        Arrays.sort(var);
        ans = new String[L];

        DFS(0, "");
        System.out.print(sb);
    }
    public static void DFS(int index, String str){
        if (str.length() == L) {
            if(isValid(str)) {
                sb.append(str).append("\n");
            }
            return;
        }
        if (index >= C) {
            return;
        }
        DFS(index + 1, str + var[index]);
        DFS(index + 1, str);
    }
    public static boolean isValid(String str){
        int cnt_con = 0;
        int cnt_vow = 0;
        char c;
        for(int i=0; i<ans.length; i++){
            c = str.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                cnt_vow++;
            else
                cnt_con++;
        }
        if (cnt_vow >= 1 && cnt_con >= 2) {
            return true;
        }
        return false;
    }
}
