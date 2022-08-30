package PS_2022.BOJ.Binary_Search.IF문_좀_대신_써줘_19637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/19637
 * 알고리즘: 이분탐색
 * 시간복잡도: O(mlogn), m=100,000(캐릭터들의 개수), n=100,000(칭호의 개수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] name = new String[n];
        int[] power = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        while(m-- > 0) {
            int num = Integer.parseInt(br.readLine());
            int l = 0, r = n - 1;
            int max = 0;
            String ans = "";
            while(l <= r) {
                int mid = (l + r) / 2;
                if(num <= power[mid]) {
                    r = mid - 1;
                    max = Math.max(max, power[mid]);
                    ans = name[mid];
                } else l = mid + 1;
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb.toString());
    }
}
