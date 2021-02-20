package algo_1208;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int[] num;
    static long ans = 0;
    static ArrayList<Integer> first = new ArrayList<>();
    static ArrayList<Integer> second = new ArrayList<>();

    // 그냥 선택 재귀를 사용하면 값이 너무 많아저 시간 초과가 나타난다. 따라서 2개로 나눠준 후에 값을 만들어가야한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        num = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }


        go(0, n / 2, 0, first);
        go(n / 2, n, 0, second);

        Collections.sort(first);
        Collections.sort(second);

        int front = 0;
        int rear = second.size() - 1;

        while (front < first.size() && rear >= 0) {
            int f = first.get(front);
            int r = second.get(rear);

            if (f + r == s) {
                long fcnt = 0;
                // f + r 에서 f와 같은 값이 있는 것을 모두 검출
                while (front < first.size() && first.get(front) == f) {
                    fcnt++;
                    front++;
                }
                long rcnt = 0;
                // f + r 에서 r과 같은 값이 있는 것을 모두 검출
                while (rear >= 0 && second.get(rear) == r) {
                    rcnt++;
                    rear--;
                }
                // 총 값을 곱합
                ans += rcnt * fcnt;
            }

            // 값이 크면 오른쪽 값을 줄여주며
            if (f + r > s) rear--;
            // 값이 작으면 왼쪽 값을 늘려준다
            if (f + r < s) front++;
        }

        if (s == 0) ans--;

        bw.write(ans + "\n");
        bw.close();

    }

    static void go(int selected, int end, int sum, ArrayList<Integer> arr) {
        if (selected >= end) {
            arr.add(sum);
            return;
        }

        go(selected + 1, end, sum, arr);
        go(selected + 1, end, sum + num[selected], arr);
    }
}

