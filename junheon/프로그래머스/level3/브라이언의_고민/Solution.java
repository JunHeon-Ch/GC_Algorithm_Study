package 프로그래머스.level3.브라이언의_고민;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/1830
* 알고리즘: 문자열
* 미해결 문제
 */

class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.solution("AaAaAbBbBbB"));
        System.out.println(solution.solution("aIaAM"));
        System.out.println(solution.solution("aAbAbAacAaAc"));
        System.out.println(solution.solution("AaABaBaB"));
        System.out.println(solution.solution("AaAbBBb"));
        System.out.println(solution.solution("AaAaAbB"));
        System.out.println(solution.solution("AaAaAbB"));
        System.out.println(solution.solution("AaAaAbB"));
        System.out.println(solution.solution("AaAaAbB"));
        System.out.println(solution.solution("AaAaAbB"));
        System.out.println(solution.solution("AaAaAbB"));
    }
}

class Solution {
    public String solution(String sentence) {
        String invalid = "invalid";
        // 공백이 있으면 invalid
        if (sentence.indexOf(' ') != -1) return invalid;
        List<String> correct = new ArrayList<>();
        boolean[] used = new boolean[26];
        while (!sentence.equals("")) {
            // 소문자 위치 찾기
            Alpha alpha = findLowerChar(sentence);

            // 소문자가 없는 경우
            if (alpha == null) {
                correct.add(sentence);
                break;
            }
            // 오류: 이전에 사용됐던 소문자의 경우 다시 사용할 경우 invalid
            if(used[alpha.ch - 'a']) return invalid;
            used[alpha.ch - 'a'] = true;
            // 해당 character 개수 찾기
            int cnt = countChar(sentence, alpha.ch);
            // 규칙 2: 특정 단어 앞뒤로 같은 소문자가 있는 경우
            if (cnt == 2) {
                // 규칙 2로 이루어진 단어 앞에 대문자로만 이루어진 단어가 있는 경우
                if (alpha.idx > 0) {
                    correct.add(sentence.substring(0, alpha.idx));
                }
                int lastIdx = sentence.lastIndexOf(alpha.ch);
                // 오류: 소문자 2개가 붙어 있는 경우
                if (alpha.idx + 1 == lastIdx) return invalid;
                String tmp = sentence.substring(alpha.idx + 1, lastIdx);
                alpha = findLowerChar(tmp);
                if (alpha == null) { // 소문자가 없는 경우
                    correct.add(tmp);
                } else { // 소문자가 있는 경우 -> 규칙 1 확인
                    if (!valid(tmp)) return invalid;
                    // 오류: 이전에 사용됐던 소문자의 경우 다시 사용할 경우 invalid
                    if(used[alpha.ch - 'a']) return invalid;
                    used[alpha.ch - 'a'] = true;
                    correct.add(tmp.replace(String.valueOf(alpha.ch), ""));
                }
                if (lastIdx + 1 >= sentence.length()) break;
                sentence = sentence.substring(lastIdx + 1);
            }
            // 규칙 1: 단어의 글자 사이마다 같은 소문자가 들어있는 경우
            else {
                if (sentence.charAt(0) >= 'a' && sentence.charAt(0) <= 'z') return invalid;
                int lastIdx = sentence.lastIndexOf(alpha.ch);
                if (alpha.idx - 1 > 0) {
                    correct.add(sentence.substring(0, alpha.idx - 1));
                }
                String tmp = sentence.substring(alpha.idx - 1, lastIdx + 2);
                if (!valid(tmp)) return invalid;
                correct.add(tmp.replace(String.valueOf(alpha.ch), ""));
                if (lastIdx + 2 >= sentence.length()) break;
                sentence = sentence.substring(lastIdx + 2);
            }
//            System.out.println(sentence);
        }

        String answer = "";
        for (String word : correct) {
            answer += word + " ";
        }
        return answer.substring(0, answer.length() - 1);
    }

    // 규칙1만 가지는 단어에서 valid/invalid 판단
    public boolean valid(String str) {
        // 1. 첫번째 문자가 대문자여야 한다.
        if (str.charAt(0) >= 'a' && str.charAt(0) <= 'z') return false;
        char alpha = 0;
        // 2. 대소문자가 번갈아 나타나야 한다.
        // false: 소문자
        // true: 대문자
        boolean upper = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                // 3. 둘 이상의 소문자가 나타나면 안 된다.
                if (alpha == 0) {
                    alpha = str.charAt(i);
                } else if (alpha != str.charAt(i)) {
                    return false;
                }
                if (!upper) return false;
                upper = false;
            } else {
                if (upper) return false;
                upper = true;
            }
        }
        return true;
    }

    // 소문자 위치 찾기
    public Alpha findLowerChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                return new Alpha(i, str.charAt(i));
            }
        }
        return null;
    }

    // 해당 character 개수 찾기
    public int countChar(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }
}

class Alpha {
    int idx;
    char ch;

    public Alpha(int idx, char ch) {
        this.idx = idx;
        this.ch = ch;
    }
}