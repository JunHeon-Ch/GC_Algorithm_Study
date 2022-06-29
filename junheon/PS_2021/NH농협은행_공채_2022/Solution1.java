package PS_2021.NH농협은행_공채_2022;

public class Solution1 {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                if (c == '0') sb.append(c);
                else sb.append((char) ('9' - (c - '0') + '0'));
            } else if (c >= 'a' && c <= 'z') {
                sb.append((char) ('z' - (c - 'a') + 'a'));
            } else if (c >= 'A' && c <= 'Z') {
                if(c == 'Z') sb.append('A');
                else sb.append((char) (c + 1));
            }
        }
        return sb.toString();
    }
}
