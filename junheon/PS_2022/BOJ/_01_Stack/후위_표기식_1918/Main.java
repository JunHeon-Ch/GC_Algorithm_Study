package PS_2022.BOJ._01_Stack.후위_표기식_1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
https://www.acmicpc.net/problem/1918
 * 알고리즘: 스택
 * 시간복잡도: O(n), n=100(수식의 길이)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] exp = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] >= 'A' && exp[i] <= 'Z') sb.append(exp[i]);
            else if (exp[i] == '(') stack.push(exp[i]);
            else if (exp[i] == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') sb.append(stack.pop());
                stack.pop();
            } else {
                while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(exp[i])) sb.append(stack.pop());
                stack.push(exp[i]);
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb.toString());
    }

    static int precedence(char op) {
        if (op == '*' || op == '/') return 2;
        else if(op == '+' || op == '-') return 1;
        else return 0;
    }
}