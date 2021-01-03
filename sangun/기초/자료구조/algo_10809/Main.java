package algo_10809;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        final int[] arr = new int[26];
        Arrays.fill(arr,-1);

        int cnt=0;
        for (char ch : s.toCharArray()) {
            if (arr[ch-97]==-1){
                arr[ch - 97]= cnt;
            }
            cnt++;

        }
        for (int i = 0; i < 26; i++) {
            bw.write(arr[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
