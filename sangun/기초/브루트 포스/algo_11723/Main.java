package algo_11723;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int s = 0;


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("add")) {
                int k = Integer.parseInt(st.nextToken());
                s = s | (1 << k);
            } else if (str.equals("remove")) {
                int k = Integer.parseInt(st.nextToken());
                s = s & ~(1 << k);
            } else if (str.equals("check")) {
                int k = Integer.parseInt(st.nextToken());
                if ((s & (1 << k)) == 0) {
                    bw.write(0 + "\n");
                } else bw.write(1 + "\n");
            } else if (str.equals("toggle")) {
                int k = Integer.parseInt(st.nextToken());
                s = s ^ (1 << k);
            } else if (str.equals("all")) {
                s = (1 << 21) - 1;
            } else if (str.equals("empty")) {
                s = 0;
            }
        }
        bw.close();
    }
}

