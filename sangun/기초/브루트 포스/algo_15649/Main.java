package algo_15649;

import java.util.Scanner;

public class Main {
    public static boolean[] valid = new boolean[10];
    public static int[] num = new int[10];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        go(0, n, m);

        System.out.println(sb.toString());


    }

    public static void go(int index, int n, int m) {
        if (index == m) {
            for (int k : num) {
                if (k != 0) {
                    sb.append(k).append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (valid[i]) continue;
            valid[i] = true;
            num[index] = i;
            go(index + 1, n, m);
            valid[i] = false;
        }
    }
}
