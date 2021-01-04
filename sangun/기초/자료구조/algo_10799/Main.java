package algo_10799;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        Stack<Integer> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.peek() == i - 1) {
                    stack.pop();
                    result += stack.size();
                }else{
                    stack.pop();
                    result+=1;
                }
            }
        }
        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}
