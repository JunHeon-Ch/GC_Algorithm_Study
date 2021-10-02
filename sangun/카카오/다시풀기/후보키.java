package 다시풀기;

import java.util.ArrayList;
import java.util.HashSet;

public class 후보키 {
    static ArrayList<HashSet<Integer>> list;

    public static void main(String[] args) {
        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};

        list = new ArrayList<>();
        int col = relation[0].length;
        go(0, col, new HashSet<>(), relation);
        System.out.println(list.size());

    }

    static void go(int index, int n, HashSet<Integer> seq, String[][] relation) {
        if (index >= n) {
            // 최소성 검사
            for (HashSet<Integer> k : list) {
                if (seq.containsAll(k)) return;
            }

            if (valid(seq, relation)) {
                list.add(new HashSet<>(seq));
            }
            return;
        }


        go(index + 1, n, seq, relation);
        seq.add(index);
        go(index + 1, n, seq, relation);
        seq.remove(index);
    }
    // 유일성 검사
    static boolean valid(HashSet<Integer> seq, String[][] relation) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            String key = "";
            for (int j : seq) {
                key += relation[i][j];
            }
            if (set.contains(key)) {
                return false;
            }
            set.add(key);
        }
        return true;
    }
}