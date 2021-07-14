package algo_1978;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n + 1];

        int[] arr = new int[1001];
        arr[1] = 1;
        for (int i = 2; i < 35; i++) {
            if (arr[i] == 1) {
                continue;
            } else {
                int temp = i - 1;
                while (temp != 1) {
                    if (i % temp == 0) {
                        arr[i] = 1;
                        break;
                    }
                    temp--;
                }
                if (temp == 1) {
                    arr[i] = 0;
                }

                for (int j = i; j * i < 1001; j++) {
                    arr[i * j] = 1;
                }

            }
        }

        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (arr[nums[i]] == 0) {
                result++;
            }
        }

        System.out.println(result);

    }
}
