package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등차수열변환 {
    static int ans = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        if (n==1){
            System.out.println(0);
            System.exit(0);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                go(0, 0, arr, arr[1] + dx[j] - arr[0] + dx[i]);
            }
        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }

    static void go(int index, int selected, int[] arr, int dif) {
        if (index == arr.length) {
            if (valid(arr)) {
                ans = Math.min(ans, selected);
            }
            return;
        }

        arr[index]++;
        if (index == 0||dif == arr[index] - arr[index - 1] ) {
            go(index + 1, selected + 1, arr, dif);
        }
        arr[index]--;
        if (index == 0||dif == arr[index] - arr[index - 1] ) {
            go(index + 1, selected, arr, dif);
        }
        arr[index]--;
        if (index == 0||dif == arr[index] - arr[index - 1] ) {
            go(index + 1, selected + 1, arr, dif);
        }
        arr[index]++;
    }

    static boolean valid(int[] arr) {
        int dif = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (dif != arr[i + 1] - arr[i]) return false;
        }
        return true;
    }
}
