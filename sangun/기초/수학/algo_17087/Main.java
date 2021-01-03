package algo_17087;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        int mini = 1000000000;
        int index = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st2.nextToken());
            arr[i] = Math.abs(temp - s);
            if (mini > arr[i]) {
                mini = arr[i];
                index = i;
            }
        }
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            int temp = gcd(arr[index], arr[i]);
            if (min > temp) {
                min = temp;
            }

        }
        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }


    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
