package 푼문제;

import java.util.HashMap;
import java.util.Map;

public class 호텔방배정 {
    static Map<Long, Long> map;

    public static void main(String[] args) {
        long k = 10;
        long[] room_number = {1, 3, 4, 1, 3, 1};


        long[] answer = new long[room_number.length];
        map = new HashMap<>();

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = get(map, room_number[i]);
            map.put(answer[i], answer[i] + 1);
        }

        System.out.println(map);

    }

    // 부모 찾기
    static long get(Map<Long, Long> parent, long x) {
        if (parent.get(x) == null) return x;
        else {
            parent.put(x, get(parent, parent.get(x)));
            return parent.get(x);
        }
    }

//    // 두 노드의 부모를 합치는 함수
//    static void union(Map<Long, Long> parent, long a, long b) {
//        a = get(parent, a);
//        b = get(parent, b);
//
//        if (b > a) {
//            parent.put(a, b);
//        } else {
//            parent.put(b, a);
//        }
//    }
//
//    // 두 노드가 같은 부모를 가지는지
//    static boolean find(int[] parent, int a, int b) {
//        a = get(parent, a);
//        b = get(parent, b);
//
//        if (a == b) return true;
//        return false;
//    }

}



