package algo_17103;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        int[] arr = new int[1000001];

        for (int i = 2; i <= 1000; i++) {
            if (arr[i] == 1) {
                continue;
            }
            int temp = i - 1;
            while (temp != 1) {
                if (i % temp == 0) {
                    arr[i] = 1;
                    break;
                }
                temp--;
            }
            if (temp == 1) {
                for (int j = i; j * i <= 1000000; j++) {
                    arr[j * i] = 1;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            cnt = 0;
            for (int j = 2; j <= num / 2; j++) {
                if (arr[j] == 0 && arr[num - j] == 0) {
                    cnt++;
                }
            }
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();


    }
}
