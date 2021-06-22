package algo_14395;
import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static HashSet<String> set = new HashSet<>();

    static class value {
        String val;
        StringBuilder sb = new StringBuilder();

        value(String val, String str) {
            this.val = val;
            this.sb.append(str);
        }
    }

    static long max = 1000000000L;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        String t = st.nextToken();

        if (s.equals(t)) {
            bw.write(0 + "\n");
            bw.close();
            System.exit(0);
        }

        bfs(s, t);
        bw.write(-1 + "\n");
        bw.close();


    }

    static void bfs(String s, String t) throws IOException {
        Queue<value> q = new LinkedList<>();
        q.add(new value(s, ""));
        set.add(s);
        while (!q.isEmpty()) {
            value k = q.remove();
            long temp = Long.parseLong(k.val);

            if (t.equals(k.val)) {
                if (k.sb.length() == 0) {
                    bw.write(0 + "\n");
                } else bw.write(k.sb.toString() + "\n");
                bw.close();
                System.exit(0);
            }

            long mul = temp * temp;
            if (mul>=0&&mul <= max && !set.contains(String.valueOf(mul))) {
                q.add(new value(String.valueOf(mul), k.sb.toString() + "*"));
                set.add(String.valueOf(mul));
            }

            long plus = temp + temp;
            if (plus <= max && !set.contains(String.valueOf(plus))) {
                q.add(new value(String.valueOf(plus), k.sb.toString() + "+"));
                set.add(String.valueOf(plus));
            }

            long minus = 0;
            if (!set.contains(String.valueOf(minus))) {
                q.add(new value(String.valueOf(minus), k.sb.toString() + "-"));
                set.add(String.valueOf(minus));
            }

            if (temp != 0) {
                long div = 1;
                if (!set.contains(String.valueOf(div))) {
                    q.add(new value(String.valueOf(div), k.sb.toString() + "/"));
                    set.add(String.valueOf(div));
                }
            }


        }

    }

}

