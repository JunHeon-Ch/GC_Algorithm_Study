package algo_1963;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static boolean[] prime = new boolean[10000];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        String first, second;
        prime[0]=true;
        prime[1]=true;

        aratos();

        for (int z = 0; z < t; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            first = st.nextToken();
            second = st.nextToken();
            go(first, second);
            bw.write(ans + "\n");
        }
        bw.close();


    }

    static void go(String a, String b) {
        ans = 0;
        visit = new boolean[10000];
        Queue<String> q = new LinkedList<>();
        q.add(a);
        visit[Integer.parseInt(a)] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String temp = q.remove();
                if (temp.equals(b)) {

                    return;
                }
                for (int i = 0; i < 4; i++) {
                    char[] arr = temp.toCharArray();
                    for (int j = 0; j < 10; j++) {
                        if (i == 0 && j == 0) continue;
                        if (arr[i] - '0' == j) continue;
                        arr[i] = (char) (j + '0');
                        String str = String.valueOf(arr);
                        if (prime[Integer.parseInt(str)]) continue;
                        if (visit[Integer.parseInt(str)]) continue;
                        q.add(str);
                        visit[Integer.parseInt(str)] = true;

                    }

                }
            }
            ans++;
        }
    }

    static void aratos() {
        for (int i = 2; i < 100; i++) {
            if (prime[i]) continue;

            for (int j = i; j * i < 10000; j++) {
                prime[j * i] = true;
            }
        }
    }

}
