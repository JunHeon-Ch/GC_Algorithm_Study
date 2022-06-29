package PS_2021.BOJ.분리집합.친구_네트워크_4195;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<String, String> parent;
    static Map<String, Integer> cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            init();
            int k = Integer.parseInt(br.readLine());
            while(k-- > 0) {
                st = new StringTokenizer(br.readLine());
                String from = st.nextToken();
                String to = st.nextToken();
                String p = union(from, to);
                bw.write(cnt.get(p) + "\n");
            }
        }
        bw.flush();
    }

    public static void init() {
        parent = new HashMap<>();
        cnt = new HashMap<>();
    }

    public static String find(String me) {
        if(!parent.containsKey(me)) return me;
        String p = find(parent.get(me));
        parent.put(me, p);
        return p;
    }

    public static String union(String from, String to) {
        String fromParent = find(from);
        String toParent = find(to);
        if(!fromParent.equals(toParent)) {
            parent.put(toParent, fromParent);
            int fromCnt = cnt.getOrDefault(fromParent, 1);
            int toCnt = cnt.getOrDefault(toParent, 1);
            cnt.put(fromParent, fromCnt + toCnt);
        }
        return fromParent;
    }
}
