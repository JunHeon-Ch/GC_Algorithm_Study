package algo_4375;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            int div = 1;
            int cnt = 1;
            while (div % n != 0) {
                div = (div * 10) % n + 1;
                cnt++;
            }
            bw.write(cnt + "\n");
        }
        bw.close();
    }
}

