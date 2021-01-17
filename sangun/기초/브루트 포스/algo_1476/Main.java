package algo_1476;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();

        int e1 = 1;
        int s1 = 1;
        int m1 = 1;

        int cnt = 1;
        while (e1 != e || s1 != s || m1 != m) {
            e1 %= 15;
            s1 %= 28;
            m1 %= 19;
            e1++;
            s1++;
            m1++;
            cnt++;
        }
        System.out.println(cnt);

    }
}
