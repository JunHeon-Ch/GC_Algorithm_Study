package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long min = 0, max = 0;
        long[] lanList = new long[k];
        for(int i=0; i<k; i++){
            lanList[i] = Long.parseLong(br.readLine());

            if(max < lanList[i])
                max = lanList[i];
        }

        max ++;
        while(min < max){
            long mid = (min + max) / 2;

            long cnt = 0;
            for(long lan : lanList){
                cnt += lan / mid;
            }

            if(cnt < n)
                max = mid;
            else
                min = mid + 1;
        }
        System.out.println(min-1);
    }
}
