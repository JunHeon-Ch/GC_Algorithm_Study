package algo_11656;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] rank = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            rank[i] = s.substring(i);
        }
        Arrays.sort(rank);
        for (int i =0;i<s.length();i++){
            bw.write(rank[i]+"\n");
        }
        bw.flush();
        bw.close();


    }
}
