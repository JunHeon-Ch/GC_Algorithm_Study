package PS_2021.신한카드_공채_2021.본테스트._4;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = stack.size();
            while(!stack.empty() && stack.peek() <= height[i]) {
                stack.pop();
            }
            stack.push(height[i]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}