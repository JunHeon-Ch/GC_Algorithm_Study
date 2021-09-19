package 프로그래머스.lv3.베스트앨범;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        boolean[] visit = new boolean[plays.length];
        HashMap<String, ArrayList<Integer>> genre_list = new HashMap<String, ArrayList<Integer>>();
        HashMap<String, Integer> best_genre = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<genres.length; i++){
            if(genre_list.containsKey(genres[i])){
                ArrayList<Integer> list = genre_list.get(genres[i]);
                list.add(plays[i]);
                Collections.sort(list, Collections.reverseOrder());
                genre_list.put(genres[i], list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(plays[i]);
                genre_list.put(genres[i],list);
            }
        }
        for(int i=0; i<genres.length; i++){
            if(best_genre.containsKey(genres[i])){
                int cnt = best_genre.get(genres[i]) + plays[i];
                best_genre.put(genres[i], cnt);
            }
            else{
                best_genre.put(genres[i], plays[i]);
            }
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(best_genre.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        //System.out.println(genre_list);
        for(Map.Entry<String, Integer> entry : entryList){
            String genre = entry.getKey();
            for(int i=0; i<genre_list.get(genre).size(); i++){
                if(i == 2)
                    break;
                int play = genre_list.get(genre).get(i);
                for(int j=0; j<plays.length; j++){
                    if(plays[j] == play && !visit[j]){
                        ans.add(j);
                        visit[j] = true;
                    }
                }
            }
        }

        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}