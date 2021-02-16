package algo_1644;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[n + 1];

        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) continue;

            for (int j = i; i * j <= n; j++) {
                prime[j * i] = true;
            }
        }
        ArrayList<Integer> num = new ArrayList<>();
        int cnt = 0;
        for (boolean k : prime) {
            if (!k) num.add(cnt);
            cnt++;
        }
        if (n==1){
            bw.write(0+"\n");
            bw.close();
            System.exit(0);
        }

        int right = 0;
        int left = 0;
        int sum = num.get(0);
        int ans = 0;
        while (left <= right) {
            if (sum == n) { //sum 이 m 보다 크거나 같으면 left 인덱스의 값을 sum에서 빼주고 left를 1 증가
                ans++;
            }
            //sum 이 m 보다 작으면 right를 1 증가시키고 sum에 추
            if (sum < n) {
                if (right + 1 >= num.size()) break;
                sum += num.get(++right);
            } else {
                sum -= num.get(left++);
            }
        }
        bw.write(ans + "\n");
        bw.close();
    }
}
