package algo_6588;

import java.io.*;


public class Main {
    public static int[] prime = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // prime number != 1;
        for (int i = 2; i <= 1000; i++) {
            if (prime[i] == 1) {
                continue;
            }
            int tmp = i - 1;
            while (tmp > 1) {
                if (i % tmp == 0) {
                    prime[i] = 1;
                    break;
                }
                tmp--;
            }
            if (tmp == 1) {
                for (int j = i; j * i <= 1000000; j++) {
                    prime[j * i] = 1;
                }
            }
        }
        int n = 1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            guess(n);
        }

    }

    public static void guess(int n) throws IOException {
        boolean valid = true;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 3; i <= n / 2; i += 2) {
            if (prime[n - i] == 0 && prime[i] == 0) {
                bw.write(n + " = " + i + " + " + (n - i) + "\n");
                valid = false;
                break;
            }
        }
        if (valid) {
            bw.write("Goldbach's conjecture is wrong.\n");
        }
        bw.flush();
    }
}