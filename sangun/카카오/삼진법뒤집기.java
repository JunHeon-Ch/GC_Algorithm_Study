public class 삼진법뒤집기 {
    public static void main(String[] args) {
        int n = 45;

        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % 3);
            n = n / 3;
        }


        long tmp = Integer.parseInt(sb.toString());
        System.out.println(sb.toString());
        int cnt = 1;
        int answer = 0;
        while (tmp != 0) {
            int k = (int) (tmp % 10);
            answer += cnt * k;
            tmp = tmp / 10;
            cnt *= 3;
        }
        System.out.println(answer);


    }
}
