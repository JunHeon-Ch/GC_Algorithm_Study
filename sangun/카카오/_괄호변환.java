import java.util.Stack;

public class _괄호변환 {
    static StringBuilder sb;

    public static void main(String[] args) {
        String p = "";
        String answer;
        sb = new StringBuilder();


        sol(p);
        System.out.println(sb.toString());


    }

    static void sol(String p) {
        if (p.equals("")) {
            return;
        }
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        Stack<Integer> valid = new Stack<>();

        boolean check = false;
        int threshold = -1;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                left.add(i);
                valid.add(i);
            } else if (p.charAt(i) == ')') {
                right.add(i);
                if (valid.isEmpty()) {
                    check = true;
                }else{
                    valid.pop();
                }
            }

            if (left.size() == right.size()) {
                threshold = i;
                break;
            }
        }

        String u = p.substring(0, threshold + 1);
        String v = p.substring(threshold + 1);

        if (check) {
            sb.append("(");
            sol(v);
            sb.append(")");
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    sb.append(")");
                } else {
                    sb.append("(");
                }
            }

        } else {
            sb.append(u);
            p = v;
            sol(p);
        }
    }
}
