import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(bfs(words,begin,target));

    }

    static int bfs(String[] words, String begin, String target) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(begin, new HashSet<>(), 0));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            String word = p.w;
            HashSet<String> set = p.set;
            if (word.equals(target)) {
                return p.cnt;
            }
            for (String str : words) {
                if (set.contains(str)) continue;
                if (check(word, str)) {
                    HashSet<String> nSet = new HashSet<String>(set);
                    nSet.add(str);
                    q.add(new Pair(str, nSet, p.cnt + 1));
                }

            }
        }
        return 0;

    }

    static boolean check(String word, String after) {
        String str = "";
        for (int k = 0; k < word.length(); k++) {
            for (char i = 'a'; i <= 'z'; i++) {
                str = word.substring(0, k) + i + word.substring(k + 1);
                if (str.equals(after)) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Pair {
        String w;
        HashSet<String> set;
        int cnt;

        public Pair(String w, HashSet<String> set, int cnt) {
            this.w = w;
            this.set = set;
            this.cnt = cnt;
        }
    }
}
