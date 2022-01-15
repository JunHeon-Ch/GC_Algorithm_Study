package 백준.구현.홀수홀릭호석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static int min = Integer.MAX_VALUE;
    public static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        findOdd(n, countOdd(n));
        System.out.print(min + " " + max);
    }
    public static void findOdd(int n, int oddCount){
        if (n < 10) {
            max = Math.max(max, oddCount);
            min = Math.min(min, oddCount);
            return;
        }

        if (n < 100) {
            int newNum = n / 10 + n % 10;
            int new_oddCount = countOdd(newNum);
            findOdd(newNum, oddCount + new_oddCount);
            return;
        }

        String str = Integer.toString(n);
        for (int i = 0; i < str.length() - 2; i++) {
            for (int j = i + 1; j < str.length() - 1; j++) {
                String x1 = str.substring(0, i + 1);
                String x2 = str.substring(i + 1, j + 1);
                String x3 = str.substring(j + 1, str.length());

                int nx = Integer.parseInt(x1) + Integer.parseInt(x2) + Integer.parseInt(x3);
                findOdd(nx, countOdd(nx) + oddCount);
            }
        }
    }

    public static int countOdd(int n){
        int sum = 0;
        while (n != 0) {
            if((n % 10) % 2 != 0)
                sum++;
            n /= 10;
        }
        return sum;
    }
}
