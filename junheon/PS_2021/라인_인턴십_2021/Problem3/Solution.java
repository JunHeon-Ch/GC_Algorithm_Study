package PS_2021.라인_인턴십_2021.Problem3;

/*
 * 알고리즘: 문자열, 구현
 * 0~9까지 배열로 비트값을 저장해 반복문을 통해 비교함
 * String을 주로 사용하는 로직에서는 StringBuilder를 사용하자
 * 시간복잡도: O(n), n=3000(pixels의 각 문자열의 길이)
 */

class Solution {
    public String solution(String[] pixels) {
        String[][] digit = new String[][]{
                {"111", "101", "101", "101", "111"}, // 0
                {"110", "010", "010", "010", "111"}, // 1
                {"111", "001", "111", "100", "111"}, // 2
                {"111", "001", "111", "001", "111"}, // 3
                {"101", "101", "111", "001", "001"}, // 4
                {"111", "100", "111", "001", "111"}, // 5
                {"111", "100", "111", "101", "111"}, // 6
                {"111", "101", "001", "001", "001"}, // 7
                {"111", "101", "111", "101", "111"}, // 8
                {"111", "101", "111", "001", "111"}}; // 9
        StringBuilder answer = new StringBuilder();
        // 가로 길이 3, 세로 길이 5
        for(int k = 3; k <= pixels[0].length(); k += 3) {
            String[] d = new String[5];
            for(int i = 0; i < pixels.length; i++) {
                d[i] = pixels[i].substring(k - 3, k);
            }
            for(int i = 0; i < digit.length; i++) {
                boolean correct = true;
                for(int j = 0; j < 5; j++) {
                    if(!digit[i][j].equals(d[j])) {
                        correct = false;
                        break;
                    }
                }
                if(correct) {
                    answer.append(i);
                    break;
                }
            }
        }
        return answer.toString();
    }
}