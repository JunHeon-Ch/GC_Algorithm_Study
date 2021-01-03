package algo_1158;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        bw.write("<");
        int index = k - 1;

        while (!list.isEmpty()) {
            if (index >= list.size()) {
                index = index - list.size();
            } else {
                if (list.size() == 1) {
                    bw.write(list.get(index) + ">");
                    list.remove(index);
                    index += k - 1;
                } else {
                    bw.write(list.get(index) + ", ");
                    list.remove(index);
                    index += k - 1;
                }
            }
        }
        bw.flush();
        bw.close();

    }
}
