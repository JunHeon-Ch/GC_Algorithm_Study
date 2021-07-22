import java.util.*;

public class _순위검색 {
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        int[] answer;
        answer = new int[query.length];

        for (int i = 0; i < info.length; i++) {
            String[] split = info[i].split(" ");
            go(0, "", split, Integer.parseInt(split[4]));
        }
        for (String key : map.keySet()) {
            ArrayList<Integer> arr = map.get(key);
            Collections.sort(arr);
        }

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replace("and ", "");
            String[] split = query[i].split(" ");
            int score = Integer.parseInt(split[4]);
            query[i] = query[i].replace(split[4], "");
            query[i] = query[i].replace(" ", "");

            if (map.containsKey(query[i])) {
                ArrayList<Integer> arr = map.get(query[i]);
                int ans = lower_bound(arr, score);
                answer[i] = ans;
            }
        }

        for (int k : answer) {
            System.out.print(k + " ");
        }

    }

    static int lower_bound(ArrayList<Integer> arr, int score) {
        int start = 0;
        int end = arr.size();
        while (start < end) {
            int mid = (start + end) / 2;

            if (arr.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return arr.size() - end;
    }

    static void go(int index, String result, String[] str, int score) {
        if (index == 4) {
            ArrayList<Integer> arr = new ArrayList<>();
            if (map.containsKey(result)) {
                arr = map.get(result);
            }
            arr.add(score);
            map.put(result, arr);
            return;
        }

        go(index + 1, result + str[index], str, score);
        go(index + 1, result + "-", str, score);
    }


}
