package 프로그래머스.lv2.순위검색;

import java.util.*;

class Solution {
    public Map<String, ArrayList<Integer>> information = new HashMap<>();
    public ArrayList<Integer> in;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for(int i=0; i<info.length; i++){
            dfs("", 0, info[i].split(" "));
        }

        List<String> list = new ArrayList<>(information.keySet());
        for(int i=0; i<list.size(); i++){
            List<Integer> scoreList = information.get(list.get(i));
            Collections.sort(scoreList);
        }

        for(int i=0; i<query.length; i++){
            query[i] = query[i].replaceAll(" and ", "");
            String[] str = query[i].split(" ");

            int score = Integer.parseInt(str[1]);
            answer[i] = search(str[0], score);
        }

        return answer;
    }
    public void dfs(String str, int depth, String[] info){
        if(depth == 4){
            if(!information.containsKey(str)){
                in = new ArrayList<>();
                in.add(Integer.parseInt(info[4]));
                information.put(str, in);
            }
            else{
                information.get(str).add(Integer.parseInt(info[4]));
            }

            return;
        }
        dfs(str+"-", depth+1, info);
        dfs(str+info[depth], depth+1, info);
    }

    public int search(String str, int score){
        if(!information.containsKey(str))
            return 0;

        List<Integer> scoreList = information.get(str);
        int start = 0, end = scoreList.size()-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(scoreList.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return scoreList.size() - start;
    }
}