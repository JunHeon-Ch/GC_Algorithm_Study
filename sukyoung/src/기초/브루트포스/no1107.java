package 기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1107 {
    public static boolean[] brokenBtn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wantChannel = Integer.parseInt(br.readLine());
        int brokenBtnCnt = Integer.parseInt(br.readLine());

        brokenBtn = new boolean[10];
        if (brokenBtnCnt != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < brokenBtnCnt; i++) {
                int num = Integer.parseInt(st.nextToken());
                brokenBtn[num] = true;
            }
        }

        int count = Math.abs(wantChannel - 100);
        for(int i=0; i<=1000000; i++){
            int len = sol(i);

            if(len > 0){
                int cnt = Math.abs(i - wantChannel) + len;
                count = Math.min(cnt, count);
            }
        }

        System.out.println(count);
    }

    public static int sol(int n){
        int len = 0;
        if(n == 0) {
            if (brokenBtn[0])
                len = 0;
            else
                len = 1;
            return len;
        }
        while(n>0){
            if(brokenBtn[n%10]){
                len = 0;
                return len;
            }
            n /= 10;
            len++;
        }
        return len;
    }

}
