package 푼문제;

public class _1ㅂㅓㄴ {
    public static void main(String[] args) {
        int[] student = {0, 1, 0, 0};
        int k = 1;

        int answer = 0;


        int redCnt = 0;
        int left = 0;
        int right = 0;


        while (right < student.length) {
            if (student[right] == 1) {
                redCnt++;
            }
            right++;
            if (redCnt == k) {
                for (int i = right; i < student.length; i++) {
                    System.out.println(right + " " + i);
                    answer++;
                    if (student[i] == 1) {
                        break;
                    }
                }
            }
            if (student[left] == 1) {
                redCnt--;
            }

            left++;
        }

        System.out.println(answer);
    }
}
