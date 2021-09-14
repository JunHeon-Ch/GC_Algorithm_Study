package 푼문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class _파일명정렬 {

    public static void main(String[] args) {
        String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String[] tmp = files.clone();
        ArrayList<Name> list = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            // 1 대소문자
            files[i] = files[i].toLowerCase();

            // 2 split
            int s = 0;
            int e = 0;
            for (int j = 0; j < files[i].length(); j++) {
                if (files[i].charAt(j) >= '0' && files[i].charAt(j) <= '9') {
                    if (s == 0) {
                        s = j;
                        e++;
                    }
                    if (j != 0 && files[i].charAt(j - 1) >= '0' && files[i].charAt(j - 1) <= '9') {
                        e++;
                    }

                }
            }
            String header = files[i].substring(0, s);
            int num = Integer.parseInt(files[i].substring(s, s + e));
            list.add(new Name(tmp[i], header, num));

        }
        comparator cp = new comparator();
        Collections.sort(list, cp);
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).file;
            System.out.println(answer[i]);
        }

    }

    static class Name {
        String file;
        String header;
        int number;

        public Name(String file, String header, int number) {
            this.file = file;
            this.header = header;
            this.number = number;
        }
    }

    static class comparator implements Comparator<Name> {
        @Override
        public int compare(Name p1, Name p2) {
            if (p1.header.equals(p2.header)) {
                return p1.number - p2.number;
            }
            return p1.header.compareTo(p2.header);
        }
    }
}
