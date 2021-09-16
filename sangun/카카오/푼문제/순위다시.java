package 푼문제;

import java.util.*;

public class 순위다시 {
    static Map<String, ArrayList<Integer>> map;

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        map = new HashMap<>();

        for (String str : info) {
            String[] split = str.split(" ");
            go(split, 0, "");
        }
        for (String str : map.keySet()) {
            Collections.sort(map.get(str));
        }
        int[] answer = new int[info.length];
        int idx = 0;
        for (String str : query) {
            str = str.replace("and ", "");
            String[] split = str.split(" ");
            int score = Integer.parseInt(split[4]);
            str = str.replace(split[4], "");
            str = str.replace(" ", "");

            System.out.println(str);
            if (map.containsKey(str)) {
                ArrayList<Integer> scores = map.get(str);
                answer[idx++] = inbound(scores, score);
            }
        }
        System.out.println(Arrays.toString(answer));

    }

    static int inbound(ArrayList<Integer> scores, int score) {
        int low = 0;
        int high = scores.size();

        while (low < high) {
            int mid = (low + high) / 2;

            if (scores.get(mid) >= score) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }
        return scores.size() - high;
    }

    static void go(String[] split, int index, String result) {
        if (index == 4) {
            int score = Integer.parseInt(split[4]);
            if (map.containsKey(result)) {
                map.get(result).add(score);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(score);
                map.put(result, arr);
            }
            return;
        }

        go(split, index + 1, result + split[index]);
        go(split, index + 1, result + "-");

    }


}
