package BOJ.코딩테스트.문제.브루트포스.차량_번호판1_16968;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_after {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] carNumber = br.readLine().toCharArray();
        int ans = 1;
        for (int i = 0; i < carNumber.length; i++) {
            if (i == 0) {
                // 첫번째 숫자의 경우의 수
                if (carNumber[i] == 'c') ans *= 26;
                else ans *= 10;
            } else {
                //두번째 숫자부터의 경우의 수
                if (carNumber[i] == carNumber[i - 1]) {
                    if (carNumber[i] == 'c') ans *= 25;
                    else ans *= 9;
                } else {
                    if (carNumber[i] == 'c') ans *= 26;
                    else ans *= 10;
                }
            }
        }
        System.out.println(ans);
    }
}
