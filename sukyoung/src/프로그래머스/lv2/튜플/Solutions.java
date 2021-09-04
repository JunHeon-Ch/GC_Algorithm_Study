package 프로그래머스.lv2.튜플;

import java.util.*;

class Solutions {
    public int[] solution(String s) {

        s = s.substring(1, s.length()-1);
        String[] sets = s.split(",|\\{|\\}");

        HashMap<String, Integer> list = new HashMap<>();
        for(String s1: sets){
            if(s1.equals(""))
                continue;
            if(list.containsKey(s1)){
                int cnt = list.get(s1) + 1;
                list.put(s1, cnt);
            }
            else
                list.put(s1, 1);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(list.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int[] answer = new int[list.size()];
        int i=0;
        for(Map.Entry<String, Integer> entry : entryList){
            answer[i] = Integer.valueOf(entry.getKey());
            i++;
        }

        return answer;
    }
}
