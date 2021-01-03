package algo_2745;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());


        double s = 0;

        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) - '0' > 9) {
                s += (n.charAt(i) - 55) * pow(b, n.length() - i - 1);
            } else {
                s += (n.charAt(i) - '0') * pow(b, n.length() - i - 1);
            }
        }
        sb.append(String.format("%.0f", s));
        bw.write(sb.toString() + "");
        bw.flush();
        bw.close();

    }
}
