package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자재배치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] A = st.nextToken().toCharArray();
        int B = Integer.parseInt(st.nextToken());
        int value = -1;
        int temp = value;
        Arrays.sort(A);
        do {
            if (A[0]=='0')continue;
            value = Integer.parseInt(String.valueOf(A));
            if (value >= B) {
                break;
            }
            temp = value;
        } while (next_permutation(A));

        System.out.println(temp);
    }

    static boolean next_permutation(char[] s) {
        int i = s.length - 1;
        while (i > 0 && s[i - 1] >= s[i]) i--;
        if (i == 0) return false;

        int j = s.length - 1;
        while (s[i - 1] >= s[j]) j--;

        char tmp = s[i - 1];
        s[i - 1] = s[j];
        s[j] = tmp;

        j = s.length - 1;

        while (i < j) {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
        return true;


    }
}
