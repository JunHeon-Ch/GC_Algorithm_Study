import java.io.*;
import java.util.StringTokenizer;

public class _6603_로또 {
    static int[] ans = new int[6];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            go(arr, 0, 0, arr.length);
            bw.write("\n");

        }

        bw.close();
    }

    static void go(int[] arr, int index, int selected, int n) throws IOException {
        if (selected >= 6) {
            for (int i = 0; i < 6; i++) {
                bw.write(ans[i] + " ");
            }
            bw.write("\n");
            return;
        }
        if (index >= n) return;

        ans[selected] = arr[index];
        go(arr, index + 1, selected + 1, n);
        go(arr, index + 1, selected, n);
    }
}

