package algo_11653;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean[] prime = new boolean[n + 1];
        prime[0] = prime[1] = false;

        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == false) {
                continue;
            }
            for (int j = i * i; j <= n; j += i) {
                prime[j] = false;
            }
        }
        int temp = n;
        for (int i = 2; i <= temp; i++) {
            if (prime[i] == true && n % i == 0) {
                System.out.println(i);
                n /= i;
                i--;
            }

        }


    }
}
