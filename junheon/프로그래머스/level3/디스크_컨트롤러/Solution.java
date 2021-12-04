package 프로그래머스.level3.디스크_컨트롤러;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/42627#
 * 알고리즘: 힙
 최소 average response time을 구하는 문제
 -> SJF를 사용함
 - 디스크가 작업을 수행하고 있는 경우 소요시간이 짧은 job부터 처리
 - 디스크가 작업을 수행하고 있지 않은 경우 소요시간에 관계없이 먼저 들어온 job부터 처리
 */
class Solution {
    public int solution(int[][] jobs) {
        // job queue: 모든 job들이 들어가 있는 queue
        // 시작 시간이 짧은 순서로 정렬
        // 시작 시간이 같을 경우 먼저 들어온 job의 우선순위가 높음
        PriorityQueue<Job> jobQ = new PriorityQueue<>((o1, o2) -> {
            if(o1.start == o2.start) return o1.idx - o2.idx;
            return o1.start - o2.start;
        });
        int idx = 0;
        for(int[] job : jobs) {
            jobQ.add(new Job(idx++, job[0], job[1]));
        }

        // ct -> current time
        // rt -> total response time
        int ct = 0;
        int rt = 0;
        // job queue에 어떠한 job이 남지 않을 때까지 수행한다.
        while(!jobQ.isEmpty()) {
            // ready queue: 디스크가 작업을 수행하고 있는 경우 소요시간이 짧은 job을 찾아내기 위한 힙 데이터
            // 소요시간(dur)순으로 정렬
            PriorityQueue<Job> readyQ = new PriorityQueue<>((o1, o2) -> {
                return o1.dur - o2.dur;
            });
            // 현재 시간(ct)보다 짧은 시작 시간(start)을 가지고 있는 job을 job queue에서 꺼내 ready queue에 추가
            while(!jobQ.isEmpty() && jobQ.peek().start <= ct) {
                readyQ.add(jobQ.poll());
            }
            Job job;
            // ready queue에 데이터가 없는 경우 -> 현재 시간보다 짧은 시작 시간을 가지는 job이 없다
            // -> 디스크가 현재 수행할 job이 없다 -> 소요시간에 관계없이 먼저 들어온 job부터 처리해야 한다
            // -> job queue에 있는 job 중 시작 시간이 가장 짧은 job의 시작 시간으로 현재 시간을 바꾼다
            if(!readyQ.isEmpty()) {
                job = readyQ.poll();
                ct += job.dur;
                rt += ct - job.start;
            } else {
                ct = jobQ.peek().start;
                continue;
            }
            // System.out.println(ct);
            // System.out.println(job.start + " " + job.dur);
            while(!readyQ.isEmpty()) {
                jobQ.add(readyQ.poll());
            }
        }
        return rt / jobs.length;
    }
}

class Job {
    int start, dur, idx;

    public Job(int idx, int start, int dur) {
        this.idx = idx;
        this.start = start;
        this.dur = dur;
    }
}