package 프로그래머스.lv3.광고삽입;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {

        int play = getSecond(play_time);
        long[] ad = new long[play + 1];

        for(String log : logs) {
            String[] times = log.split("-");

            int start = getSecond(times[0]);
            int end = getSecond(times[1]);

            ad[start]++;
            ad[end]--;
        }

        for(int i = 1; i <= play; i++)
            ad[i] += ad[i - 1];

        for(int i = 1; i <= play; i++)
            ad[i] += ad[i - 1];

        int adv = getSecond(adv_time);
        long max = ad[adv - 1];
        int answer = 0;
        for (int i = 0; i + adv <= play; i++) {
            long tmp = ad[i + adv] - ad[i];

            if (tmp > max) {
                max = tmp;
                answer = i + 1;
            }
        }
        return String.format("%02d:%02d:%02d", answer / 3600, (answer % 3600) / 60, (answer % 3600) % 60);
    }

    public int getSecond(String s) {
        return Integer.parseInt(s.split(":")[0]) * 3600
                + Integer.parseInt(s.split(":")[1]) * 60
                + Integer.parseInt(s.split(":")[2]);
    }

}