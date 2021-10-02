package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class no1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        ArrayList<Integer> rest = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            rest.add(Integer.parseInt(st.nextToken()));
        rest.add(0);
        rest.add(l);
        Collections.sort(rest);

        int low = 0, high = l;
        while(low <= high){
            int mid = (low + high) / 2;

            int cnt = 0;
            for(int i=1; i<rest.size(); i++){
                cnt += (rest.get(i) - rest.get(i-1) - 1) / mid;
            }

            if(cnt > m)
                low = mid + 1;
            else
                high = mid - 1;
        }
        System.out.println(low);
    }
}
