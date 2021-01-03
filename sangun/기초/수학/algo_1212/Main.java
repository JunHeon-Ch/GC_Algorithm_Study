package algo_1212;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        String[] result = {"000", "001", "010", "011", "100", "101", "110", "111"};

        if (s.charAt(0)=='0'){
          sb.append(0);
        } else if (s.charAt(0) - '0' < 4) {
            int n = s.charAt(0) - '0';
            while (n != 0) {
                sb.append(n % 2);
                n /= 2;
            }
            sb=sb.reverse();
            for (int i = 1; i < s.length(); i++) {
                sb.append(result[s.charAt(i) - '0']);
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                sb.append(result[s.charAt(i) - '0']);
            }
        }

        bw.write(sb.toString() + "");
        bw.flush();
        bw.close();
    }
}
