package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 매직스퀘어로변경하기 {
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] seq = new int[9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                seq[i++] = Integer.parseInt(st.nextToken());
            }
            i--;
        }
        int[] p = new int[9];
        for (int i = 1; i < 10; i++) {
            p[i - 1] = i;
        }

        do {
            if (valid(p)) {
                int total = 0;
                for (int i = 0; i < 9; i++) {
                    total += Math.abs(p[i] - seq[i]);
                }
                ans = Math.min(ans, total);
            }

        } while (next_permutation(p));

        System.out.println(ans);
    }

    static boolean next_permutation(int[] seq) {
        int i = seq.length - 1;
        while (i > 0 && seq[i - 1] >= seq[i]) i--;
        if (i == 0) return false;

        int j = seq.length - 1;

        while (seq[i - 1] >= seq[j]) j--;

        int tmp = seq[i - 1];
        seq[i - 1] = seq[j];
        seq[j] = tmp;

        j = seq.length - 1;
        while (i < j) {
            tmp = seq[i];
            seq[i] = seq[j];
            seq[j] = tmp;
            i++;
            j--;
        }
        return true;
    }


    static boolean valid(int[] m) {
        int total = m[0] + m[1] + m[2];
        if (m[3] + m[4] + m[5] != total) return false;
        if (m[6] + m[7] + m[8] != total) return false;

        if (m[0] + m[3] + m[6] != total) return false;
        if (m[1] + m[4] + m[7] != total) return false;
        if (m[2] + m[5] + m[8] != total) return false;

        if (m[0] + m[4] + m[8] != total) return false;
        if (m[6] + m[4] + m[2] != total) return false;

        return true;
    }
}
