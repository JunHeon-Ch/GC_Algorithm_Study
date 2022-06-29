package PS_2021.프로그래머스.level3.베스트앨범;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/42579#
 * 알고리즘: 해쉬 + 우선순위큐
 * 시간복잡도: O(nlogn), n=10,000(genres 배열의 길이)
 */

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genMap = new HashMap<>(); // <장르, 장르별 총 재생 횟수>
        Map<String, PriorityQueue<Music>> perGenMap = new HashMap<>(); // <장르, 재생 횟수가 우선순위인 우선순위큐>
        // O(nlogn), n=10,000(genres 배열의 길이)
        for(int i = 0; i < genres.length; i++) {
            // 장르
            if(genMap.containsKey(genres[i])) {
                genMap.put(genres[i], genMap.get(genres[i]) + plays[i]);
            } else {
                genMap.put(genres[i], plays[i]);
            }

            // 장르별 노래
            if(!perGenMap.containsKey(genres[i])) {
                perGenMap.put(genres[i], new PriorityQueue<>((o1, o2) -> {
                    if(o1.cnt == o2.cnt) return o1.idx - o2.idx;
                    return o2.cnt - o1.cnt;
                }));
            }
            perGenMap.get(genres[i]).add(new Music(plays[i], i));
        }

        // 장르 sorting
        // O(nlogn), n=100(장르 종류)
        List<Music> list = new ArrayList<>();
        for(String genre : genMap.keySet()) {
            list.add(new Music(genre, genMap.get(genre)));
        }
        Collections.sort(list, (o1, o2) -> o2.cnt - o1.cnt);

        List<Integer> ans = new ArrayList<>();
        for(Music music : list) {
            PriorityQueue<Music> q = perGenMap.get(music.genre);
            int cnt = 0; // 장르별 앨범에 들어갈 수 있는 노래는 최대 2개
            while(!q.isEmpty() && cnt < 2) {
                ans.add(q.poll().idx);
                cnt++;
            }
        }
        int[] answer = new int[ans.size()];
        int i = 0;
        for(int num : ans) {
            answer[i++] = num;
        }
        return answer;
    }
}

class Music {
    int cnt, idx;
    String genre;

    public Music(int cnt, int idx) {
        this.cnt = cnt;
        this.idx = idx;
    }

    public Music(String genre, int cnt) {
        this.genre = genre;
        this.cnt = cnt;
    }
}