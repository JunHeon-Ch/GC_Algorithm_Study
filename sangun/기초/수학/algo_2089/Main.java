package algo_2089;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 0) {
            System.out.print(0);
        } else cal(n);
    }

    public static void cal(int n) {
        if (n == 0) {
            return;
        } else if (n < 0) {
            cal(-(n - 1) / 2);
            System.out.print(-n % 2);
        } else {
            cal(-n / 2);
            System.out.print(n % 2);
        }
    }
}
