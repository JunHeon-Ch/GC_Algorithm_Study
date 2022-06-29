package PS_2021.BOJ.코딩테스트.문제.브루트포스.괄호_추가하기2_16638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Priority {
    char operator;
    int prior;

    public Priority(char operator, int prior) {
        this.operator = operator;
        this.prior = prior;
    }
}

public class Main {

    static int N;
    static char[] op;
    static long ans = Long.MIN_VALUE;
    static boolean[] parentheses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        op = br.readLine().toCharArray();
        parentheses = new boolean[N];
        solve(1);
        System.out.println(ans);
    }

    public static void solve(int idx) {
        if (idx >= N) {
            long res = calc(infixToPostfix());
            ans = Math.max(ans, res);
            return;
        }
        if (idx == 1) {
            parentheses[idx] = true;
            solve(idx + 2);
            parentheses[idx] = false;
        } else {
            if (!parentheses[idx - 2]) {
                parentheses[idx] = true;
                solve(idx + 2);
                parentheses[idx] = false;
            }
        }
        solve(idx + 2);
    }

    public static int priority(char c) {
        if(c == '*') return 1;
        return 2;
    }

    public static String infixToPostfix() {
        String postfix = new String();
        Stack<Priority> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            char c = op[i];
            if (c >= '0' && c <= '9') postfix += c;
            else {
                int prior = priority(c);
                if(parentheses[i]) prior = 0;
                Priority p = new Priority(c, prior);
                while (!stack.empty() && stack.peek().prior <= prior) {
                    postfix += stack.pop().operator;
                }
                stack.push(p);
            }
        }
        while (!stack.empty()) {
            postfix += stack.pop().operator;
        }

        return postfix;
    }

    public static long calc(long n1, long n2, char o) {
        if (o == '-') return n1 - n2;
        if (o == '+') return n1 + n2;
        return n1 * n2;
    }

    public static long calc(String exp) {
        Stack<Long> stack = new Stack<>();
        for (char c : exp.toCharArray()) {
            if (c >= '0' && c <= '9') {
                stack.push((long) c - '0');
            } else {
                long n2 = stack.pop();
                long n1 = stack.pop();
                stack.push(calc(n1, n2, c));
            }
        }
        return stack.pop();
    }
}
