package 기초.시뮬레이션과구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no15662 {
    public static int n;
    public static boolean[] visit;
    public static int[][] gear;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        gear = new int[n+1][8];
        for(int i=1; i<=n; i++){
            String str = br.readLine();
            for(int j=0; j<8; j++){
                gear[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        int rotation = Integer.parseInt(br.readLine());
        for(int i=0; i<rotation; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            visit = new boolean[n+1];
            compute(direction, number);
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (gear[i][0] == 1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static void compute(int direction, int wheel_num){
        visit[wheel_num] = true;
        rotate(direction, wheel_num);

        if (wheel_num - 1 >= 1 && !visit[wheel_num-1] && gear[wheel_num - 1][2] != gear[wheel_num][6+direction]) {
            compute(direction * -1, wheel_num - 1);
        }
        if (wheel_num + 1 <= n && !visit[wheel_num + 1] && gear[wheel_num + 1][6] != gear[wheel_num][2+direction]) {
            compute(direction * -1, wheel_num + 1);
        }
    }
    public static void rotate(int direction, int wheel_num){
        if (direction == 1) { // cw
            int tmp = gear[wheel_num][7];
            for (int i = 7; i >= 1; i--) {
                gear[wheel_num][i] = gear[wheel_num][i-1];
            }
            gear[wheel_num][0] = tmp;
        }
        else{ // ccw
            int tmp = gear[wheel_num][0];
            for (int i = 0; i < 7; i++) {
                gear[wheel_num][i] = gear[wheel_num][i+1];
            }
            gear[wheel_num][7] = tmp;
        }
    }
}
