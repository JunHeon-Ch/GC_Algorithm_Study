package algo_1107;

import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        for (int i = 0; i < m; i++) {
            int temp = sc.nextInt();
            broken[temp] = true;
        }

        int result = abs(n - 100);
        for (int i = 0; i <= 1000000; i++) {
            int temp = valid(i);
            if (temp != -1) {
                temp = temp + abs(n - i);
                if (temp < result) {
                    result = temp;
                }
            }
        }
        System.out.println(result);


    }

    public static int valid(int n) {
        int cnt = 0;
        if (n == 0) {
            if (broken[0] == true) return -1;
            else return cnt + 1;
        }
        while (n != 0) {
            if (broken[n % 10] == true) {
                return -1;
            }
            n /= 10;
            cnt++;
        }
        return cnt;
    }
}

