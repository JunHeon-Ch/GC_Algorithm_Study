package algo_10844;

import java.util.Scanner;

public class Old_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] even = new int[10];
        int[] odd = new int[10];

        for (int i = 1; i < 10; i++) {
            odd[i]++;
        }
        int div = 1000000000;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even[9] = odd[8] % div;
                even[0] = odd[1] % div;
                for (int j = 1; j < 9; j++) {
                    even[j] = (odd[j - 1] + odd[j + 1]) % div;
                }
            } else {
                odd[9] = even[8] % div;
                odd[0] = even[1] % div;
                for (int j = 1; j < 9; j++) {
                    odd[j] = (even[j - 1] + even[j + 1]) % div;
                }
            }

        }

        long total = 0;
        if (n % 2 == 0) {
            for (int i = 0; i < 10; i++) {
                total += even[i];
            }
        } else {
            for (int i = 0; i < 10; i++) {
                total += odd[i];
            }

        }
        System.out.println(total%div);
    }
}
