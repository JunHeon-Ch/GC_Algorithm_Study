package PS_2021.프로그래머스.level3.매칭_점수;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/42893
 * 알고리즘: 문자열
 * 진짜 별로다
 */

class Solution {
    public int solution(String word, String[] pages) {
        int n = pages.length;
        int[] planeScore = new int[n]; // 기본점수 배열 -> 해당 웹페이지의 텍스트 중, 검색어가 등장하는 횟수
        int[] linkCnt = new int[n]; // 외부 링크 수 배열 -> 해당 웹페이지에서 다른 외부 페이지로 연결된 링크의 개수
        double[] linkScore = new double[n]; // 링크점수 배열 -> 해당 웹페이지로 링크가 걸린 다른 웹페이지의 기본점수 ÷ 외부 링크 수의 총합

        word = word.toLowerCase(); // 대소문자 구분 X
        Map<String, Integer> index = new HashMap<>(); // url과 index 매핑시켜주기 위한 map
        // url과 index 매핑
        for(int i = 0; i < n; i++) {
            String page = pages[i].substring(pages[i].indexOf("<meta property=\"og:url\" content="));
            int metaIdx = page.indexOf("https://");
            String url = page.substring(metaIdx, page.indexOf("\"/>", metaIdx));
            index.put(url, i);
        }

        // 기본점수, 외부 링크 수 찾기 위한 반복문
        for(int i = 0; i < n; i++) {
            String page = pages[i];
            int sBodyIdx = page.indexOf("<body>");
            int eBodyIdx = page.indexOf("</body>");
            String body = page.substring(sBodyIdx + 6, eBodyIdx);

            // body 내의 외부 링크 찾기
            int sIdx = body.indexOf("<a href=\"");
            while(sIdx != -1) {
                linkCnt[i]++;
                int eIdx = body.indexOf("</a>", sIdx);
                body = body.replace(body.substring(sIdx, eIdx + 4), "");
                sIdx = body.indexOf("<");
            }

            // body 내의 외부 링크를 제외하고 word와 일치하는 단어 찾기
            for(String str : body.toLowerCase().split("[^a-z]")) {
                if(word.equals(str)) planeScore[i]++;
            }
        }

        // 링크점수 찾기 위한 반복문
        for(int i = 0; i < n; i++) {
            String page = pages[i];
            int sBodyIdx = page.indexOf("<body>");
            int eBodyIdx = page.indexOf("</body>");
            String body = page.substring(sBodyIdx + 6, eBodyIdx);
            int sIdx = body.indexOf("<a href=\"");
            while(sIdx != -1) {
                int eIdx = body.indexOf("\">", sIdx);
                String link = body.substring(sIdx + 9, eIdx);
                body = body.substring(eIdx);
                sIdx = body.indexOf("<a href=\"");

                int idx = index.containsKey(link) ? index.get(link) : -1;
                if(idx == -1) continue;
                linkScore[idx] += (float) planeScore[i] / linkCnt[i];
            }
        }

        double[] matchScore = new double[n]; // 매칭점수 배열
        for(int i = 0; i < n; i++) {
            matchScore[i] += planeScore[i] + linkScore[i];
        }

        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(matchScore[idx] < matchScore[i]) idx = i;
        }
        return idx;
    }
}