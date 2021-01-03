package algo_2004;

import java.util.Scanner;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();
        long m = sc.nextInt();

        if (n / 2 < m) {
            m = n - m;
        }
        long r = n - m;

        long five = 5;


        long nNum = 0;
        long rNum = 0;
        long mNum = 0;

        while (n / five != 0) {
            nNum += n / five;
            if (r / five != 0) {
                rNum += r / five;
            }
            if (m / five != 0) {
                mNum += m / five;
            }
            five *= 5;
        }


        long two = 2;
        long nNum2 = 0;
        long rNum2 = 0;
        long mNum2 = 0;

        while (n / two != 0) {
            nNum2 += n / two;
            if (r / two != 0) {
                rNum2 += r / two;
            }
            if (m / two != 0) {
                mNum2 += m / two;
            }
            two *= 2;
        }

        long f = nNum - mNum - rNum;
        long t = nNum2 - mNum2 - rNum2;
        System.out.println(min(f, t));

    }

}
