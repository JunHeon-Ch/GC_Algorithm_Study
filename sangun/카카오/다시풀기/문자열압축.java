package 다시풀기;


public class 문자열압축 {
    public static void main(String[] args) {

        String s = "aabbaccc";

        int len = 0;
        int answer = Integer.MAX_VALUE;

        while (len != s.length()) {
            len++;
            String str = s.substring(0, len);
            int cnt = 1;
            StringBuilder sb = new StringBuilder();
            String tmp = "";

            for (int i = len; i < s.length(); i += len) {

                if (i + len > s.length()) {
                    tmp = s.substring(i);
                } else {
                    tmp = s.substring(i, i + len);
                }

                if (str.equals(tmp)) {
                    cnt++;
                } else {
                    if (cnt > 1) sb.append(cnt);
                    sb.append(str);
                    cnt = 1;
                    str = tmp;
                }
            }
            if (cnt > 1) {
                sb.append(cnt);
            }
            sb.append(str);
            System.out.println(sb.toString());
            answer = Math.min(sb.length(), answer);
        }
        System.out.println(answer);

    }
}
