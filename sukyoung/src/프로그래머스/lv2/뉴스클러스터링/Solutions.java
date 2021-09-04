package 프로그래머스.lv2.뉴스클러스터링;
import java.util.*;

class Solution {
    public ArrayList<String> sets;
    public int solution(String str1, String str2) {
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();

        String[] str1_words = new String[str1.length()];
        for(int i=0; i<str1.length(); i++)
            str1_words[i] = String.valueOf(str1.charAt(i));

        makeSet(str1_words);
        ArrayList<String> str1_sets = new ArrayList<>();
        for(int i=0; i<sets.size(); i++){
            str1_sets.add(sets.get(i).toUpperCase());
        }

        String[] str2_words = new String[str2.length()];
        for(int i=0; i<str2.length(); i++)
            str2_words[i] = String.valueOf(str2.charAt(i));

        makeSet(str2_words);
        ArrayList<String> str2_sets = new ArrayList<>();
        for(int i=0; i<sets.size(); i++){
            str2_sets.add(sets.get(i).toUpperCase());
        }

        Collections.sort(str1_sets);
        Collections.sort(str2_sets);

        for(String s : str1_sets){
            if(str2_sets.remove(s)){
                intersection.add(s);
            }
            union.add(s);
        }

        for(String s : str2_sets){
            union.add(s);
        }

        double jakard = 0;

        if(union.size() == 0) {
            jakard = 1;
        } else {
            jakard = (double)intersection.size() / (double)union.size();
        }

        return (int)(jakard * 65536);
    }

    public void makeSet(String[] str_words){
        sets = new ArrayList<>();

        for(int i=0; i<str_words.length-1; i++){
            StringBuilder sb = new StringBuilder();
            if(isAlphabet(str_words,i)){
                sb.append(str_words[i]);
                sb.append(str_words[i+1]);
                sets.add(sb.toString());
            }
        }
    }

    public boolean isAlphabet (String[] str_words, int i ){
        if ((str_words[i].charAt(0) >= 'a' && str_words[i].charAt(0) <= 'z')
                || (str_words[i].charAt(0) >= 'A' && str_words[i].charAt(0) <= 'Z')){
            if((str_words[i+1].charAt(0) >= 'a' && str_words[i+1].charAt(0) <= 'z')
                    || (str_words[i+1].charAt(0) >= 'A' && str_words[i+1].charAt(0) <= 'Z')){
                return true;
            }
            else return false;
        }
        else return false;
    }
}