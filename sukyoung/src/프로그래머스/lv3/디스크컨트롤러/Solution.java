package 프로그래머스.lv3.디스크컨트롤러;

import java.util.*;

class Solution {
    class Job{
        int requestTime;
        int workingTime;
        Job(int requestTime, int workingTime){
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;

        LinkedList<Job> waiting = new LinkedList<>();
        PriorityQueue<Job> queue = new PriorityQueue<>(new Comparator<Job>(){
            @Override
            public int compare(Job j1, Job j2){
                return j1.workingTime - j2.workingTime;
            }
        });

        for(int i=0; i<jobs.length; i++){
            waiting.offer(new Job(jobs[i][0], jobs[i][1]));
        }
        Collections.sort(waiting, new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return j1.requestTime - j2.requestTime;
            }
        });

        int cnt = 0;
        int time = waiting.peek().requestTime;
        while(cnt < jobs.length){
            while(!waiting.isEmpty() && waiting.peek().requestTime <= time){
                queue.offer(waiting.pollFirst());
            }
            if(!queue.isEmpty()) {
                Job job = queue.poll();
                time += job.workingTime;
                answer += time - job.requestTime;
                cnt++;
            } else {
                time++;
            }
        }
        return answer/cnt;
    }
}
