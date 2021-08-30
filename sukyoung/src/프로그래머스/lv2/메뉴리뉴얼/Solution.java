package 프로그래머스.lv2.메뉴리뉴얼;

import java.util.*;

class Solution {
    public HashMap<String,Integer> permutation = new HashMap<>();
    public boolean[] visit;
    public String[] ans;

    public String[] solution(String[] orders, int[] course) {
        char[] menu = {};

        for(String menus: orders){
            for(int i=0; i<menus.length(); i++){
                menu = menus.toCharArray();
                Arrays.sort(menu);
            }

            for(int i=0; i<course.length; i++){
                visit = new boolean[menu.length];
                ans = new String[course[i]];

                //손님들 조합 다 저장함
                permute(menu, 0, 0, course[i]);
            }
        }
        ArrayList<String> combi = new ArrayList<>();
        //System.out.println(permutation);
        int max;
        for(int i=0; i<course.length; i++){
            max = 0;
            for(Map.Entry<String, Integer> elem : permutation.entrySet()){
                if(elem.getKey().length() == course[i] && elem.getValue() >= 2){
                    max = Math.max(max, elem.getValue());
                }
            }
            System.out.println(max);
            for(Map.Entry<String, Integer> elem : permutation.entrySet()){
                if(elem.getValue() == max && elem.getKey().length() == course[i]){
                    combi.add(elem.getKey());
                }
            }
        }

        String[] answer = new String[combi.size()];
        for(int i=0; i<combi.size(); i++){
            answer[i] = combi.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }
    public void permute(char[] menu, int start, int depth, int course){
        if(depth == course){
            String temp = "";
            for(String i: ans){
                temp += i;
            }

            if(permutation.containsKey(temp)){
                int cnt = permutation.get(temp) + 1;
                permutation.put(temp, cnt);
            }
            else{
                permutation.put(temp, 1);
            }

            return ;
        }

        for(int i=start; i<menu.length; i++){
            if(!visit[i]){
                visit[i] = true;
                ans[depth] = Character.toString(menu[i]);
                permute(menu, i, depth+1, course);
                visit[i] = false;
            }
        }
    }
}