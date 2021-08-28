package 프로그래머스.lv1.소수만들기;
import java.util.*;

class Solution {
    public int cnt = 0;
    public int[] ans = new int[3];
    public boolean[] visit;
    public int solution(int[] nums) {
        visit = new boolean[nums.length];
        dfs(0, 0, nums);
        return cnt;
    }
    public void dfs(int depth, int start, int[] nums){
        if(depth == 3){
            int sum = 0;
            for(int i=0; i<ans.length; i++){
                sum += ans[i];
            }
            if(check(sum)){
                cnt++;
            }

            return;
        }

        for(int i=start; i<nums.length; i++){
            if(!visit[i]){
                visit[i] = true;
                ans[depth] = nums[i];
                dfs(depth + 1, i, nums);
                visit[i] = false;
            }
        }
    }
    public boolean check(int number){
        if(number < 2) {
            return false;
        }

        if(number == 2) {
            return true;
        }


        for(int i = 2; i < number; i++) {

            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}