package algo_6064;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int cnt = x;
            int y1 = cnt % n;
            int temp = 0;
            while (y%n != y1) {
                cnt += m;
                y1 = cnt % n;
                temp++;
                if (temp == n) {
                    cnt = -1;
                    break;
                }
            }
            bw.write(cnt + "\n");

        }
        bw.flush();
        bw.close();
    }
}
