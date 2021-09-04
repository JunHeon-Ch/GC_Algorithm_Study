import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};

        int answer = 0;
        long left = 0;
        long right = 1000000000;
        Arrays.sort(times);
        while (left <= right) {
            long mid = (left + right) / 2;
            long total = 0;
            for (int i = 0; i < times.length; i++) {
                total += mid / times[i];
            }
            if (total >= n) {
                right = mid - 1;
                answer = (int) mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
