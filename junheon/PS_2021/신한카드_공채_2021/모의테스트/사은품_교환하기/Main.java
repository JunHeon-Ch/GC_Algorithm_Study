package PS_2021.신한카드_공채_2021.모의테스트.사은품_교환하기;

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t > 0) {
            st = new StringTokenizer(br.readLine());
            long n = Integer.parseInt(st.nextToken());
            long m = Integer.parseInt(st.nextToken());

            long res = Math.min(n / 5, m / 7);
            n -= res * 5;
            m -= res * 7;
            if (n < 5) {
                bw.write(res + "\n");
            } else if(n + m > 12)

            t--;
        }
        String input = br.readLine();
    }
}
