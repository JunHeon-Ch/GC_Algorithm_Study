package PS_2022.BOJ._16_String.단어_뒤집기2_17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/17413
 * 알고리즘: 문자열
 * 시간복잡도: O(n), n=500,000(문자열 길이)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        boolean flag = false;
        for(char c : str) {
            if(c == '<') {
                flag = true;
                sb.append(tmp.reverse());
            }
            if(flag) {
                sb.append(c);
                if(c == '>') {
                    flag = false;
                    tmp = new StringBuilder();
                }
            } else {
                if(c == ' ') {
                    sb.append(tmp.reverse());
                    sb.append(c);
                    tmp = new StringBuilder();
                } else tmp.append(c);
            }
        }
        sb.append(tmp.reverse());
        System.out.println(sb.toString());
    }
}
