package 다시풀기;

import java.util.ArrayList;

public class 뉴스클러스터링 {
    public static void main(String[] args) {
        String str1 = "handshake";
        String str2 = "shake hands";

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<String> word1 = new ArrayList<>();
        ArrayList<String> word2 = new ArrayList<>();
        make(str1, word1);
        make(str2, word2);

        double value2 = word2.size() + word1.size();
        int value1 = find(word1, word2);
        value2 -= value1;
        if (value1 == 0 && value2 == 0) {
            value1 = 1;
            value2 = 1;
        }
        double j = value1 / value2;
        int answer = (int) (j * 65536);
        System.out.println(answer);

    }

    static int find(ArrayList<String> word1, ArrayList<String> word2) {
        int len = word1.size();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (word2.contains(word1.get(i))) {
                word2.remove(word1.get(i));
                cnt++;
            }
        }
        return cnt;
    }

    static void make(String str, ArrayList<String> word1) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (!(str.charAt(i) >= 'a' && str.charAt(i) <= 'z')) continue;
            if (!(str.charAt(i + 1) >= 'a' && str.charAt(i + 1) <= 'z')) continue;
            word1.add(str.substring(i, i + 2));
        }
    }
}
