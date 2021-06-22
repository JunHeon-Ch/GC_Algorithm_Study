package 프로그래머스.카카오.level2.후보키.조합;// 조합

// 최소성 확인 후 유일성 확인

//package 프로그래머스.카카오.level2.후보키;

import java.util.ArrayList;

class Solution {
    ArrayList<String> mList = new ArrayList<>();
    static int answer = 0;

    public void checkCandidateKey(String[][] relation, boolean[] check) {
        // 최소성 검사
        String str = new String();
        for (int i = 0; i < check.length; i++) {
            if (check[i]) {
                if(mList.contains(i)) return;
                str += i;
            }
            if (mList.contains(str)) return;
        }
        mList.add(str);

        // 유일성 검사
        ArrayList<String> rList = new ArrayList<>();
        for (int i = 0; i < relation.length; i++) {
            String r = new String();
            for(int j = 0; j < str.length(); j++) {
                r += relation[i][str.charAt(j)];
                if(rList.contains(r)) return;
                rList.add(r);
            }
        }
        answer++;
    }

    public void combination(String[][] relation, boolean[] check, int index, int n, int r) {
        if (r == 0) {
            // 최소성 검사
            checkCandidateKey(relation, check);
            return;
        }
        if (index == n) return;

        check[index] = true;
        combination(relation, check, index + 1, n, r - 1);
        check[index] = false;
        combination(relation, check, index + 1, n, r);
    }

    public int solution(String[][] relation) {
        int col = relation[0].length;
        for (int i = 1; i <= col; i++) {
            boolean[] check = new boolean[col];
            combination(relation, check, 0, col, i);
        }

        return answer;
    }
}