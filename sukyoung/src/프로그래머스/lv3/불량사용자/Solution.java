package 프로그래머스.lv3.불량사용자;

import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public HashSet<HashSet<String>> result;
    public ArrayList<ArrayList<String>> banList;
    public boolean[] visit;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        banList = new ArrayList<ArrayList<String>>();
        for(String ban: banned_id){
            ArrayList<String> list = new ArrayList<>();

            String banId = ban.replace("*", ".");
            for(String uId : user_id){
                if(Pattern.matches(banId, uId))
                    list.add(uId);
            }
            banList.add(list);
        }

        result = new HashSet<HashSet<String>>();
        combi(new HashSet<String>(), 0);

        return result.size();
    }
    public void combi(HashSet<String> able, int depth){
        if(depth == banList.size()){
            //result.add(able) 하면 한개 실패뜸 왜와이
            result.add(new HashSet<>(able));
            return;
        }

        for(String id: banList.get(depth)){
            if(!able.contains(id)){
                able.add(id);
                combi(able, depth+1);
                able.remove(id);
            }
        }
    }
}
