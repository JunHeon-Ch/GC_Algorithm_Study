package algo_15662;
import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Character>[] arr;
    static int n;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        arr = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i].add(str.charAt(j));
            }
        }
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            num--;
            rotation(num, dir);
            visited = new boolean[n];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].get(0) == '1') {
                ans++;
            }
        }

        bw.write(ans + "\n");
        bw.close();

    }

    static void rotation(int num, int dir) {
        if (num >= n || num < 0) return;
        visited[num] = true;
        // 오른쪽
        if (num + 1 < n && !visited[num + 1]) {
            if (arr[num].get(2) != arr[num + 1].get(6)) {
                rotation(num + 1, -dir);
            }
        }
        // 왼쪽
        if (num - 1 >= 0 && !visited[num - 1]) {
            if (arr[num].get(6) != arr[num - 1].get(2)) {
                rotation(num - 1, -dir);
            }
        }
        if (dir == 1) { // 시계방향
            char temp = arr[num].getLast();
            arr[num].removeLast();
            arr[num].addFirst(temp);

        } else { // 반시계방향
            char temp = arr[num].poll();
            arr[num].add(temp);
        }
    }
}


