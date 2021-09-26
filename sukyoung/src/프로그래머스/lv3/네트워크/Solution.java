package 프로그래머스.lv3.네트워크;

import java.util.*;

class Solution {
    public int cnt = 0;
    public boolean[] visit_computer;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit_computer = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visit_computer[i]){
                dfs(i, computers);
                answer++;
            }
        }

        return answer;
    }
    public void dfs(int i, int[][] computers){
        visit_computer[i] = true;

        for(int j=0; j<computers[i].length; j++){
            if(computers[i][j] == 1 && i != j && !visit_computer[j]){
                dfs(j, computers);
            }
        }
        return ;
    }
}