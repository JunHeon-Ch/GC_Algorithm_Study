package 프로그래머스.lv3.여행경로;

import java.util.*;

class Solution {
    public ArrayList<String> list = new ArrayList<>();
    public boolean[] visit;
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];

        dfs("ICN", 0, "ICN", tickets);
        Collections.sort(list);
        String[] result = list.get(0).split(" ");

        return result;
    }
    public void dfs(String start, int depth, String str, String[][] tickets){
        if(depth == tickets.length){
            list.add(str);
            return;
        }
        for(int i = 0; i<tickets.length; i++){
            if(!visit[i] && tickets[i][0].equals(start)){
                visit[i] = true;
                dfs(tickets[i][1], depth+1, str+" "+tickets[i][1], tickets);
                visit[i] = false;
            }
        }
    }
}