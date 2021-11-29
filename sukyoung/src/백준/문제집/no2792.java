package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int children = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());

        int left = 1, right = 0;
        int[] jewelrys = new int[j];
        for(int i=0; i<j; i++){
            jewelrys[i] = Integer.parseInt(br.readLine());

            if(right < jewelrys[i])
                right = jewelrys[i];
        }

        int min = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;

            int cnt = 0;
            for(int jewelry : jewelrys){
                    cnt += jewelry / mid;
                    if((jewelry % mid) != 0)
                        cnt++;
            }

            if(cnt > children){
                left = mid + 1;
            }else{
                right = mid - 1;
                min = mid;
            }
        }

        System.out.print(min);
    }
}
