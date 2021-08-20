public class 징검다리건너기 {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;


//        int min = Integer.MAX_VALUE;
//        int max = 0;
//        for (int i = 0; i < k; i++) {
//            max = Math.max(max, stones[i]);
//        }
//        min = Math.min(max, min);
//        for (int i = 0; i < stones.length; i++) {
//            max = 0;
//            for (int j = i + 1; j <= i + k; j++) {
//                if (i + k >= stones.length) {
//                    max = Integer.MAX_VALUE;
//                    continue;
//                }
//                max = Math.max(max, stones[j]);
//            }
//            min = Math.min(max, min);
//        }
//        System.out.println(min);

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
