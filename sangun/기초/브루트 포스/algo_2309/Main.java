package algo_2309;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = 100;
        int size = 9;
        int sum = 0;
        int[] num = new int[size];

        for (int i = 0; i < size; i++) {
            num[i] = Integer.parseInt(br.readLine());
            sum += num[i];
        }

        boolean checked = false;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (sum - (num[i] + num[j]) == max) {
                    num[i] = -1;
                    num[j] = -1;
                    checked = true;
                    break;
                }
            }
            if (checked) break;
        }

        Arrays.sort(num);

        for (int k : num) if (k != -1) bw.write(k + "\n");

        bw.flush();
        bw.close();
        br.close();


    }
}
