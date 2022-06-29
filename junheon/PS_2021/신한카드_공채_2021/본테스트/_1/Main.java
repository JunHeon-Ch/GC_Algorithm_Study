package PS_2021.신한카드_공채_2021.본테스트._1;

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num == -1) break;
            ans += num;
        }
        System.out.println(ans);
        br.close();
    }
}