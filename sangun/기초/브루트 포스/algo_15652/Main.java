package algo_1;

import java.util.Scanner;

public class Main {
    public static int[] num = new int[10];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        go(0, n, m, 1);
        System.out.println(sb.toString());

    }

    public static void go(int index, int n, int m, int s) {
        if (index == m) {
            for (int k : num) {
                if (k != 0) sb.append(k + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = s; i <= n; i++) {
            num[index] = i;
            go(index + 1, n, m, i);
        }
    }
}


