import java.util.*;

public class 튜플 {
    static class Compare implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }


    }

    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        s = s.replace("{", "");
        String[] str = s.split("},");
        str[str.length - 1] = str[str.length - 1].replace("}", "");

        Arrays.sort(str, new Compare());


        Map<Integer, Integer> map = new HashMap<>();
        map.put(Integer.parseInt(str[0]), 1);
        for (int i = 0; i < str.length - 1; i++) {
            String[] split = str[i + 1].split(",");
            for (String k : split) {
                if (map.containsKey(Integer.parseInt(k))) {
                    map.replace(Integer.parseInt(k), map.get(Integer.parseInt(k)) + 1);
                } else {
                    map.put(Integer.parseInt(k), 1);
                }
            }
        }

        int[] answer = new int[str.length];
        for (int key : map.keySet()) {
            answer[Math.abs(map.get(key) - str.length)] = key;
        }

        for (int k:answer){
            System.out.print(k+" ");
        }
    }
}
