package algo_1373;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int n0, n1, n2;
        if (s.length() % 3 == 1) {
            if (s.length() == 1) {
                System.out.print(0);
            } else {
                System.out.print(1);
            }
            for (int i = 1; i < s.length(); i += 3) {
                n0 = s.charAt(i) - '0';
                n1 = s.charAt(i + 1) - '0';
                n2 = s.charAt(i + 2) - '0';
                System.out.print(n0 * 4 + n1 * 2 + n2 * 1);
            }
        } else if (s.length() % 3 == 2) {
            int temp = s.charAt(0) - '0';
            int temp2 = s.charAt(1) - '0';

            System.out.print(temp * 2 + temp2 * 1);
            for (int i = 2; i < s.length(); i += 3) {
                n0 = s.charAt(i) - '0';
                n1 = s.charAt(i + 1) - '0';
                n2 = s.charAt(i + 2) - '0';
                System.out.print(n0 * 4 + n1 * 2 + n2 * 1);
            }
        } else {
            for (int i = 0; i < s.length(); i += 3) {
                n0 = s.charAt(i) - '0';
                n1 = s.charAt(i + 1) - '0';
                n2 = s.charAt(i + 2) - '0';
                System.out.print(n0 * 4 + n1 * 2 + n2 * 1);
            }
        }
    }
}
