package 푼문제;

import java.util.*;

public class 배스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {

            if (map.containsKey(genres[i])) {
                int value = map.get(genres[i]) + plays[i];
                map.put(genres[i], value);
            } else {
                map.put(genres[i], plays[i]);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < genres.length; i++) {
            pq.add(new Pair(i, genres[i], plays[i], map.get(genres[i])));
        }
        Map<String, Integer> cnt = new HashMap<>();

        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            if (cnt.containsKey(p.genre)) {
                if (cnt.get(p.genre) == 2) continue;
                cnt.put(p.genre, cnt.get(p.genre) + 1);
            } else {
                cnt.put(p.genre, 1);
            }

            ans.add(p.index);

        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        System.out.println(Arrays.toString(answer));

    }

    static class Pair implements Comparable<Pair> {
        int index;
        String genre;
        int play;
        int rank;

        public Pair(int index, String genre, int play, int rank) {
            this.index = index;
            this.genre = genre;
            this.play = play;
            this.rank = rank;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.rank == this.rank) {
                if (o.play == this.play) {
                    return this.index - o.index;
                }
                return o.play - this.play;
            }
            return o.rank - this.rank;
        }
    }
}
