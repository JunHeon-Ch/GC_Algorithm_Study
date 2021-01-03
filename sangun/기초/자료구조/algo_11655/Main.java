package algo_11655;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'M') {
                bw.write(Character.toString(s.charAt(i) + 13) + "");
            } else if (s.charAt(i) >= 'N' && s.charAt(i) <= 'Z') {
                bw.write(Character.toString(s.charAt(i) - 13) + "");
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'm') {
                bw.write(Character.toString(s.charAt(i) + 13) + "");
            } else if (s.charAt(i) >= 'n' && s.charAt(i) <= 'z') {
                bw.write(Character.toString(s.charAt(i) - 13) + "");
            }else {
                bw.write(s.charAt(i)+"");
            }
        }
        bw.flush();
        bw.close();
    }
}
