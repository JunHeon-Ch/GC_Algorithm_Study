package PS_2022.BOJ.스택.괄호_제거_2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.acmicpc.net/problem/2800
 * 알고리즘: 스택
 * 시간복잡도: O(2^n), n=10(최대 괄호 쌍 갯수)
 */
public class Main {

    static String exp;
    static List<Position> list;
    static boolean[] check;
    static int len;
    static Set<String> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        exp = br.readLine();
        len = exp.length();

        Stack<Integer> stack = new Stack<>();
        list = new ArrayList<>();
        int i = 0;
        for(char c : exp.toCharArray()) {
            if(c == '(') {
                stack.push(i);
            } else if(c == ')') {
                list.add(new Position(stack.pop(), i));
            }
            i++;
        }

        check = new boolean[len];
        ans = new TreeSet<>();
        solve(0, 0);
        for(String res : ans) {
            System.out.println(res);
        }
    }

    public static void solve(int index, int selected) {
        if(selected > 0) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < exp.length(); i++) {
                if(check[i]) continue;
                sb.append(exp.charAt(i));
            }
            ans.add(sb.toString());
        }
        if(index >= list.size()) return;
        solve(index + 1, selected);
        Position pos = list.get(index);
        check[pos.start] = true;
        check[pos.end] = true;
        solve(index + 1, selected + 1);
        check[pos.start] = false;
        check[pos.end] = false;
    }
}

class Position {

    int start, end;

    public Position(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
