package PS_2021.LG유플러스_수채_2022;

import java.util.*;

/*
 * 문제 설명
 * 오름차순으로 정렬된 3개의 배열에서 모두 등장하는 숫자 중 가장 큰 숫자를 반환하라 (모두 등장하는 숫자가 없을 경우 -1)

 * 알고리즘: 해시
 * 시간복잡도: O(n), n=arr1, arr2, arr3 배열 길이 중 최대 길이
 */

class Solution1 {

    public int solution(int[] arr1, int[] arr2, int[] arr3) {
        Map<Integer, Integer> map = new HashMap<>(); // 세 배열에서 나타나는 수를 저장하기 위한 HashMap<수, 등장 횟수>
        Set<Integer> set = new HashSet<>(); // 한 배열에 중복값을 제거하기 위해 HashSet 사용
        for(int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for(int i : set) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        set.clear();
        for(int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        for(int i : set) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        set.clear();
        for(int i = 0; i < arr3.length; i++) {
            set.add(arr3[i]);
        }
        for(int i : set) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for(int i : map.keySet()) {
            if(map.get(i) == 3) list.add(i);
        }
        Collections.sort(list, (o1, o2) -> o2 - o1);
        if(list.size() == 0) return -1;
        else return list.get(0);
    }
}
