package 프로그래머스.lv3.추석트래픽;

class Solution {
    public int[] start_time, end_time;
    public int solution(String[] lines) {
        int answer = 0;
        start_time = new int[lines.length];
        end_time = new int[lines.length];
        get_times(lines);

        for(int i=0; i<lines.length; i++){
            int cnt = 0;
            int startOfSection = start_time[i];
            int endOfSection = start_time[i] + 1000;

            for(int j=0; j<lines.length; j++){
                if(start_time[j] >= startOfSection && start_time[j] < endOfSection)
                    cnt++;
                else if(end_time[j] >= startOfSection && end_time[j] < endOfSection)
                    cnt++;
                else if(start_time[j] <= startOfSection && end_time[j] >= endOfSection)
                    cnt++;
            }
            answer = cnt > answer ? cnt : answer;
        }

        for(int i=0; i<lines.length; i++){
            int cnt = 0;
            int startOfSection = end_time[i];
            int endOfSection = startOfSection + 1000;

            for(int j = 0 ; j < lines.length ; ++j) {
                if(start_time[j] >= startOfSection && start_time[j] < endOfSection)
                    cnt++;
                else if(end_time[j] >= startOfSection && end_time[j] < endOfSection)
                    cnt++;
                else if(start_time[j] <= startOfSection && end_time[j] >= endOfSection)
                    cnt++;
            }

            answer = cnt > answer ? cnt : answer;
        }

        return answer;
    }
    public void get_times(String[] lines){
        for(int i=0; i<lines.length; i++){
            String[] log = lines[i].split(" ");
            String[] times = log[1].split(":");

            int processingTime = (int)(Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);
            int startTime = 0, endTime = 0;

            endTime += Integer.parseInt(times[0]) * 60 * 60 * 1000;
            endTime += Integer.parseInt(times[1]) * 60 * 1000;
            endTime += (int)(Double.parseDouble(times[2]) * 1000);
            startTime = endTime - processingTime + 1;

            start_time[i] = startTime;
            end_time[i] = endTime;
        }
    }
}