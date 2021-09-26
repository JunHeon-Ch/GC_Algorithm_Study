package 다시풀기;


public class 괄호변환 {
    static StringBuilder sb;
    public static void main(String[] args) {
        String p = "()()((()(())))";
        sb = new StringBuilder();
        sol(p);
        System.out.println(sb.toString());

    }
    static void sol(String p) {
        if (p.equals("")) {
            return;
        }
        int threshold = divide(p);

        String u = p.substring(0, threshold + 1);
        String v = p.substring(threshold + 1);

        if (!valid(u)) {
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

    static boolean valid(String p) {
        int cnt = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') cnt++;
            else {
                if (cnt <= 0) return false;
                cnt--;
            }
        }
        if (cnt == 0) return true;
        else return false;
    }

    static int divide(String p) {
        int right = 0;
        int left = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }
            if (right == left) return i;
        }
        return -1;
    }
}
