package PS_2022.BOJ._07_Two_Pointer.두_용액_2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/2470
 * 알고리즘: 투포인터
 * 시간복잡도: O(nlogn), n=100,000(전체 용액의 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int l = 0, r = n - 1;
        int res = Integer.MAX_VALUE;
        int min = 0, max = 0;
        while(l < r) {
            int val = num[l] + num[r];
            if(Math.abs(val) < res) {
                res = Math.abs(val);
                min = num[l];
                max = num[r];
            }
            if(val <= 0) l++;
            else r--;
        }
        System.out.println(min + " " + max);
    }
}
