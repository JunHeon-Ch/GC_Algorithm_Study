package PS_2022.BOJ._10_Bruth_Force.A와B2_12919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/12919
 * 알고리즘: 완전탐색
 * 시간복잡도: ?
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        if(solve(s1, s2)) System.out.println(1);
        else System.out.println(0);
    }

    static boolean solve(String s1, String s2) {
        if(s1.length() == s2.length() && s1.equals(s2)) return true;
        if(s1.length() > s2.length()) return false;
        if(s2.charAt(s2.length() - 1) == 'A') if(solve(s1, s2.substring(0, s2.length() - 1))) return true;
        if(s2.charAt(0) == 'B') if(solve(s1, new StringBuilder(s2.substring(1)).reverse().toString())) return true;
        return false;
    }
}
