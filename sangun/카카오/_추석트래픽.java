import java.util.ArrayList;

public class _추석트래픽 {
    public static void main(String[] args) {
        String[] lines = {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
        int answer = 0;
        double[] start = new double[lines.length];
        double[] finish = new double[lines.length];

        convert(lines, start, finish);

        for (int i = 0; i < lines.length; i++) {
            int cnt = 0;
            double s = start[i];
            double f = s + 1;

            for (int j = 0; j < lines.length; j++) {
                if (start[j] >= s && f > start[j]) {
                    cnt++;
                } else if (finish[j] >= s && f > finish[j]) {
                    cnt++;
                } else if (start[j] <= s && f <= finish[j]) {
                    cnt++;
                }
            }

            answer = Math.max(answer, cnt);
        }

        for (int i = 0; i < lines.length; i++) {
            int cnt = 0;
            double s = finish[i];
            double f = s + 1;

            for (int j = 0; j < lines.length; j++) {
                if (start[j] >= s && f > start[j]) {
                    cnt++;
                } else if (finish[j] >= s && f > finish[j]) {
                    cnt++;
                } else if (start[j] <= s && f <= finish[j]) {
                    cnt++;
                }
            }

            answer = Math.max(answer, cnt);
        }


        System.out.println(answer);

    }

    static void convert(String[] lines, double[] start, double[] finish) {
        for (int i = 0; i < lines.length; i++) {
            String[] s = lines[i].split(" ");
            String[] time = s[1].split(":");

            int hour = Integer.parseInt(time[0]) * 60 * 60;
            int min = Integer.parseInt(time[1]) * 60;
            double sec = Double.parseDouble(time[2]);
            double dif = Double.parseDouble(s[2].replace("s", ""));
            start[i] = hour + min + sec - dif + 0.001;
            finish[i] = hour + min + sec;
        }
    }
}
