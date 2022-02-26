package BOJ.그리디.크게_만들기_2812;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2812
 * 알고리즘: 그리디(스택)
 * 시간복잡도:O(n+k), n=500,000(자리수), k=500,000(지워야 할 숫자의 개수), k < n
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] num = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < n) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < num[i]) {
                stack.pop();
                k--;
            }
            stack.push(num[i]);
            i++;
        }
        while(k > 0) {
            stack.pop();
            k--;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] ans = new char[stack.size()];
        i = 0;
        for (char c : stack) {
            ans[i++] = c;
        }
        for (i = 0; i < ans.length; i++) {
            bw.write(ans[i] + "");
        }
        bw.flush();
    }
}
