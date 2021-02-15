package algo_14888;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static ArrayList<Integer> op = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                op.add(i);
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        do {
            int ans = num[0];
            for (int i = 1, k = 0; i < num.length; i++) {
                if (op.get(k) == 0) ans += num[i];
                else if (op.get(k) == 1) ans -= num[i];
                else if (op.get(k) == 2) ans *= num[i];
                else if (op.get(k) == 3) ans /= num[i];
                k++;
            }
            max = Math.max(max, ans);
            min = Math.min(min, ans);
        } while (permutation());

        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.close();
    }

    static boolean permutation() {
        int i = op.size() - 1;
        while (i > 0 && op.get(i) <= op.get(i - 1)) i--;
        if (i <= 0) return false;
        int j = op.size() - 1;
        while (op.get(i - 1) >= op.get(j)) j--;
        swap(i - 1, j);
        j = op.size() - 1;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;

    }

    static void swap(int a, int b) {
        Collections.swap(op, a, b);
    }
}
