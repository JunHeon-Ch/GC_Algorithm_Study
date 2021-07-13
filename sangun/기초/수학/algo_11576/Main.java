package algo_11576;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int m = sc.nextInt();

        int[] num = new int[m];

        for (int i = 0; i < m; i++) {
            num[i] = sc.nextInt();
        }

        int total = 0;
        int temp = 0;
        for (int i = m - 1; i >= 0; i--) {
            total += pow(a, i) * num[temp];
            temp++;
        }
        Stack<Integer> stack = new Stack<>();
        if (total == 0) {
            System.out.println(0);
        } else {
            while (total != 0) {
                stack.push(total % b);
                total /= b;
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }

    }
}
