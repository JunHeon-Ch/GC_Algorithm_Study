import java.util.*;

public class 가사검색 {
    static Map<String, Integer> set = new HashMap<>();

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

//        for (int i = 0; i < words.length; i++) {
//            go_back(0, words[i].length(), words[i]);
//            go_front(0, words[i].length(), words[i]);
//        }

        int[] answer = new int[queries.length];
//        for (int i = 0; i < queries.length; i++) {
//            if (set.containsKey(queries[i])) {
//                answer[i] += set.get(queries[i]);
//            }
//        }
//        System.out.println(set);
//        System.out.println(Arrays.toString(answer));

        Trie[] tries = new Trie[10001];
        Trie[] rtries = new Trie[10001];

        for (String word : words) {
            int len = word.length();

            if (tries[len] == null)
                tries[len] = new Trie();
            tries[len].add(word.toCharArray());

            word = (new StringBuffer(word)).reverse().toString();

            if (rtries[len] == null)
                rtries[len] = new Trie();
            rtries[len].add(word.toCharArray());
        }

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int len = query.length();

            if (query.charAt(0) == '?') {
                if (rtries[len] == null) continue;
                query = (new StringBuffer(query)).reverse().toString();
                answer[i] = rtries[len].find(query.toCharArray());
            } else {
                if (tries[len] == null) continue;
                answer[i] = tries[len].find(query.toCharArray());
            }
        }
        System.out.println(Arrays.toString(answer));


    }

    static class Trie {
        int cnt;
        Trie[] child;

        Trie() {
            cnt = 0;
            child = new Trie[26];
        }


        Trie(int cnt, Trie[] child) {
            this.cnt = cnt;
            this.child = child;
        }

        void add(char[] str) {
            Trie current = this;
            for (char word : str) {
                current.cnt++;
                if (current.child[word - 'a'] == null) {
                    current.child[word - 'a'] = new Trie();
                }
                current = current.child[word - 'a'];
            }
        }

        int find(char[] query) {
            Trie current = this;
            for (char word : query) {
                if (word == '?') {
                    return current.cnt;
                }

                if (current.child[word - 'a'] != null) {
                    current = current.child[word - 'a'];
                } else {
                    return 0;
                }
            }
            return current.cnt;
        }
    }


    static void go_front(int index, int n, String word) {
        if (index == n) {
            return;
        }
        String str = "?";
        for (int i = 0; i < index; i++) {
            str += "?";
        }

        str = str + word.substring(index + 1);
        if (set.containsKey(str)) {
            set.put(str, set.get(str) + 1);
        } else {
            set.put(str, 1);
        }
        go_front(index + 1, n, str);
    }

    static void go_back(int index, int n, String word) {
        if (index == n) {
            return;
        }
        String str = "?";
        for (int i = 0; i < index; i++) {
            str += "?";
        }

        str = word.substring(0, n - index - 1) + str;
        if (set.containsKey(str)) {
            set.put(str, set.get(str) + 1);
        } else {
            set.put(str, 1);
        }
        go_back(index + 1, n, str);
    }

}
