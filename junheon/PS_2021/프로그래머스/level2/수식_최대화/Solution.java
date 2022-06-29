package PS_2021.프로그래머스.level2.수식_최대화;

import java.util.*;

public class Solution {
    ArrayList<String> exp = new ArrayList<>();

    String list = null;
    boolean[] check = null;
    char[] perm = null;

    HashSet<Long> resSet = new HashSet<>();

    public ArrayList<String> makePostfix(String p) {
        ArrayList<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for(String s : exp) {
            if(s.equals("+") || s.equals("-") || s.equals("*")) {
                while(!stack.empty() && p.indexOf(stack.peek()) <= p.indexOf(s)) {
                    postfix.add(stack.pop());
                }
                stack.push(s);
            }
            else {
                postfix.add(s);
            }
        }

        while(!stack.empty()) {
            postfix.add(stack.pop());
        }

        return postfix;
    }

    public long calc(long o1, long o2, char op) {
        switch (op) {
            case '+':
                return o2 + o1;
            case '-':
                return o2 - o1;
            case '*':
                return o2 * o1;
        }
        return 0;
    }

    public void calculate(ArrayList<String> postfix) {
        Stack<String> stack = new Stack<>();

        for(String op : postfix) {
            if(op.equals("+") || op.equals("-") || op.equals("*")) {
                long o1 = Long.parseLong(stack.pop());
                long o2 = Long.parseLong(stack.pop());
                String res = Long.toString(calc(o1, o2, op.charAt(0)));
                stack.push(res);
            }
            else {
                stack.push(op);
            }
        }
        resSet.add(Math.abs(Long.parseLong(stack.pop())));
    }

    public void go(int index, int n) {
        if (index == n) {
            String p = new String(perm);
            ArrayList<String> postfix = makePostfix(p);
            calculate(postfix);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check[i]) continue;
            check[i] = true;
            perm[index] = list.charAt(i);
            go(index + 1, n);
            check[i] = false;
        }
    }

    public long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        HashSet<String> set = new HashSet<>();
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            exp.add(s);
            if (s.equals("-") || s.equals("*") || s.equals("+")) {
                set.add(s);
            }
        }
        list = new String();
        for (String s : set) {
            list += s;
        }
        check = new boolean[list.length()];
        perm = new char[list.length()];

        go(0, list.length());

        long answer = Collections.max(resSet);
        return answer;
    }
}
