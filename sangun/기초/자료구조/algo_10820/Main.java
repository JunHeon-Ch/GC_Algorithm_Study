package algo_10820;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = "";
        while ((s = br.readLine()) != null) {

            int[] result = new int[4];

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    result[0]++;
                } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    result[1]++;
                } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    result[2]++;
                } else if (s.charAt(i) == ' ') {
                    result[3]++;
                }
            }
            bw.write(result[0] + " " + result[1] + " " + result[2] + " " + result[3] + "\n");
            bw.flush();
        }

    }
}
