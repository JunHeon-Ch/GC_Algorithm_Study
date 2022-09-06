package PS_2022.BOJ.String.회문_17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/17609
 * 알고리즘: 문자열, 투포인터
 * 시간복잡도: O(n), n=100,000(문자열 길이)
 */

public class Main {

    static char[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
            str = br.readLine().toCharArray();
            int l = 0, r = str.length - 1;
            if(check(l, r)) sb.append(0 + "\n");
            else {
                if(subCheck(l, r)) sb.append(1 + "\n");
                else sb.append(2 + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    static boolean check(int l, int r) {
        while(l <= r) {
            if(str[l] != str[r]) return false;
            l++; r--;
        }
        return true;
    }

    static boolean subCheck(int l, int r) {
        while(l <= r) {
            if(str[l] != str[r]) {
                boolean flag1 = check(l + 1, r);
                boolean flag2 = check(l, r - 1);
                if(!flag1 && !flag2) return false;
                return true;
            }
            l++; r--;
        }
        return true;
    }
}
