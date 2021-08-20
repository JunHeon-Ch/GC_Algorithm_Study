package 토스;

public class _6 {
    static long ans = 0;
    static long[] dp;

    public static void main(String[] args) {

        int numOfStairs = 70;

        dp = new long[71];
        dp[0]=1;
        System.out.println(go(numOfStairs));


    }

    static long go(int index) {
        if (index <= 0) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }
        if (index == 2) {
            return 2;
        }
        if (index == 3) {
            return 4;
        }
        if (dp[index]!=0){
            return dp[index];
        }

        return dp[index] = go(index - 1) + go(index - 2) + go(index - 3);

    }
}
