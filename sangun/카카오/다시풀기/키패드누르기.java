package 다시풀기;

public class 키패드누르기 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        int l = 10;
        int r = 12;
        String answer = "";
        for (int n : numbers) {
            if (n == 0) n = 11;
            if (n == 1 || n == 4 || n == 7) {
                answer += "L";
                l = n;
            } else if (n == 3 || n == 6 || n == 9) {
                answer += "R";
                r = n;
            } else {
                int rdif = Math.abs(r - n) / 3 + Math.abs(r - n) % 3;
                int ldif = Math.abs(l - n) / 3 + Math.abs(l - n) % 3;

                if (ldif == rdif) {
                    if (hand.equals("right")) {
                        answer += "R";
                        r = n;
                    } else {
                        answer += "L";
                        l = n;
                    }
                } else if (ldif < rdif) {
                    answer += "L";
                    l = n;
                } else {
                    answer += "R";
                    r = n;
                }
            }
        }
        System.out.println(answer);
    }
}
