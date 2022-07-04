package PS_2022.Programmers.level2.전화번호_목록;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/42577
 * 알고리즘: 소팅
 * 시간복잡도: O(nlogn), n=1,000,000(전화번호 목록의 길이)
 */
class Solution {
    public boolean solution(String[] pb) {
        Arrays.sort(pb);
        for(int i = 0; i < pb.length - 1; i++) {
            if(pb[i + 1].startsWith(pb[i])) return false;
        }
        return true;
    }
}