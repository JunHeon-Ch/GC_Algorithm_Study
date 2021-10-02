package 다시풀기;

import java.util.*;

public class 불량사용자 {
    static HashSet<String> set;
    static boolean[] visited;
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};
        visited = new boolean[user_id.length];
        set = new HashSet<>();
        go(user_id,banned_id,new ArrayList<>(),0);
        System.out.println(set.size());
    }
    static void go(String[] uid, String[] bid, ArrayList<String> result,int index){
        if(index == bid.length){
            Collections.sort(result);
            set.add(result.toString());
            return;
        }


        for(int i=0;i<uid.length;i++){
            if(visited[i])continue;
            if(bid[index].length()!=uid[i].length())continue;
            if(valid(uid[i],bid[index])){
                visited[i]=true;
                result.add(uid[i]);
                go(uid,bid,result,index+1);
                result.remove(uid[i]);
                visited[i]=false;
            }

        }


    }
    static boolean valid(String uid,String bid){
        for(int i=0;i<uid.length();i++){
            if(uid.charAt(i)==bid.charAt(i))continue;
            if(bid.charAt(i)=='*')continue;
            return false;
        }
        return true;
    }
}