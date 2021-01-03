package algo_10799;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='(')
                stack.push(i);
            else {
                if (stack.peek() == i - 1) {
                    stack.pop();
                    count += stack.size();
                } else {
                    stack.pop();
                    count++;
                }
            }
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
