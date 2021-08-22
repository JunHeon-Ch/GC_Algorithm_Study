public class 징검다리건너기 {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        int answer = 0;
        int low = 0;
        int high = 200000000;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (valid(mid, stones, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            answer = Math.max(mid, answer);
        }

        System.out.println(answer);

    }

    static boolean valid(int mid, int[] stones, int k) {

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
