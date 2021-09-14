package 푼문제;

import java.util.*;

public class 문제2 {
    public static void main(String[] args) {
        String[] research = {"yxxy", "xxyyy"};
        int n = 2;
        int k = 1;

        Set<Character> set = new HashSet<>();
        for (String z : research) {
            for (char c : z.toCharArray()) {
                set.add(c);
            }
        }
        List<Character> arrayList = new ArrayList<>(set);
        Map<Character, int[]> cnt = new HashMap<>();

        for (Character c : arrayList) {
            cnt.put(c, new int[research.length]);
        }


        for (int z = 0; z < research.length; z++) {
            for (int i = 0; i < research[z].length(); i++) {
                int[] s = cnt.get(research[z].charAt(i));
                s[z]++;
                cnt.put(research[z].charAt(i), s);
            }
        }

        for (Character s : cnt.keySet()) {
            System.out.println(Arrays.toString(cnt.get(s)));
        }
        ArrayList<Character> answer = new ArrayList<>();
        int maxTotal = 0;
        System.out.println(cnt.keySet());
        Map<Character, Integer> times = new HashMap<>();
        for (int i = 0; i < research.length; i++) {
            for (Character s : cnt.keySet()) {
                int[] z = cnt.get(s);

                if (i + n > research.length) continue;
                int total = 0;
                boolean flag = false;
                for (int w = i; w < i + n; w++) {
                    if (z[w] < k) {
                        flag = true;
                        break;
                    }
                    total += z[w];
                }
                if (!flag) {
                    if (total >= 2 * n * k) {
                        answer.add(s);
                        if (times.containsKey(s)) {
                            times.put(s, times.get(s) + 1);
                        } else {
                            times.put(s, 1);
                        }
                    }
                }
            }
        }

        HashSet<Character> set1 = new HashSet<>(answer);
        if (answer.size() != set1.size()) {
            int max = 0;
            char ans = 'z';
            for (Character s : times.keySet()) {
                if (times.get(s) > max) {
                    ans = s;
                    max = times.get(s);
                } else if (times.get(s) == max) {
                    if (ans > s) {
                        ans = s;
                    }
                }
            }
            System.out.println(ans+"");
        } else {
            answer.sort(Comparator.naturalOrder());
            if (answer.isEmpty()) {
                System.out.println("None");
            } else {
                answer.sort(Comparator.naturalOrder());
                System.out.println(answer.get(0).toString());
            }
        }
    }
}
