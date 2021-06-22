package algo_17140;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    static int r, c, k;
    static int[][] A = new int[100][100];

    static class Pair implements Comparable<Pair> {
        int index, cnt;

        Pair(int index, int cnt) {
            this.index = index;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair that) {
            if (this.index < that.index) {
                return -1;
            } else if (this.index == that.index) {
                if (this.cnt < that.cnt) {
                    return -1;
                } else if (this.cnt == that.cnt) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        int n = 3, m = 3;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (A[r][c]==k){
            System.out.println(0);
            System.exit(0);
        }

        for (int t = 1; t <= 100; t++) {
            if (n >= m) {
                int mm = m;
                for (int i = 0; i < n; i++) {
                    HashMap<Integer, Integer> map = new HashMap<>();
                    for (int j = 0; j < mm; j++) {
                        if (A[i][j] == 0) continue;
                        int val = 0;
                        if (map.containsKey(A[i][j])) {
                            val = map.get(A[i][j]);
                        }
                        val++;
                        map.put(A[i][j], val);
                    }
                    ArrayList<Pair> arr = new ArrayList<>();
                    for (Entry<Integer, Integer> e : map.entrySet()) {
                        arr.add(new Pair(e.getValue(), e.getKey()));
                    }
                    Collections.sort(arr);
                    int size = Math.min(arr.size(), 50);
                    for (int j = 0; j < size; j++) {
                        A[i][j * 2] = arr.get(j).cnt;
                        A[i][j * 2 + 1] = arr.get(j).index;
                    }
                    for (int j = size * 2; j < 100; j++) {
                        A[i][j] = 0;
                    }
                    if (mm < arr.size() * 2) {
                        mm = arr.size() * 2;
                    }
                }
                m = mm;
            } else {
                int nn = n;
                for (int i = 0; i < m; i++) {
                    HashMap<Integer, Integer> map = new HashMap<>();
                    for (int j = 0; j < nn; j++) {
                        if (A[j][i] == 0) continue;
                        int val = 0;
                        if (map.containsKey(A[j][i])) {
                            val = map.get(A[j][i]);
                        }
                        val++;
                        map.put(A[j][i], val);
                    }
                    ArrayList<Pair> arr = new ArrayList<>();
                    for (Entry<Integer, Integer> e : map.entrySet()) {
                        arr.add(new Pair(e.getValue(), e.getKey()));
                    }
                    Collections.sort(arr);
                    int size = Math.min(arr.size(), 50);
                    for (int j = 0; j < size; j++) {
                        A[j * 2][i] = arr.get(j).cnt;
                        A[j * 2 + 1][i] = arr.get(j).index;
                    }
                    for (int j = size * 2; j < 100; j++) {
                        A[j][i] = 0;
                    }
                    if (nn < arr.size() * 2) {
                        nn = arr.size() * 2;
                    }
                }
                n = nn;
            }
            if (A[r][c] == k) {
                System.out.println(t);
                System.exit(0);
                break;
            }
        }
        System.out.println(-1);
    }
}
