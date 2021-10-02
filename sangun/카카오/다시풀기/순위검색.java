package 다시풀기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 순위검색 {
    static HashMap<String, ArrayList<Integer>> map;

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        map = new HashMap<>();
        for (String str : info) {
            String[] split = str.split(" ");
            go(split, "", 0, 0);
        }
        for (ArrayList<Integer> arr : map.values()){
            Collections.sort(arr);
        }

        int[] answer = new int[query.length];
        int idx = 0;
        for (String q : query) {
            String str = q.replace("and", "").replace(" ", "").replaceAll("[0-9]", "");
            int num = Integer.parseInt(q.replace(" ", "").replaceAll("[a-z,\\-]", ""));
            if (map.containsKey(str)) {
                ArrayList<Integer> arr = map.get(str);
                answer[idx] = inbound(arr, num);
            }
            idx++;
        }
        System.out.println(Arrays.toString(answer));

    }

    static int inbound(ArrayList<Integer> arr, int n) {
        int left = 0;
        int right = arr.size();
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;

            if (arr.get(mid) >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr.size() - right;

    }

    static void go(String[] info, String ans, int index, int selected) {
        if (selected == 4) {
            ArrayList<Integer> tmp = new ArrayList<>();
            if (map.containsKey(ans)) {
                tmp =map.get(ans);
            }
            tmp.add(Integer.parseInt(info[4]));
            map.put(ans, tmp);
            return;
        }

        go(info, ans + info[index], index + 1, selected + 1);
        go(info, ans + "-", index + 1, selected + 1);

    }
}
