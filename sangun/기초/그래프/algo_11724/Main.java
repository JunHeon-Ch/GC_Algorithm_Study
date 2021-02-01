package algo_11724;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] valid;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] num = new ArrayList[n + 1];
        valid = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            num[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            num[a].add(b);
            num[b].add(a);
        }
        int ans = 0; // 연결요소
        int check = 0; // 연결요소들의 점이 다 들어갔는지 확인
        for (int i = 1; i <= n; i++) {
            dfs(i, num);
            if (cnt != 1) { // 연결요소가 자기 자신만이 아니면
                ans++; // 연결요소 추가
                check += cnt; // 연결된 점들 모두 더함
            }
            cnt = 0;
        }
        if (check != n) { // 결과에 연결된 점들이 다 포함안되어있으면
            ans += n - check; //전체 점들에서 여태 점들을 다 빼고 합해주기
        }
        bw.write(ans + "\n");
        bw.close();
    }

    static void dfs(int start, ArrayList<Integer>[] arr) {
        valid[start] = true;
        cnt++;
        for (int i = 0; i < arr[start].size(); i++) {
            if (!valid[arr[start].get(i)]) {
                dfs(arr[start].get(i), arr);
            }
        }
    }
}
