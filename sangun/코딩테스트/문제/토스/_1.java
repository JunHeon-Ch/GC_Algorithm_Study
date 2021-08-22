package 토스;

public class _1 {

    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        int low = 0;
        int high = 200000000;
        int mid = 0;
        int answer = 0;

        while (low <= high) {
            mid = (high + low) / 2;

            if (valid(stones, mid, k)) {
                low = mid + 1;
                answer = Math.max(mid, answer);
            } else {
                high = mid - 1;
            }

        }

        System.out.println(answer);

    }

    static boolean valid(int[] stones, int mid, int k) {
        int cnt = 0;
        for (int stone : stones) {
            if (stone - mid < 0) {
                cnt++;
            } else {
                cnt = 0;
            }

            if (cnt == k) {
                return false;
            }

        }
        return true;
    }
}
