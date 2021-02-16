package algo_1806;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long m;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int sum = num[0];
        int left = 0, right = 0;
        while (left <= right && right < n) {
            if (sum >= m) { //sum 이 m 보다 크거나 같으면 left 인덱스의 값을 sum에서 빼주고 left를 1 증가
                int length = right - left + 1;
                min = Math.min(min, length);
            }

            //sum 이 m 보다 작으면 right를 1 증가시키고 sum에 추
            if (sum < m) {
                if (right + 1 >= n) break;
                sum += num[++right];
            } else {
                sum -= num[left++];
            }
        }

        if (min == Integer.MAX_VALUE) min = 0;
        bw.write(min + "\n");
        bw.close();
    }

}
