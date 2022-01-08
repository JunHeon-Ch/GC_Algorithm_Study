package 프로그래머스.lv3.베스트앨범;

import java.util.*;

class Solution2 {
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> genre_map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            if(genre_map.containsKey(genres[i])){
                int cnt = genre_map.get(genres[i]) + plays[i];
                genre_map.put(genres[i], cnt);
            }
            else{
                genre_map.put(genres[i], plays[i]);
            }
        }

        ArrayList<String> genre_list = new ArrayList<>();
        for(String key: genre_map.keySet())
            genre_list.add(key);
        Collections.sort(genre_list, (o1, o2) -> genre_map.get(o2) - genre_map.get(o1));

        ArrayList<music> music_list = new ArrayList<>();
        for(int i=0; i<genre_list.size(); i++){
            ArrayList<music> list = new ArrayList<>();
            for(int j=0; j<genres.length; j++){
                if(genres[j].equals(genre_list.get(i))){
                    list.add(new music(genre_list.get(i), plays[j], j));
                }
            }
            Collections.sort(list, (o1, o2) -> o2.play_cnt - o1.play_cnt);
            music_list.add(list.get(0));
            if(list.size()!=1){
                music_list.add(list.get(1));
            }
        }

        int[] answer = new int[music_list.size()];
        for(int i=0; i<music_list.size(); i++){
            answer[i] = music_list.get(i).idx;
        }
        return answer;
    }
}
class music {
    String genre;
    int play_cnt;
    int idx;

    public music (String genre, int play_cnt, int idx){
        this.genre = genre;
        this.play_cnt = play_cnt;
        this.idx = idx;
    }
}
