package algo_10808;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch-97]++;
        }
        for (int i=0;i<26;i++){
            bw.write(arr[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}
