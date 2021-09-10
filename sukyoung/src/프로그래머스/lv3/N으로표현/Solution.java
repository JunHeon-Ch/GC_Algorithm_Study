package 프로그래머스.lv3.N으로표현;

class Solution {
    int n, target;
    int answer = Integer.MAX_VALUE;

    public int solution(int N, int number) {

        n = N;
        target = number;
        dfs(0,0);

        if(answer == Integer.MAX_VALUE)
            answer = -1;

        return answer;
    }
    public void dfs(int depth, int prev){
        if(depth > 8){
            answer = -1;
            return;
        }
        if(prev == target){
            answer = Math.min(answer, depth);
        }

        int tempN = n;
        for (int i = 0; i < 8 - depth; i++) {
            int newCount = depth + i + 1;
            dfs(newCount, prev + tempN);
            dfs(newCount, prev - tempN);
            dfs(newCount, prev / tempN);
            dfs(newCount, prev * tempN);

            tempN = tempN * 10 + n;
        }
    }
}
