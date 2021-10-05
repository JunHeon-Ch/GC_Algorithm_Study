package 백준.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] aList = new long[n];
        long[] bList = new long[n];
        long[] cList = new long[n];
        long[] dList = new long[n];
        long[] abList = new long[n*n];
        long[] cdList = new long[n*n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            aList[i] = (Long.parseLong(st.nextToken()));
            bList[i] = (Long.parseLong(st.nextToken()));
            cList[i] = (Long.parseLong(st.nextToken()));
            dList[i] = (Long.parseLong(st.nextToken()));
        }

        int idx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                abList[idx++] = aList[i] + bList[j];
            }
        }
        idx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                cdList[idx++] = cList[i] + dList[j];
            }
        }
        Arrays.sort(abList);
        Arrays.sort(cdList);

        long cnt = 0;
        for(int i=0; i< abList.length; i++){
            cnt+= upperBound(0, cdList.length, -abList[i], cdList) - lowerBound(0, cdList.length, -abList[i], cdList);
        }
        System.out.println(cnt);
    }
    public static long upperBound(int left, int right, long target, long[] cdList){
        while(left < right){
            int mid = (left + right) / 2;

            if(target >= cdList[mid]){
                left  = mid + 1;
            }
            else
                right = mid;
        }
        return right;
    }
    public static long lowerBound(int left, int right, long target, long[] cdList){
        while(left < right){
            int mid = (left + right) / 2;

            if(target > cdList[mid])
                left = mid + 1;
            else
                right = mid;
        }
        return right;
    }
}
