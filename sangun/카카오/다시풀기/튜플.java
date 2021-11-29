package 다시풀기;

import java.util.ArrayList;
import java.util.Arrays;

public class 튜플 {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        s = s.substring(1, s.length() - 1);

        ArrayList<Integer>[] ss = new ArrayList[s.length()];

        int cnt = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                start = i;
                cnt++;
            }
            if (s.charAt(i) == '}') {
                String[] str = s.substring(start + 1, i).split(",");
                ss[str.length] = new ArrayList<>();
                for (String k : str) {
                    ss[str.length].add(Integer.parseInt(k));
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(ss[1].get(0));
        for (int i = 1; i < cnt; i++) {

            for (int j = 0; j < ss[i+1].size(); j++) {
                if (!ss[i].contains(ss[i + 1].get(j))) {
                    ans.add(ss[i + 1].get(j));
                }
            }
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i]= ans.get(i);

        }
        System.out.println(Arrays.toString(answer));
    }
}
