package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no7795 {
    public static StringBuilder sb = new StringBuilder();
    public static int[] aList, bList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        while(test-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            aList = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
                aList[i] = Integer.parseInt(st.nextToken());

            bList = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++)
                bList[i] = Integer.parseInt(st.nextToken());


            //Arrays.sort(aList);
            Arrays.sort(bList);

            int cnt = 0;
            for(int i=0; i<n; i++){
                cnt += upperBound(0, bList.length, aList[i], bList);
            }
            sb.append(cnt);
            sb.append('\n');
        }
        System.out.print(sb);
    }
    public static int upperBound(int left, int right, int target, int[] bList){
        while(left < right){
            int mid = (left + right) / 2;

            if(target > bList[mid])
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }
}
