//package 프로그래머스.카카오.level2.뉴스_클러스터링;

import java.util.ArrayList;
import java.util.Collections;

class Solution {

    static final int NUM = 65536;

    public ArrayList<String> makePair(String str) {
        str = str.toLowerCase();

        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i + 2 <= str.length(); i++) {
            String tmp = str.substring(i, i + 2);
            if((int)tmp.charAt(0) < 'a' || (int)tmp.charAt(0) > 'z') continue;
            if((int)tmp.charAt(1) < 'a' || (int)tmp.charAt(1) > 'z') continue;
            list.add(tmp);
        }
        Collections.sort(list);

        return list;
    }

    public int solution(String str1, String str2) {
        ArrayList<String> list1 = makePair(str1);
        System.out.println(list1.toString());
        ArrayList<String> list2 = makePair(str2);
        System.out.println(list2.toString());
        if(list1.size() == 0 && list2.size() == 0) {
            return NUM;
        }

        int union = 0, intersection = 0;
        int i1 = 0, i2 = 0;
        while(true) {
            if(i1 == list1.size()) {
                union += list2.size() - i2;
                break;
            }
            if(i2 == list2.size()) {
                union += list1.size() - i1;
                break;
            }
            int comp = list1.get(i1).compareTo(list2.get(i2));
            if(comp == 0) {
                intersection++; union++;
                i1++; i2++;
            }
            else {
                if(comp < 0) i1++;
                else i2++;
                union++;
            }
        }

        double answer = (double)intersection / union * NUM;
        return (int)answer;
    }
}