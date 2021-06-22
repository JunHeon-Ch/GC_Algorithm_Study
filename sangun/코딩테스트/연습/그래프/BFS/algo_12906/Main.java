package algo_12906;

import java.io.*;
import java.util.*;

public class Main {
    // 왜 안되는지 모르겠음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        char[] achar = st.nextToken().toCharArray();
        ArrayList<Character> a1 = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            a1.add(achar[i]);
        }
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        char[] bchar;
        if (b == 0) bchar = new char[0];
        else bchar = st.nextToken().toCharArray();
        ArrayList<Character> b1 = new ArrayList<>();
        for (int i = 0; i < b; i++) {
            b1.add(bchar[i]);
        }
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        char[] cchar;
        if (c == 0) cchar = new char[0];
        else cchar = st.nextToken().toCharArray();
        ArrayList<Character> c1 = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            c1.add(cchar[i]);
        }

        bw.write(bfs(a1, b1, c1) + "\n");
        bw.close();

    }

    static int bfs(ArrayList<Character> a, ArrayList<Character> b, ArrayList<Character> c) {
        Queue<ArrayList<Character>> q = new LinkedList<>();

        q.add(a);
        q.add(b);
        q.add(c);
        HashSet<String> set = new HashSet<>();
        String temp = a.toString() + " " + b.toString() + " " + c.toString();
        set.add(temp);

        while (!q.isEmpty()) {
            ArrayList<Character> sa = q.remove();
            ArrayList<Character> sb = q.remove();
            ArrayList<Character> sc = q.remove();



            boolean[] ok = new boolean[3];
            Arrays.fill(ok, true);
            for (int i = 0; i < sa.size(); i++) {
                if (sa.get(i) != 'A') {
                    ok[0] = false;
                    break;
                }
            }
            for (int i = 0; i < sb.size(); i++) {
                if (sb.get(i) != 'B') {
                    ok[1] = false;
                    break;
                }
            }
            for (int i = 0; i < sc.size(); i++) {
                if (sc.get(i) != 'C') {
                    ok[2] = false;
                    break;
                }
            }
            q.add(sc);
            q.add(sb);
            q.add(sa);

            if (ok[0] && ok[1] && ok[2]) {
            }
            if (sa.size() != 0) {
                char tempa = sa.get(sa.size() - 1);
                sa.remove(sa.size() - 1);
                sb.add(tempa);
                temp = sa.toString() + " " + sb.toString() + " " + sc.toString();
                if (!set.contains(temp)) {
                    q.add(sa);
                    q.add(sb);
                    q.add(sc);
                    set.add(temp);
                }
                sb.remove(sb.size() - 1);
                sc.add(tempa);
                temp = sa.toString() + " " + sb.toString() + " " + sc.toString();
                if (!set.contains(temp)) {
                    q.add(sa);
                    q.add(sb);
                    q.add(sc);
                    set.add(temp);
                }
                sc.remove(sc.size() - 1);
                sa.add(tempa);
                System.out.println(temp);
            }
            if (sb.size() != 0) {
                char tempb = sb.get(sb.size() - 1);
                sb.remove(sb.size() - 1);
                sa.add(tempb);
                temp = sa.toString() + " " + sb.toString() + " " + sc.toString();
                if (!set.contains(temp)) {
                    q.add(sa);
                    q.add(sb);
                    q.add(sc);
                    set.add(temp);
                }
                sa.remove(sa.size() - 1);
                sc.add(tempb);
                temp = sa.toString() + " " + sb.toString() + " " + sc.toString();
                if (!set.contains(temp)) {
                    q.add(sa);
                    q.add(sb);
                    q.add(sc);
                    set.add(temp);
                }
                sc.remove(sc.size() - 1);
                sb.add(tempb);
                System.out.println(temp);
            }
            if (sc.size() != 0) {
                char tempc = sc.get(sc.size() - 1);
                sc.remove(sc.size() - 1);
                sa.add(tempc);
                temp = sa.toString() + " " + sb.toString() + " " + sc.toString();
                if (!set.contains(temp)) {
                    q.add(sa);
                    q.add(sb);
                    q.add(sc);
                    set.add(temp);
                }
                sa.remove(sa.size() - 1);
                sb.add(tempc);
                temp = sa.toString() + " " + sb.toString() + " " + sc.toString();
                if (!set.contains(temp)) {
                    q.add(sa);
                    q.add(sb);
                    q.add(sc);
                    set.add(temp);
                }
                sb.remove(sb.size() - 1);
                sc.add(tempc);
                System.out.println(temp);
            }


        }


        return -1;
    }
}

