package algo_1748;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = n;

        int result = 0;
        int cnt = 0;
        while (m != 0) {
            m /= 10;
            cnt++;
        }
        int temp = (int) Math.pow(10, cnt - 1);
        result = (n - temp + 1) * cnt;
        cnt--;

        while (cnt != 0) {
            temp = (int) Math.pow(10, cnt - 1) * 9;
            result += cnt * temp;
            cnt--;
        }
        System.out.println(result);
    }
}
