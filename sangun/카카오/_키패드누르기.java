public class _키패드누르기 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        StringBuilder sb = new StringBuilder();
        int left = 10, right = 12;
        int l, r;
        for (int n : numbers) {
            l = 0;
            r = 0;
            if (n == 1 || n == 4 || n == 7) {
                sb.append("L");
                left = n;

            } else if (n == 3 || n == 6 || n == 9) {
                sb.append("R");
                right = n;

            } else {
                if (n == 0) n += 11;
                l = (Math.abs(n - left)) / 3 + (Math.abs(n - left)) % 3;
                r = (Math.abs(right - n)) / 3 + (Math.abs(right - n)) % 3;
                if (l == r) {
                    if (hand.equals("right")) {
                        sb.append("R");
                        right = n;
                    } else {
                        sb.append("L");
                        left = n;
                    }
                } else if (l > r) {
                    sb.append("R");
                    right = n;
                } else {
                    sb.append("L");
                    left = n;
                }
            }
        }
        System.out.println(sb.toString());
    }
}

