package PS_2022.BOJ.Two_Pointer.배열_합치기_11728;

import java.io.*;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/11728
 * 알고리즘: 투포인터
 * 시간복잡도: O(n+m), n,m=1,000,000(배열 크기)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[n + m];
        int i1 = 0, i2 = 0, i = 0;
        while(i1 < n && i2 < m) {
            if(arr1[i1] < arr2[i2]) ans[i++] = arr1[i1++];
            else ans[i++] = arr2[i2++];
        }
        while(i1 < n) ans[i++] = arr1[i1++];
        while(i2 < m) ans[i++] = arr2[i2++];

        for(i = 0; i < ans.length; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
