package 다시풀기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 수식최대화 {
    static boolean[] visited;
    static ArrayList<Long> v;

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";


        char[] o = {'+', '-', '*'};
        visited = new boolean[3];
        v = new ArrayList<>();

        dfs(expression, 0, o, new char[3]);
        v.sort(Comparator.reverseOrder());
        System.out.println(v.get(0));
    }

    static void dfs(String expression, int index, char[] o, char[] ans) {
        if (index == 3) {
            calculate(expression, ans);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (visited[i]) continue;
            ans[index] = o[i];
            visited[i] = true;
            dfs(expression, index + 1, o, ans);
            visited[i] = false;

        }
    }

    static void calculate(String str, char[] o) {
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<String> cal = new ArrayList<>();

        int point = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                arr.add(str.substring(point, i));
                arr.add(str.charAt(i) + "");
                point = i + 1;
            }
        }
        arr.add(str.substring(point));

        for (char op : o) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).equals(op + "")) {
                    Long result = operation(op, Long.parseLong(arr.get(i - 1)), Long.parseLong(arr.get(i + 1)));
                    arr.remove(i + 1);
                    arr.add(i + 1, String.valueOf(result));
                    cal.remove(cal.size() - 1);
                    cal.add(String.valueOf(result));
                    i++;
                } else {
                    cal.add(arr.get(i));
                }
            }
            arr = new ArrayList<>(cal);
            cal = new ArrayList<>();
        }
        v.add(Math.abs(Long.parseLong(arr.get(0))));
    }

    static Long operation(char op, Long v1, Long v2) {
        if (op == '*') return v1 * v2;
        if (op == '+') return v1 + v2;
        return v1 - v2;
    }
}
