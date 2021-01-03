package algo_1929;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] arr = new int[1000001];
        arr[1] = 1;
        for (int i = 2; i <= 1000; i++) {
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

                for (int j = i; j * i < 1000001; j++) {
                    arr[i * j] = 1;
                }

            }
        }

        for (int i = a; i <= b; i++) {
            if (arr[i] == 0) {
                System.out.println(i);
            }
        }


    }
}
