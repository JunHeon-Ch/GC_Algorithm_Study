package PS_2022.BOJ._01_Data_Structure.괄호의_값_2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
https://www.acmicpc.net/problem/2504
 * 알고리즘: 스택
 * 시간복잡도: O(n), n=30(문자열 길이)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        Stack<Character> s = new Stack<>();
        int ans = 0;
        int val = 1;
        char prev = 0;
        for (char c : str) {
            if (c == '(') {
                s.push(c);
                val *= 2;
            } else if (c == '[') {
                s.push(c);
                val *= 3;
            } else if (c == ')') {
                if (s.isEmpty() || s.peek() != '(') {
                    ans = 0;
                    break;
                } else if (prev == '(') ans += val;
                s.pop();
                val /= 2;
            } else if (c == ']') {
                if (s.isEmpty() || s.peek() != '[') {
                    ans = 0;
                    break;
                } else if (prev == '[') ans += val;
                s.pop();
                val /= 3;
            }
            prev = c;
        }
        if (!s.isEmpty()) System.out.println(0);
        else System.out.println(ans);
    }
}
