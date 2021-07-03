
public class _문자열압축 {
    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";
        int answer = Integer.MAX_VALUE;

        // 칸
        for (int t = 1; t <= s.length() / 2; t++) {
            String str = "";
            String target;
            String temp = "";
            int cnt = 1;

            target = s.substring(0, t);

            for (int i = t; i < s.length(); i += t) {

                if (i + t < s.length())
                    temp = s.substring(i, i + t);
                else
                    temp=s.substring(i);

                if (target.equals(temp)) {
                    cnt++;
                } else {
                    if (cnt > 1) str += cnt;
                    str += target;
                    cnt = 1;
                    target = temp;
                }

            }
            if (cnt > 1) {
                str += cnt;
            }
            str += target;
            answer = Math.min(answer, str.length());

        }

        System.out.println(answer);
    }
}
