package PS_2021.라인_공채_2021;

import java.util.*;

class Solution3 {
    public static int[] solution(int[][] jobs) {
        int len = jobs.length;
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.reqTime));
        for (int i = 0; i < len; i++) {
            pq.add(new Job(jobs[i][0], jobs[i][1], jobs[i][2], jobs[i][3]));
        }

        PriorityQueue<Job> jq = new PriorityQueue<>((o1, o2) -> {
            if (o1.prior == o2.prior) return o1.id - o2.id;
            return o2.prior - o1.prior;
        });
        int t = 0;
        Job now = null;
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty() || !jq.isEmpty()) {
            Map<Integer, Job> map = new HashMap<>();
            while(!jq.isEmpty()) {
                Job job = jq.poll();
                map.put(job.id, job);
            }
            while (!pq.isEmpty() && pq.peek().reqTime <= t) {
                Job job = pq.poll();
                if (map.containsKey(job.id)) {
                    Job prev = map.get(job.id);
                    map.put(job.id,
                            new Job(prev.reqTime, job.time + prev.time, prev.id, job.prior + prev.time));
                } else {
                    map.put(job.id, job);
                }
            }
            for (int id : map.keySet()) {
                jq.add(map.get(id));
            }

            if (!jq.isEmpty()) {
                Job job = null;
                if(now != null) {
                    for(Job queue : jq) {
                        if(now.id == queue.id) {
                            job = queue;
                        }
                    }
                    jq.remove(job);
                }
                if(job == null) {
                    job = jq.poll();
                }
                if (ans.size() == 0 || ans.get(ans.size() - 1) != job.id)
                    ans.add(job.id);
                t += job.time;
                now = job;
            } else {
                t++;
            }
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}

class Job {
    int reqTime, time, id, prior;

    public Job(int reqTime, int time, int id, int prior) {
        this.reqTime = reqTime;
        this.time = time;
        this.id = id;
        this.prior = prior;
    }
}