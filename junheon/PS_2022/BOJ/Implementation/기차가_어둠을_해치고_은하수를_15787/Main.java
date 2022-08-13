package PS_2022.BOJ.Implementation.기차가_어둠을_해치고_은하수를_15787;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/15787
 * 알고리즘: 구현
 * 시간복잡도: O(n), n=100,000(기차의 수)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] train = new int[n + 1][21];

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(op == 1) {
                int idx = Integer.parseInt(st.nextToken());
                train[num][idx] = 1;
            } else if(op == 2) {
                int idx = Integer.parseInt(st.nextToken());
                train[num][idx] = 0;
            } else if(op == 3) {
                int prev = 0;
                for(int i = 1; i <= 20; i++) {
                    int tmp = train[num][i];
                    train[num][i] = prev;
                    prev = tmp;
                }
            } else if(op == 4) {
                int prev = 0;
                for(int i = 20; i >= 1; i--) {
                    int tmp = train[num][i];
                    train[num][i] = prev;
                    prev = tmp;
                }
            }
        }

        Set<String> set = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j <= 20; j++) {
                sb.append(train[i][j]);
            }
            set.add(sb.toString());
        }
        System.out.println(set.size());
    }
}
