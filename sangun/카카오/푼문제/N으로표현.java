package 푼문제;

public class N으로표현 {
    static int n;
    static int target;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        n = N;
        target = number;
        dfs(0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    static void dfs(int cnt, int value) {
        if (cnt > 8) {
            answer = -1;
            return;
        }
        if (value == target) {
            answer = Math.min(answer, cnt);
            return;
        }
        int tempN = n;
        for (int i = 0; i < 8 - cnt; i++) {
            int newCnt = cnt + i + 1;
            dfs(newCnt, value + tempN);
            dfs(newCnt, value / tempN);
            dfs(newCnt, value * tempN);
            dfs(newCnt, value - tempN);

            tempN = tempN * 10 + n;
        }

    }

}
