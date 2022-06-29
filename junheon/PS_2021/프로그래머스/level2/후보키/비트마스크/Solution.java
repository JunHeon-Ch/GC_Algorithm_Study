package PS_2021.프로그래머스.level2.후보키.비트마스크;

import java.util.ArrayList;

public class Solution {

    public boolean checkMinimality(ArrayList<Integer> candidateKey, int comb) {
        for(int ck : candidateKey) {
            if((comb & ck) == ck) return false;
        }
        return true;
    }

    public boolean checkUniqueness(String[][] relation, int comb) {
        ArrayList<String> unique = new ArrayList<>();
        int row = relation.length;
        int col = relation[0].length;

        for (int i = 0; i < row; i++) {
            String str = new String();
            for(int j = 0; j < col; j++) {
                if((comb & (1 << j)) == 0) continue;
                str += relation[i][j];
            }
            if(unique.contains(str)) return false;
            unique.add(str);
        }
        return true;
    }

    public int solution(String[][] relation) {
        ArrayList<Integer> candidateKey = new ArrayList<>();

        int col = relation[0].length;

        for(int comb = 1; comb < (1 << col); comb++) {
            if(!checkMinimality(candidateKey, comb)) continue;
            if(!checkUniqueness(relation, comb)) continue;
            candidateKey.add(comb);
        }

        return candidateKey.size();
    }
}
