package PS_2021.데브매칭_실리콘밸리_2021.Problem2;

import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] names, int[][] homes, double[] grades) {
        int[] g = new int[grades.length];
        PriorityQueue<Rank> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.grade > o2.grade) return -1;
            else if(o1.grade < o2.grade) return 1;

            if(o1.dist > o2.dist) return -1;
            else if(o1.dist < o2.dist) return 1;

            return o1.name.compareTo(o2.name);
        });
        for(int i = 0; i < grades.length; i++) {
            pq.add(new Rank(names[i], homes[i][0], homes[i][1], (int) grades[i], i));
        }

        int[] answer = new int[pq.size()];
        int r = 1;
        while(!pq.isEmpty()) {
            Rank rank = pq.poll();
            answer[rank.index] = r++;
        }
        return answer;
    }
}

class Rank {
    String name;
    double dist;
    int grade;
    int index;

    public Rank(String name, int x, int y, int grade, int index) {
        this.name = name;
        dist = Math.sqrt(x * x + y * y);
        this.grade = grade;
        this.index = index;
    }
}