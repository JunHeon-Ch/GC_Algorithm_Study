package 프로그래머스.level3.추석_트래픽;

import java.util.*;

class Solution {
    public int solution(String[] lines) {
        List<Time> list = new ArrayList<>();
        for(String line : lines) {
            line = line.replace("2016-09-15 ", "");
            StringTokenizer st = new StringTokenizer(line);
            String time = st.nextToken();
            int dur = (int) (Double.parseDouble(st.nextToken().replace("s", "")) * 1000) - 1;
            st = new StringTokenizer(time, ":");
            int endTime = (int) ((Double.parseDouble(st.nextToken()) * 3600
                    + Double.parseDouble(st.nextToken()) * 60
                    + Double.parseDouble(st.nextToken())) * 1000);
            endTime = endTime >= 24*3600*1000 ? 24*3600*1000-1 : endTime;
            int startTime = endTime-dur < 0 ? 0 : endTime-dur;
            list.add(new Time(startTime, endTime));
        }

        int ans = 0;
        for(Time now : list) {
            int start = now.st;
            int end = start + 999;
            int res = 0;
            for(Time other : list) {
                if(other.st <= end && other.et >= start) res++;
            }
            ans = Math.max(ans, res);

            start = now.et;
            end = start + 999;
            res = 0;
            for(Time other : list) {
                if(other.st <= end && other.et >= start) res++;
            }
            ans = Math.max(ans, res);
        }

        return ans;
    }
}

class Time {
    int st, et;

    public Time(int st, int et) {
        this.st = st;
        this.et = et;
    }
}