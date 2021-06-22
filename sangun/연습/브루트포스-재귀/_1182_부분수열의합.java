import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1182_부분수열의합 {
    static int n, s;
    static int[] arr;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        go(0, 0);
        bw.write(ans + "\n");
        bw.close();

    }

    static void go(int index, int sum) {
        if (index == n) return;
        if (sum + arr[index] == s) ans++;

        go(index + 1, sum + arr[index]);
        go(index + 1, sum);

    }
}
