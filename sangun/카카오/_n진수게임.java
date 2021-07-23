public class _n진수게임 {
    public static void main(String[] args) {
        int n = 2; // 진법
        int t = 4; // 미리 구해야할 숫자 개수
        int m = 2; // 인원
        int p = 1; // 순서

        int size = t * m + p;

        int number = 0;
        StringBuilder result = new StringBuilder();

        int cnt = 1;
        result.append(0);
        while (result.length() < size) {
            result.append(convert(cnt, n));
            cnt++;
        }

        System.out.println(pick(result.toString(), m, p,t));

    }

    static String convert(int num, int n) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            if (num % n < 10) {
                sb.append(num % n);
            } else {
                sb.append((char) (num % n - 10 + 'A'));
            }
            num /= n;
        }
        return String.valueOf(sb.reverse());
    }

    static String pick(String str, int m, int p, int t) {
        String ans = "";
        for (int i = p - 1; i < str.length(); i += m) {
            ans += str.charAt(i);
            if (ans.length()==t){
                break;
            }
        }
        return ans;

    }
}
