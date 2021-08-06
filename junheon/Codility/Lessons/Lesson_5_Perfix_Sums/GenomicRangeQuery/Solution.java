package Codility.Lessons.Lesson_5_Perfix_Sums.GenomicRangeQuery;

class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        int[][] nuc = new int[S.length() + 1][4];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            for (int j = 0; j < 4; j++) {
                nuc[i + 1][j] = nuc[i][j];
            }
            if (c == 'A') nuc[i + 1][0]++;
            else if (c == 'C') nuc[i + 1][1]++;
            else if (c == 'G') nuc[i + 1][2]++;
            else if (c == 'T') nuc[i + 1][3]++;
        }

        int[] ans = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (nuc[Q[i] + 1][j] - nuc[P[i]][j] > 0) {
                    ans[i] = j + 1;
                    break;
                }
            }
        }
        return ans;
    }
}

