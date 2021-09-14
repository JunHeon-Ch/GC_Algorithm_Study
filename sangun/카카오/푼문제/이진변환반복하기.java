package 푼문제;

public class 이진변환반복하기 {
    public static void main(String[] args) {
        String s = "110010101001";


        int zeroCnt = 0;
        int cnt = 0;

        int[] answer = new int[2];
        while (!s.equals("1")) {
            int len = s.length();
            s = s.replace("0", "");
            zeroCnt += len - s.length();
            s = Integer.toBinaryString(s.length());
            System.out.println(s);
            cnt++;
        }
        answer[0] = cnt;
        answer[1] = zeroCnt;
        System.out.println(zeroCnt + " " + cnt);
    }
}
