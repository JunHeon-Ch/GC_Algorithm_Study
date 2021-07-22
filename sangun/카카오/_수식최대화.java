import java.util.ArrayList;

public class _수식최대화 {
    static boolean[] visited = new boolean[3];
    static char[] seq = {'+', '-', '*'};

    static ArrayList<Long> value = new ArrayList<>();
    static ArrayList<Long> tempValue = new ArrayList<>();
    static ArrayList<Character> cal = new ArrayList<>();
    static ArrayList<Character> tempCal = new ArrayList<>();
    static long ans = 0;

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        long answer = 0;


        String v = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '+') {
                tempCal.add(expression.charAt(i));
                tempValue.add(Long.parseLong(v));
                v = "";
            } else if (i == expression.length() - 1) {
                v += expression.charAt(i);
                tempValue.add(Long.parseLong(v));
            } else {
                v += expression.charAt(i);
            }
        }
        System.out.println(tempValue);
        System.out.println(tempCal);

        char[] s = new char[3];
        go(0, 3, 3, s);
        System.out.println(ans);

    }

    static void go(int index,  int n, int m, char[] k) {
        if (index == m) {
            value.addAll(tempValue);
            cal.addAll(tempCal);
            long z = max(k);
            System.out.println(z);
            value.remove(0);
            ans = Math.max(ans, z);
            for (char a: k){
                System.out.print(a+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            k[index] = seq[i];
            go(index + 1, n, m, k);
            visited[i] = false;
        }
    }

    static Long calculate(Long a, Long b, char cal) {
        if (cal == '-') return a - b;
        else if (cal == '+') return a + b;
        else return a * b;
    }

    static Long max(char[] seq) {
        for (int i = 0; i < 3; i++) {
            if (value.size() == 1) break;
            for (int j = 0; j < cal.size(); j++) {
                if (value.size() == 1) break;
                if (seq[i] == cal.get(j)) {
                    Long val = calculate(value.get(j), value.get(j + 1), seq[i]);
                    value.remove(j);
                    value.remove(j);
                    value.add(j, val);
                    cal.remove(j);
                    j--;
                }

            }
        }
        return Math.abs(value.get(0));
    }
}
