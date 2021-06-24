package 프로그래머스.카카오.level2.N진수_게임;

class Solution {

    public String baseTransform(int n, int b) {
        if(b == 0) return "0";
        String num = new String();
        while(b != 0) {
            int m = b % n;
            if(m >= 10) num += (char)(m - 10 + 'A');
            else num += Integer.toString(b % n);
            b /= n;
        }
        StringBuffer sb = new StringBuffer(num);
        num = sb.reverse().toString();
        return num;
    }

    public String solution(int n, int t, int m, int p) {
        String answer = new String();
        int b = 0, k = 0;
        String str = new String();
        while(answer.length() < t) {
            str += baseTransform(n, b++);
            int i = m * k + p - 1;
            if(i < str.length()) {
                answer += str.charAt(i);
                k++;
            }
        }
        System.out.println(str);
        return answer;
    }
}